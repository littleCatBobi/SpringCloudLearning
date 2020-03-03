package com.lingluo.springcloud.service;

import com.lingluo.springcloud.entities.DeptEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 灵洛
 * @date 2020/2/26 21:21
 */
@Component
// 主业务与熔断方法解耦
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {

            @Override
            public boolean add(DeptEntity dept) {
                return false;
            }

            @Override
            public DeptEntity findById(Long deptNo) {
                return new DeptEntity().setDeptNo(deptNo)
                        .setDeptName("该deptNo没有对应的信息，Consumer客户端提供的降级信息，此刻服务provider已经关闭")
                        .setDbSource("没有这个数据库");
            }

            @Override
            public List findAll() {
                List<DeptEntity> list = new ArrayList<>();
                list.add(new DeptEntity().setDeptNo(null)
                        .setDeptName("findAll没有对应的信息，Consumer客户端提供的降级信息，此刻服务provider已经关闭")
                        .setDbSource("没有这个数据库"));
                return list;
            }
        };
    }
}
