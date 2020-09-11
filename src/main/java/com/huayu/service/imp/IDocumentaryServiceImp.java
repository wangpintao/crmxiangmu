package com.huayu.service.imp;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.Documentary;

import java.util.List;

public interface IDocumentaryServiceImp extends IService<Documentary>{
    public Stulayui queryall(Integer page, Integer limit, Documentary documentary);

    public List<Documentary> queryall1(Integer coid);

    public int commercialupdate(Commercial commercial);

    public Stulayui queryall2(Integer page, Integer limit, Documentary documentary);
}
