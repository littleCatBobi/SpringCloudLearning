package com.lingluo.springcloud.service;

import com.lingluo.springcloud.entities.DeptEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Lingluo on 2020/2/20.
 */
@FeignClient(value = "LINGLUOCLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @GetMapping(value = "/dept/add")
    public boolean add(DeptEntity dept);

    @GetMapping(value = "/dept/findById/{deptNo}")
    public DeptEntity findById(Long deptNo);

    @GetMapping(value = "/dept/findAll")
    public List<DeptEntity> findAll();
}
