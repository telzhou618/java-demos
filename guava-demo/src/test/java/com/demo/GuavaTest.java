package com.demo;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
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
     * @throws Exception
     */
    @Test
    public void testStopWatcher() throws  Exception{
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(2);
        log.info("程序运行结束,耗时:{}",stopwatch.stop());
    }

    /**
     * Preconditions断言
     */
    @Test
    public void testPreconditions(){
        Preconditions.checkNotNull(null);
    }
}
