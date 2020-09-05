package com.huayu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.huayu.pojo.*;
import com.huayu.sqlUtils.ClientSql;
import com.huayu.sqlUtils.salesql;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@Mapper
public interface UserClienMapper extends BaseMapper<UserClien> {
 @Results({
  @Result(column = "souid",property = "souid"),
  @Result(column = "busid",property = "busid"),
  @Result(column = "souid",property = "cliSource",one =@One(select = "souqueryone",fetchType = FetchType.EAGER)),
  @Result(column = "busid",property = "cliBusiness",one =@One(select = "busqueryone",fetchType = FetchType.EAGER))
 })
 @Select("select * from user_clien where ucid=#{value}")
 public UserClien selectId(Integer ucid);

 @Results({@Result(column ="clsid",property ="clsid"),
  @Result(column ="clsname",property ="clsname")
})
 @Select("select * from cli_source where clsid=#{value}")
 public CliSource souqueryone(Integer souid);

 @Results({@Result(column ="clibusid",property ="clibusid"),
  @Result(column ="clibusname",property ="clibusname")
  })
 @Select("select * from cli_business where clibusid=#{value}")
 public CliBusiness busqueryone(Integer busid);

 @Select("select ucid,cli_name from user_clien")
public List<UserClien> listUser();



 @Select("select * from user_clien where ucid=#{ucid}")
 UserClien queryByid(Integer ucid);

 @Update("update user_clien set cli_name=#{cliName} , cli_pinyin=#{ cliPinyin}, kinid=#{kinid}, souid=#{souid} ,busid=#{busid}, curl=#{curl} , cstate=#{cstate} , city=#{city}, csite=#{csite}, cli_mail=#{cliMail} , cli_fax=#{cliFax} , cli_contacts=#{cliContacts} , cli_department=#{cliDepartment} , cli_job=#{cliJob} , cli_offphone=#{cliOffphone} , cli_qq=#{cliqq} , cli_phone=#{cliPhone} , cli_legalperson=#{cliLegalperson} ,cli_amount=#{cliAmount} , cli_text=#{cliText} where ucid=#{ucid}")
 public boolean updatecl(UserClien userClien);

}
