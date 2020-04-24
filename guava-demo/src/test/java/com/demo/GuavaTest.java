package com.demo;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author jameszhou
 */
@Slf4j
public class GuavaTest {


    /**
     * StopWatcher用于监测一段程序的执行耗时
     *
     * @throws Exception
     */
    @Test
    public void testStopWatcher() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(2);
        log.info("程序运行结束,耗时:{}", stopwatch.stop());
    }

    /**
     * Preconditions断言
     */
    @Test
    public void testPreconditions() {
        Preconditions.checkNotNull(null);
    }

    /**
     * Joiner 连接器
     */
    @Test
    public void testJoiner() {
        // -> a,b,c
        log.info(Joiner.on(",").skipNulls().join(Lists.newArrayList(null, "a", "b", "c")));
        // -> nul,a,b,c
        log.info(Joiner.on(",").useForNull("nul").join(Lists.newArrayList(null, "a", "b", "c")));
    }

    /**
     * Splitter 分割器
     */
    @Test
    public void testSplitter() {
        // [a, b,    c]
        log.info(Splitter.on(",").splitToList("a,b,   c").toString());
        // [a, b, c]
        log.info(Splitter.on(",").trimResults().splitToList("a,b, c").toString());
    }
}
