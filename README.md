# Spring Cloud学习笔记

## 觉得灵洛整理的不错的朋友，star一下哟，(*￣︶￣)

## 项目版本

- 使用IDEA完成
- spring cloud版本：Dalston.SR1
- spring boot版本：1.5.19.RELEASE

## 项目模块说明

```lua
SpringCloudLearning
├── lingluocloud-api -- 构建公共子模块 + Hystrix服务降级
├── lingluocloud-euraka-7001 -- Eureka集群
├── lingluocloud-euraka-7002 -- Eureka集群
├── lingluocloud-euraka-7003 -- Eureka集群
├── lingluocloud-provider-dept-8001 -- 构建服务提供者集群
├── lingluocloud-provider-dept-8002 -- 构建服务提供者集群
├── lingluocloud-provider-dept-8003 -- 构建服务提供者集群
├── lingluocloud-consumer-dept-80 -- 构建服务消费者
├── lingluocloud-consumer-dept-feign -- 构建服务消费者
├── lingluocloud-provider-dept-hystrix-8001 -- Hystrix服务熔断
├── lingluocloud-consumer-hystrix-dashboard -- Hystrix调用监控 
├── lingluocloud-zuul-gateway-9527 -- Zuul路由网关 
├── lingluocloud-config-3344 -- config服务端 
└── lingluocloud-config-client-3355 -- config客户端
```

## 项目搭建

- 全程记录在公众号[灵洛的人间乐园],非常非常详细
[不可错过的微服务SpringCloud入门概述](https://mp.weixin.qq.com/s?__biz=MzI3OTY3ODU5OA==&tempkey=MTA1MF9kMmFKR0xyQkpkeVVyS2VxLWprUGF4UUl3c3A2dExHZ1JrTlpBcnExX3NNRng2d28xbF9ZXzduYVZxalNENVdQRmF0YmZsTndtVlhwSG80TTRxMnlJZWx3NkhrSS1MSHY3M1JBcVA3ejBCRFNrb2xncTY1YTNrUFV3TXZvUXFMa2o3YzF2dlFCZTZfZ3VsdnZCVlV2Y1NqM0JzVGEweGtyc3p1d1hRfn4%3D&chksm=6b4559f65c32d0e073e0665001176fd246c267f475cea2e2f57e2ad01709907bbacc95196754#rd)
[SpringCloud系列2:Rest微服务构建案例工程](https://mp.weixin.qq.com/s?__biz=MzI3OTY3ODU5OA==&tempkey=MTA1MF9Va1p6UkU5elBtTStPTnZELWprUGF4UUl3c3A2dExHZ1JrTlpBcnExX3NNRng2d28xbF9ZXzduYVZxZ1RSVXJtb1pzQ0EwMDB3RXRCU0x2SEE4X2NqZ1Vxb2t0bWNMWGFUQjM0RjE5Z3V3UUE4Qi1nNGN0TmNzTUZwVW1yYWJiRnJIUVVlR2dwd0FIalJHZ1N1WVl2V3NIWXFOelROZG5yZlhzVFdnfn4%3D&chksm=6b4559de5c32d0c84d39975045e65aa000cfd2c16eef6b65f0cebc8401fd7a253fc842fe4c96#rd)
[SpringCloud系列3:Eureka服务注册](https://mp.weixin.qq.com/s?__biz=MzI3OTY3ODU5OA==&tempkey=MTA1MF9IcDVpQWtqTzUzb3BERm5iLWprUGF4UUl3c3A2dExHZ1JrTlpBcnExX3NNRng2d28xbF9ZXzduYVZxaGNkNUJ1WlZoNVh0ZnNhZERyX2w3d0FSdk9ZV0xJZEtScWtIZFpOUkxiU0Y2R2RhMWJMNVJVN0gweGxzTTFhbFNZWWlENEdhTHZYT0J5M0hZZXVKcXFibmpOWVk3SHp3OU13cGFjZ0VpZF9nfn4%3D&chksm=6b4559a85c32d0beb4ec27493a8c3300cebacf2c8ca4cd3b014364ac5b27ed87f455e35c0fa2#rd)
[SpringCloud系列4:Eureka服务发现和集群搭建](https://mp.weixin.qq.com/s?__biz=MzI3OTY3ODU5OA==&tempkey=MTA1MF92WCtUaHpNUU4zZmkrL3FZLWprUGF4UUl3c3A2dExHZ1JrTlpBcnExX3NNRng2d28xbF9ZXzduYVZxalV4V1FocmxTNF9mR1FzSl9nQkVMTXdxTmVDSkZvNnMyNzAxWkVVZkt4b3BVaFRwdTc4Rm0zMF9sVklabzN5NEtCa3llSFdaMTdkbUxnb2poOGxKMV9HN2ppaHdVR3gwLXQyRk9LSXdnOEN3fn4%3D&chksm=6b45598e5c32d098a7fff2dd7b48ec715a25637787b07805f089e2d5e1d416d8919693ee8794#rd)
[SpringCloud系列5:使用Ribbon实现负载均衡及自定义Rule源码解析](https://mp.weixin.qq.com/s?__biz=MzI3OTY3ODU5OA==&tempkey=MTA1MF9NT3lCakJ1V3NjTTRlMExDLWprUGF4UUl3c3A2dExHZ1JrTlpBcnExX3NNRng2d28xbF9ZXzduYVZxaEJmZkpnbGJoWXNUd3NCTWdnUmpsNUFaTnJ5SVNSRnlUeWxjb1FLOXB2ODhEdkszY3FtUXlTTnBxbEEwd0RnNFprYW51cHhySFg0NjIwMlc3SUMyMGpna2I0Yi1nelNZLWVJeVgtN1M5ZGl3fn4%3D&chksm=6b45597c5c32d06ae166d07b4a39d375a1a69c0126b1832ecb57d6122b6c227b2d85f59e106b#rd)
[SpringCloud系列6:使用Feign实现负载均衡](https://mp.weixin.qq.com/s?__biz=MzI3OTY3ODU5OA==&tempkey=MTA1MF8rYmwwTHluTHBWdEVxaUowLWprUGF4UUl3c3A2dExHZ1JrTlpBcnExX3NNRng2d28xbF9ZXzduYVZxaHpTblJBT0JtN1NJMi1xdVlKWVQxVjBkUFVtRWNVYl9oRWN5LWRZMXZ4TjJyU3RtV1pmZmo4WTRBNks3Y1dLc3JFOExPeFNWdnM4cTNFR1BIVndKNUN2cEphR3AtMDhuSUlzSXdLN0ZPazZ3fn4%3D&chksm=6b4559745c32d062f1a140a38949d3bd55f45ece5930ee42001530824382e9bb9a98a705ea83#rd)
[SpringCloud系列7:安检员豪猪哥登场——Hystrix服务熔断、降级及监控](https://mp.weixin.qq.com/s?__biz=MzI3OTY3ODU5OA==&tempkey=MTA1MF9FVEJFZjRZN09VeEhMMXArLWprUGF4UUl3c3A2dExHZ1JrTlpBcnExX3NNRng2d28xbF9ZXzduYVZxaWkzYmZnY2RIQUpldFhYdTJ2eUI1b1kyLVJEWERnUlRyZ0pXTGxlSVZlTWl0SGlBLU9TWng0YXFQWUpwSzNJanR1eVpTc1BleGQwVF9OZ2NPdzZydG0xSlFBeFQxWjlBTjNXRUNDcEVFTWdnfn4%3D&chksm=6b4559005c32d0160083832409c5c3560f6d38117198426b457a553e0a3ee586a037336158ed#rd)
[SpringCloud系列8:一文搞定Zuul路由网关及源码解析](https://mp.weixin.qq.com/s?__biz=MzI3OTY3ODU5OA==&tempkey=MTA1MF94MjlVcnJJeHVFeWRjM1RmLWprUGF4UUl3c3A2dExHZ1JrTlpBcnExX3NNRng2d28xbF9ZXzduYVZxaUh1SWo3R0RyaEprU3pwNWI2d1ZMeUo3OGhfOUs0TDRZSWZ4QzYtNExTdFNJRGFTcVlzZF9aNUU1azRMU2tlVmUyYzV1NkZuWG5JbkpOLVFRaWIwSXhKNS05ZzJJSm5jM0tuSGdNbXpGbnVRfn4%3D&chksm=6b4559195c32d00f368848b7cffb29345f9b1fb3644be4e8cfa0a7eee0130c61c2157eeb85ff#rd)
[SpringCloud系列9:分布式配置中心实战](https://mp.weixin.qq.com/s?__biz=MzI3OTY3ODU5OA==&tempkey=MTA1MF9NODl6RElocCtaMWlSZjR5LWprUGF4UUl3c3A2dExHZ1JrTlpBcnExX3NNRng2d28xbF9ZXzduYVZxaUZYclE5SkFDZ0VuR2dSSm5PdkZ1clNRRTVQamRUZ3dTcXA1Q19pQ090ZFk5MWFkaU10Z0NmMV9BNWFtaDJHdE9IR1Zpa3daNnNxM3lPMDBfOHhfMmt6MTVPakkyMEpkZkVPRk84Mmg3MkFnfn4%3D&chksm=6b4559135c32d00574fee353eb363f822839af90e8f9ad7c9cfb1be6d21a458d5c1aa0ef98d0#rd)

## 项目启动

1. 启动euraka-service端集群：
   - [lingluocloud-euraka-7001]
   - [lingluocloud-euraka-7002]
   - [lingluocloud-euraka-7003]
   
2. 启动微服务提供者集群：
   - [lingluocloud-provider-dept-8001 (连01数据库)]
   - [lingluocloud-provider-dept-8002 (连02数据库)]
   - [lingluocloud-provider-dept-8003 (连03数据库)]
   
3. 启动为服务消费者：
   > 以下两者二选一启动，它两主要区别（具体见笔记中第四小节）是：<br/>
   > dept-80：Ribbon+RestTemplate 调用Rest服务<br/>
   > dept-feign：Feign+接口 调用Rest服务（优雅简单）
   - [lingluocloud-consumer-dept-80 (含Ribbon客户端负载均衡)]
   - [lingluocloud-consumer-dept-feign (含Feign负载均衡、Hystrix服务降级)]
   
4. Hystrix 服务熔断、降级、监控   
   > 服务熔断：<br/>
   > 	缺点就是每一个方法对应都得写一个fallBackMethod方法，代码膨胀，所以我们之后看服务降级(*^__^*)<br/>
   >     主要在单个服务出异常的时候用<br/>
   > 
   > 服务降级：<br/>
   > 	统一处理主业务与熔断方法解耦，是在客户端（消费者）处理完成的，与服务端没关系<br/>
   >     主要在单个服务整个被关闭的时候用
   - [lingluocloud-provider-dept-hystrix-8001 (Hystrix服务熔断)]
   - [lingluocloud-api (Hystrix服务降级)]
   - [lingluocloud-consumer-hystrix-dashboard (Hystrix调用监控)]
   
5. Zuul 路由网关
   
   - [lingluocloudzuul-gateway-9527 (Zuul路由网关)]
   
6. Config 分布式配置中心
   - [lingluocloud-config-3344 (config服务端)]
   - [lingluocloud-config-client-3355 (config客户端)]