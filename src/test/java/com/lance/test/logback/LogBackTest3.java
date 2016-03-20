package com.lance.test.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by perdonare on 2016/2/26.
 */
public class LogBackTest3 {

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
