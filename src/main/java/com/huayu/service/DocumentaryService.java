package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.DocumentaryMapper;
import com.huayu.mapper.ForumMapper;
import com.huayu.pojo.Documentary;
import com.huayu.pojo.Forum;
import com.huayu.service.imp.IDocumentaryServiceImp;
import com.huayu.service.imp.IForumServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DocumentaryService extends ServiceImpl<DocumentaryMapper, Documentary> implements IDocumentaryServiceImp {

}
