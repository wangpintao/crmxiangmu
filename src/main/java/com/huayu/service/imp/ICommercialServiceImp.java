package com.huayu.service.imp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.Contract;
import org.springframework.beans.factory.annotation.Autowired;

public interface ICommercialServiceImp extends IService<Commercial>{
 public boolean updatec(Commercial commercial);
}
