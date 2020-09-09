package com.huayu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.ForumMapper;
import com.huayu.mapper.PermissionMapper;
import com.huayu.pojo.Forum;
import com.huayu.pojo.Permission;
import com.huayu.service.imp.IForumServiceImp;
import com.huayu.service.imp.IPermissionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ForumService extends ServiceImpl<ForumMapper, Forum> implements IForumServiceImp {
    @Autowired
    private ForumMapper forumMapper;

    @Override
    public Integer updateone(Forum forum) {
        return forumMapper.updateone(forum);
    }

    @Override
    public Integer updateone1(Forum forum) {
        return forumMapper.updateone1(forum);
    }

    @Override
    public Integer updateone2(Forum forum) {
        return forumMapper.updateone2(forum);
    }

    @Override
    public List<Forum> queryall(IPage<Forum> page, Forum forum) {
        return forumMapper.queryall(page,forum);
    }
}
