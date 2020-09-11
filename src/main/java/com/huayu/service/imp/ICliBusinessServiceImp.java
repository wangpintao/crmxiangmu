package com.huayu.service.imp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.bo.FunnelStatisticsBo;
import com.huayu.pojo.CliBusiness;
import com.huayu.pojo.User;

import java.util.List;

public interface ICliBusinessServiceImp extends IService<CliBusiness>{
    List<FunnelStatisticsBo> queryIndustry();
}
