package com.huayu.service.imp;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.Contract;
import com.huayu.pojo.Forum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IContractServiceImp extends IService<Contract>{
    Contract queryByConId(String serial);

    public Stulayui queryall(Integer page, Integer limit, Contract contract);

    public Stulayui queryalls(Integer page, Integer limit, Contract contract);

    public Integer updateone(Contract contract);

    public Stulayui queryBya(Integer page,Integer limit,Contract contract);

    public List<Integer> queryCount();
}
