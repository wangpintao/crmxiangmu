package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.DocStatusMapper;
import com.huayu.mapper.DocumentaryMapper;
import com.huayu.pojo.DocStatus;
import com.huayu.pojo.Documentary;
import com.huayu.service.imp.IDocStatusServiceImp;
import com.huayu.service.imp.IDocumentaryServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DocStatusService extends ServiceImpl<DocStatusMapper, DocStatus> implements IDocStatusServiceImp {

}
