package com.huayu.poiUtils;

import ognl.Ognl;
import ognl.OgnlException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExelUtils {
    /**数据库里向Excle表格导入*/
    public static Workbook poiDataExport(Map<String,String> map , List<?> list) throws OgnlException, ParseException {
        //创建一个Excle表格
        Workbook wk = new HSSFWorkbook();
        //创建当前页
        Sheet sheet = wk.createSheet();
        //创建第一行
        Row row = sheet.createRow(0);
        //根据map里面的键值对来去key值，key对应的有value值也就是表头值
        //然后把key值防到set集合中,(因为set可以去重复所以可以避免取到重复的key)
        Set<String> keys = map.keySet();
        int num = 0;
        //遍历set集合
        for (String key : keys)
        {
            //创建单元格从0开始自加
            Cell cell = row.createCell(num++);
            //
            cell.setCellValue(key);
        }
        for(int i=0;i< list.size();i++){
            num=0;
            row = sheet.createRow(i+1);
            for(String key0:map.keySet()){
                Cell cell = row.createCell(num++);
                String data = Ognl.getValue(map.get(key0), list.get(i))+"";
                if(data.contains("CST")){
                    SimpleDateFormat sdf1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
                    Date date = sdf1.parse(data);
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String sDate=sdf.format(date);
                    data = sDate;
                }
                cell.setCellValue(data);
            }
        }
        return wk;
    }

    /**Excle表格向数据库中导入
     * 需要一个输入流，和一个导入的对象类型
     * @throws OgnlException
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ParseException */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List poiDataImport(InputStream is , Class<?> clazz)
            throws Exception {
        //创建Exel文件
        Workbook wk = WorkbookFactory.create(is);
        //拿到Exel文件里面的sheet页也就是当前页
        Sheet sheet = wk.getSheetAt(0);
        //拿到当前页里面多少行
        int rowCount = sheet.getLastRowNum();
        //集合接收不解释
        List lists = new ArrayList();
        //getDeclaredFields()：获得某个类的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段
        Field[] fields = clazz.getDeclaredFields();
        //从1开始循环不拿表头
        for(int i=1;i<=rowCount;i++){
            //创建传入的当前对象
            Object obj = clazz.newInstance();
            //拿到下标每一行
            Row row = sheet.getRow(i);
            //根据fields里面拿到对象参数个数长度来循环
            for(int j=0;j<fields.length;j++){
                String string = null;
                //判断行不等空  ‘并且’  每行的单元格不等于空
                if(row != null && row.getCell(j)!=null){
                    //拿到下标每一个单元格
                    Cell cell = row.getCell(j);
                    //‘获取’表格数据
                    string = getXCellVal(cell);
                }
                //判断单元格数据不为空   ‘并且’   单元格的值不能小于一条
                if(string !=null && string.length() > 0) {
                    //fields[j].getType()拿到每个参数的类型
                    //getType() 获取属性声明时类型对象（返回class对象）
                    Object value = getValue(fields[j].getType(), string);
                    //还是对象不能为空
                    if(value!=null){

                        fields[j].setAccessible(true);//设置能够访问私有的方法
                        fields[j].set(obj,value);
                    }
                }
            }
            //判断创建对象和传入对象如果为真
            if(isObject(obj,clazz)){
                //添加add到集合中，
                // 拿到集合对象直接在controller层操作批量添加到数据库中
                lists.add(obj);
            }
        }
        return lists;
    }

    /**
     * 导入的类型处理
     * */
    private static <T> T getValue(Class<?> clazz,String str) throws ParseException
    {
        if(clazz==Integer.class){
            return  (T)  Integer.valueOf(str);
        }else if(clazz==Long.class){
            return  (T) Long.valueOf(str);
        }
        else if(clazz==Date.class){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return (T) sdf.parse(str);
        } else if(clazz == Double.class) {
            return (T) Double.valueOf(str);
        } else{
            return (T) str;

        }
    }

    /**
     * 读取表格数据的类型进行格式修
     * */
    private static String getXCellVal(Cell cell) {
        String val = null;
        Format fmt = new SimpleDateFormat();
        Format df = new DecimalFormat();
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    val = fmt.format(cell.getDateCellValue()); //日期型
                } else {
                    String format = df.format(cell.getNumericCellValue());//数字型
                    val = format.replaceAll(",","");
                }
                break;
            case Cell.CELL_TYPE_STRING: //文本类型
                val = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN: //布尔型
                val = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_BLANK: //空白
                val = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_ERROR: //错误
                val = "错误";
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                try {
                    val = String.valueOf(cell.getStringCellValue());
                } catch (IllegalStateException e) {
                    val = String.valueOf(cell.getNumericCellValue());
                }
                break;
            default:
                val = cell.getRichStringCellValue() == null ? null : cell.getRichStringCellValue().toString();
        }
        return val;
    }

    /**
     * 判断是否是一个有效的对象
     * */
    private static boolean isObject(Object obj, Class clazz) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if(field.get(obj) != null
                    && (field.get(obj).toString()).length() > 0){
                return true;
            }
        }
        return false;
    }
}
