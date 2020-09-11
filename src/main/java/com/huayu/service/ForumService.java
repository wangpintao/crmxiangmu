package com.huayu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.huayu.layuiUtils.Stulayui;
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
    public Stulayui queryall(Integer page,Integer limit,Forum forum) {
        Stulayui stulayui=new Stulayui();
        Page page1 = PageHelper.startPage(page,limit);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("for_forid",0);
        if(forum!=null){
            if(!StringUtil.isEmpty(forum.getForLabel())){
                if(forum.getForLabel().equals("for_theme")){
                    queryWrapper.like(forum.getForLabel(),forum.getForClassify());
                }else if(forum.getForLabel().equals("for_author")){
                    queryWrapper.like(forum.getForLabel(),forum.getForClassify());
                }else if(forum.getForLabel().equals("for_label")){
                    queryWrapper.like(forum.getForLabel(),forum.getForClassify());
                }else if(forum.getForLabel().equals("for_click")){
                    queryWrapper.eq(forum.getForLabel(),forum.getForClassify());
                }else if(forum.getForLabel().equals("for_reply")){
                    queryWrapper.eq(forum.getForLabel(),forum.getForClassify());
                }
            }
        }
        List<Forum> list=forumMapper.selectList(queryWrapper);
        if(list.size()>0){
            stulayui.setCode(0);
            stulayui.setMsg("查询成功");
            stulayui.setCount(Integer.valueOf(String.valueOf(page1.getTotal())));
            stulayui.setData(list);
        }else{
            stulayui.setCode(1);
            stulayui.setMsg("无数据");
        }
        return stulayui;
    }
}
