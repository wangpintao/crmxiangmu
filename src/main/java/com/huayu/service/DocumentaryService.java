package com.huayu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.DocumentaryMapper;
import com.huayu.mapper.ForumMapper;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.Documentary;
import com.huayu.pojo.Forum;
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

    @Override
    public List<Documentary> queryall(IPage<Documentary> page, Documentary documentary) {
        return documentaryMapper.queryall(page,documentary);
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
    public List<Documentary> queryall2(IPage<Documentary> page, Documentary documentary) {
        return documentaryMapper.queryall2(page,documentary);
    }
}
