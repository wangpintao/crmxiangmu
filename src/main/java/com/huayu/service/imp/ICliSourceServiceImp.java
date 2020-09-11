package com.huayu.service.imp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.bo.FunnelStatisticsBo;
import com.huayu.pojo.CliSource;
import com.huayu.pojo.User;

import java.util.List;

public interface ICliSourceServiceImp extends IService<CliSource>{
    List<FunnelStatisticsBo> querySource();
}
