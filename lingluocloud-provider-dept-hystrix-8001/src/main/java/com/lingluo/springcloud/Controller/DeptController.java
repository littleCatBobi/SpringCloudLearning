package com.lingluo.springcloud.Controller;

import com.lingluo.springcloud.entities.DeptEntity;
import com.lingluo.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 灵洛
 * @description
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/findById/{deptNo}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrixGet")
    public DeptEntity findById(@PathVariable("deptNo") Long deptNo) {
        DeptEntity deptEntity = deptService.findById(deptNo);
        if(null == deptEntity){
            throw  new RuntimeException("该deptNo没有对应的信息"+deptNo);
        }
        return  deptEntity;
    }

    public DeptEntity processHystrixGet(Long deptNo){
        return  new DeptEntity().setDeptNo(deptNo)
                .setDeptName("该deptNo没有对应的信息@HystrixCommand")
                .setDbSource("没有这个数据库");
    }

    /**
     * 增加自己服务描述的接口
     *
     * @return
     */
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("总共有多少个微服务" + list.size());

        //查询LINGLUOCLOUD-DEPT 服务
        List<ServiceInstance> instances = discoveryClient.getInstances("LINGLUOCLOUD-DEPT");

        //打印LINGLUOCLOUD-DEPT服务信息
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId());
            System.out.println(element.getHost());
            System.out.println(element.getPort());
            System.out.println(element.getUri());
        }
        return this.discoveryClient;

    }

}