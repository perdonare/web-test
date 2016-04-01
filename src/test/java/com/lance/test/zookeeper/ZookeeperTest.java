package com.lance.test.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * Created by perdonare on 2016/3/20.
 */
public class ZookeeperTest {
    public static final String ADDRESS="192.168.80.128:2181";

    @Test
    public void testCurator() throws Exception {
        //RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 1);
        RetryPolicy retryPolicy = new RetryOneTime(30000);
        //RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 1);
        //RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 1);
        //RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 1);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("192.168.80.128:2181",retryPolicy);
        curatorFramework.start();
        //创建路径
        //curatorFramework.create().forPath("/test");
        //创建自路径
        //curatorFramework.create().forPath("/test1/test1"); 错误用法
        //curatorFramework.createContainers("/dest1/dest11");
        //curatorFramework.createContainers("/dest1/dest12");
        //curatorFramework.createContainers("/dest1/dest12/dest13");
        //不能删除节点部不为空的父节点
        //curatorFramework.delete().forPath("/test1");

        //查看子节点，只是子节点 不包含子节点的子节点
        //List<String> lists = curatorFramework.getChildren().forPath("/dest1");
        //System.out.println(lists);

        //常用   创建 /a/b/c0000000000节点   除了c以外必须是持久化节点
        //zk规定除了叶子节点必须为持久化节点
        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/a/b/c");
        //


        //curatorFramework.getConfig().
    }

    @Test
    public void testExponentialBackoffRetry() {
        //相当于 2的n次方
        int n = 4;
        int m = 1<<n;
        System.out.println(m);

        //随机取m以下的整数
        Random random = new Random();
        int d = random.nextInt(3);
        System.out.println(d);

    }

    @Test
    public void testStandard() throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(ADDRESS,retryPolicy);
        curatorFramework.start();
        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/test");
        Stat stat = new Stat();
        curatorFramework.getData().storingStatIn(stat).forPath("/test");
        curatorFramework.delete().guaranteed().deletingChildrenIfNeeded().withVersion(stat.getVersion()).forPath("/test");
        System.out.println(stat);
    }

    @Test
    public void testAsy() throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(ADDRESS,retryPolicy);
        curatorFramework.start();

        curatorFramework.create().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println(event.getPath());
            }
        },new Object()).forPath("/aaa");
        System.out.println("before");
        Thread.sleep(10000);
    }
}
