package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.DocClassifyMapper;
import com.huayu.mapper.DocStatusMapper;
import com.huayu.pojo.DocClassify;
import com.huayu.pojo.DocStatus;
import com.huayu.service.imp.IDocClassifyServiceImp;
import com.huayu.service.imp.IDocStatusServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DocClassifyService extends ServiceImpl<DocClassifyMapper, DocClassify> implements IDocClassifyServiceImp {


}
