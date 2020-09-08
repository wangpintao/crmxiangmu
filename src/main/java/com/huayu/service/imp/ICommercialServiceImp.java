package com.huayu.service.imp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.bo.CommercialBo;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.Contract;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ICommercialServiceImp extends IService<Commercial>{
 public boolean updatec(Commercial commercial);
 public List<CommercialBo> queryCom(Commercial commercial);
}
