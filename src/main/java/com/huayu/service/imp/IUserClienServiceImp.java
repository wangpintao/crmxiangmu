package com.huayu.service.imp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.User;
import com.huayu.pojo.UserClien;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserClienServiceImp extends IService<UserClien>{
 public UserClien selectId(Integer ucid);
 public List<UserClien> listUser();
 Stulayui queryMany(Integer page, Integer limit, @Param("clientid")Integer clientid, @Param("keys")String keys);
 UserClien queryByid(Integer ucid);
}
