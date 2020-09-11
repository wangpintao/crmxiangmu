package com.huayu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.mapper.DocumentaryMapper;
import com.huayu.mapper.ForumMapper;
import com.huayu.mapper.UserMapper;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.Documentary;
import com.huayu.pojo.Forum;
import com.huayu.pojo.User;
import com.huayu.service.imp.IDocumentaryServiceImp;
import com.huayu.service.imp.IForumServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentaryService extends ServiceImpl<DocumentaryMapper, Documentary> implements IDocumentaryServiceImp {
    @Autowired
    private DocumentaryMapper documentaryMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Stulayui queryall(Integer page, Integer limit, Documentary documentary) {
        Stulayui stulayui = new Stulayui();
        documentary.setDocuser(1);
        Page page1 = PageHelper.startPage(page,limit);
        List<Documentary> list =documentaryMapper.queryall(documentary);
        if (list.size() > 0) {
            stulayui.setCode(0);
            stulayui.setMsg("查询成功");
            stulayui.setCount(Integer.valueOf(String.valueOf(page1.getTotal())));
            stulayui.setData(list);
        } else {
            stulayui.setCode(1);
            stulayui.setMsg("无数据");
        }
        return stulayui;
    }

    @Override
    public List<Documentary> queryall1(Integer coid) {
        return documentaryMapper.queryall1(coid);
    }

    @Override
    public int commercialupdate(Commercial commercial) {
        return documentaryMapper.commercialupdate(commercial);
    }

    @Override
    public Stulayui queryall2(Integer page, Integer limit, Documentary documentary) {
        Stulayui stulayui = new Stulayui();
        Page page1 = PageHelper.startPage(page,limit);
        if (documentary.getDocid() != null) {
            if (documentary.getDocid() == 3) {
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("uname",documentary.getDocDetails());
                User user = userMapper.selectOne(queryWrapper);
                if (user != null) {
                    documentary.setDocDetails(String.valueOf(user.getUid()));
                }
            }
        }
        List<Documentary> list =documentaryMapper.queryall2(documentary);
        if (list.size() > 0) {
            stulayui.setCode(0);
            stulayui.setMsg("查询成功");
            stulayui.setCount(Integer.valueOf(String.valueOf(page1.getTotal())));
            stulayui.setData(list);
        } else {
            stulayui.setCode(1);
            stulayui.setMsg("无数据");
        }
        return stulayui;
    }
}
