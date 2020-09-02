package com.huayu.service.imp;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.AfterSale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAfterSaleServiceImp extends IService<AfterSale>{
    Stulayui queryMany(Integer page, Integer limit, AfterSale afterSale);
}
