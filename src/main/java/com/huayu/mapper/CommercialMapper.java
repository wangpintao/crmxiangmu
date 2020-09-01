package com.huayu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.UserClien;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommercialMapper extends BaseMapper<Commercial> {

  public UserClien selectId(Integer ucid);
}
