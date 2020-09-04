package com.huayu.service.imp;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.bo.AfterSaleBo;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.AfterSale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAfterSaleServiceImp extends IService<AfterSale>{
    Stulayui queryMany(Integer page, Integer limit, AfterSale afterSale);
    AfterSaleBo queryAllDetail(Integer aftid);
    Stulayui queryBya(Integer page, Integer limit, AfterSale afterSale,String calssType,String key,String value);
    Stulayui newWeek(Integer page, Integer limit);
    List<AfterSale> newMonth();
    List<AfterSale> newSeason();
}
