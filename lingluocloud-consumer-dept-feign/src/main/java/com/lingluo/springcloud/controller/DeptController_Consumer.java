package com.lingluo.springcloud.controller;

import com.lingluo.springcloud.entities.DeptEntity;
import com.lingluo.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService deptClientService;

    @GetMapping(value = "/consumer/dept/add")
    public boolean add(DeptEntity dept) {
        return  deptClientService.add(dept);
    }

    @GetMapping(value = "/consumer/dept/findById/{deptNo}")
    public DeptEntity findById(@PathVariable("deptNo") Long deptNo) {
        return deptClientService.findById(deptNo);
    }

    @GetMapping(value = "/consumer/dept/findAll")
    public List<DeptEntity> findAll() {
        return deptClientService.findAll();
    }
}
