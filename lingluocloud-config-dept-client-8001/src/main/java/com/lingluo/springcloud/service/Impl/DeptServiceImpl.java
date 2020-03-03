package com.lingluo.springcloud.service.Impl;

import com.lingluo.springcloud.dao.DeptDao;
import com.lingluo.springcloud.entities.DeptEntity;
import com.lingluo.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 灵洛
 * @description
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptDao deptDao;
    @Override
    public boolean addDept(DeptEntity deptEntity) {
      return deptDao.addDept(deptEntity);
    }

    @Override
    public DeptEntity findById(Long deptNo) {
        return deptDao.findById(deptNo);
    }

    @Override
    public List<DeptEntity> findAll() {
        return deptDao.findAll();
    }
}