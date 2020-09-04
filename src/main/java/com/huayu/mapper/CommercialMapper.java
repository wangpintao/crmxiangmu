package com.huayu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.UserClien;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommercialMapper extends BaseMapper<Commercial> {

 @Update("update commercial set coname_cliname=#{conameCliNname},coname=#{coname}, com_sum=#{comSum},com_date=#{comDate} , com_file=#{comFile},com_text=#{comText}, com_depid=#{comDepid},com_uname=#{comUname} , com_participant=#{comParticipant},com_follower=#{comFollower} where coid=#{coid}")
 public boolean updatec(Commercial commercial);


}
