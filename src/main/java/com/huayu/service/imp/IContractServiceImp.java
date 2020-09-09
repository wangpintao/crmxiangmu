package com.huayu.service.imp;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.pojo.Contract;
import com.huayu.pojo.Forum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IContractServiceImp extends IService<Contract>{
    Contract queryByConId(String serial);

    public List<Contract> queryall(IPage<Contract> page,Contract contract);
}
