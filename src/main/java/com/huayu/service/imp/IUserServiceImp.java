package com.huayu.service.imp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface IUserServiceImp extends IService<User>{
    @Select("select uid from user where username =#{username}")
    Integer queryNameByID(String username);
}
