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
public class LogBackTest2 {

    /**
     * 配置文件测试
     */
    @SuppressWarnings("Duplicates")
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
