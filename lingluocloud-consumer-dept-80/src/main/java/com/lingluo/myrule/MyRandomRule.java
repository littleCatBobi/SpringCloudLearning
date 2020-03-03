package com.lingluo.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author GongXings
 * @createTime 31 2:18
 * @description 依旧是轮询策略，但是加上新需求，每个服务器要求被调用5次。（也就是以前是每台服务器一次，现在是每台服务器5次）
 */
public class MyRandomRule extends AbstractLoadBalancerRule {
//    Random rand;
//
//    public MyRandomRule() {
//        rand = new Random();
//    }

    //当total等于5以后，指针才往下走
    private int total = 0;
    //total达到5次后，重新置为0，然后指针往下走，index=1
    private int index = 0;//也就是euraka中的第几个服务

    /**
     * Randomly choose from all living servers
     */
    //@edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();//得到现在活着的所有服务器
            List<Server> allList = lb.getAllServers();//得到euraka中所有的服务

            int serverCount = allList.size();//所有服务的个数
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            //从所有服务中随机获取一个
//            int index = rand.nextInt(serverCount);//相当于java.util.Random.nextInt(3);
            //找到随机获取的那个服务器返回
//            server = upList.get(index);

            if(total<5){
                server = upList.get(index);
                total++;
            }else{
                total = 0;
                index++;
                if(index >= upList.size()){
                    index = 0;
                }
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}