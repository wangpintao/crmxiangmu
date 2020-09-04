package com.huayu.service.imp;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.Documentary;

import java.util.List;

public interface IDocumentaryServiceImp extends IService<Documentary>{
    public List<Documentary> queryall(IPage<Documentary> page, Documentary documentary);

    public List<Documentary> queryall1(Integer coid);

    public int commercialupdate(Commercial commercial);

    public List<Documentary> queryall2(IPage<Documentary> page, Documentary documentary);
}
