package com.huayu.service.imp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.pojo.User;
import com.huayu.pojo.UserClien;

import java.util.List;

public interface IUserClienServiceImp extends IService<UserClien>{
 public UserClien selectId(Integer ucid);
 public List<UserClien> listUser();
}
