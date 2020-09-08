package com.huayu.service.imp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.pojo.Forum;
import com.huayu.pojo.Permission;

public interface IForumServiceImp extends IService<Forum>{
    public Integer updateone(Forum forum);

    public Integer updateone1(Forum forum);

    public Integer updateone2(Forum forum);
}
