package com.huayu.service.imp;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.Forum;
import com.huayu.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IForumServiceImp extends IService<Forum>{
    public Integer updateone(Forum forum);

    public Integer updateone1(Forum forum);

    public Integer updateone2(Forum forum);

    public Stulayui queryall(Integer page, Integer limit, Forum forum);
}
