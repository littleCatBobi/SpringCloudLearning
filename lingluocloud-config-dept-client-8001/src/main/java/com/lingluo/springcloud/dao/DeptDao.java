package com.lingluo.springcloud.dao;

import com.lingluo.springcloud.entities.DeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 灵洛
 * @description
 */
@Mapper
public interface DeptDao {

    /**
     * 插入
     * @param deptEntity
     *
     * @return
     */
    boolean addDept(DeptEntity deptEntity);

    /**
     * 根据id查找
     * @param deptNo
     * @return
     */
    DeptEntity findById(Long deptNo);

    /**
     * 查询全部
     * @return
     */
    List<DeptEntity> findAll();

}