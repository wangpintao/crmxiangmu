package com.huayu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.pojo.CliBusiness;
import com.huayu.pojo.CliSource;
import com.huayu.pojo.User;
import com.huayu.pojo.UserClien;
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
  @Result(column = "city",property = "city"),
  @Result(column = "csite",property = "csite"),
  @Result(column = "cli_contacts",property = "cliContacts"),
  @Result(column = "cli_department",property = "cliDepartment"),
  @Result(column = "cli_job",property = "cliJob"),
  @Result(column = "cli_offphone",property = "cliOffphone"),
  @Result(column = "cli_qq",property = "cliqq"),
  @Result(column = "cli_phone",property = "cliPhone"),
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



 @Results({
  @Result(column = "city",property = "city"),
  @Result(column = "csite",property = "csite"),
  @Result(column = "cli_contacts",property = "cliContacts"),
  @Result(column = "cli_department",property = "cliDepartment"),
  @Result(column = "cli_job",property = "cliJob"),
  @Result(column = "cli_offphone",property = "cliOffphone"),
  @Result(column = "cli_qq",property = "cliqq"),
  @Result(column = "cli_phone",property = "cliPhone"),
  @Result(column = "clsname",property = "cliSource.clsname"),
  @Result(column = "clibusname",property = "cliBusiness.clibusname")
 })
 @Select("select * from user_clien u,cli_source s,cli_business b where u.souid=s.clsid and u.busid=b.clibusid and u.ucid=#{ucid}")
 public UserClien selectIds(Integer ucid);
}
