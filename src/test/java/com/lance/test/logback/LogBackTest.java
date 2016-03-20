package com.lance.test.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.status.OnConsoleStatusListener;
import ch.qos.logback.core.status.StatusManager;
import ch.qos.logback.core.util.StatusPrinter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by perdonare on 2016/2/26.
 */
public class LogBackTest {

    /**
     * 打印logback的状态
     */
    @Test
    public void testLogBackStatus() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.debug("hello world");
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(context);
    }

    /**
     * 打印超过两个参数
     */
    @Test
    public void testLogBackElements() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        Object[] o = {"1","2","3"};
        logger.debug("hello world,{},{},{}",o);
    }

    /**
     * 测试性能
     */
    @Test
    public void testLogBackPerformance() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        Object[] o = {"1","2","3"};
        long before1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            logger.debug("hello world,{},{},{}",o);
        }
        logger.debug("hello world,{},{},{}",o);
        long after1 = System.currentTimeMillis();

        long before2 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            logger.debug("hello world,"+"1"+",2"+",3");
        }
        logger.debug("hello world,{},{},{}",o);
        long after2 = System.currentTimeMillis();

        logger.info("未优化调用时间:{}",(after1-before1));

        logger.info("优化调用时间:{}",(after2-before2));
    }

    /**
     * 在非错误情况下也输出内部错误
        <configuration debug="true">
        </configuration>
        packagingData="true"
     * 配置时刻扫描配置文件
     */
    @Test
    public void testLogBackInternalError() throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        while (true) {
            logger.error("test internal error");
            Thread.sleep(1000);
        }
    }

    /**
     * 监听状态信息
     */
    @Test
    public void testLogBackListener() throws InterruptedException {

        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusManager statusManager = context.getStatusManager();
        OnConsoleStatusListener listener = new OnConsoleStatusListener();
        listener.addError("aaaaaaaaaaaaaaaa");
        statusManager.add(listener);
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.debug("asdfs");

    }

    /**
     * 配置文件测试
     */
    @Test
    public void testLogBackConfig() throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
