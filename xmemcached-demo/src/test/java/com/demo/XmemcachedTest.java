package com.demo;

import com.alibaba.fastjson.JSON;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author jameszhou
 */
public class XmemcachedTest {

    @Test
    public void test() {
        try {
            MemcachedClient memcachedClient =
                    new XMemcachedClientBuilder(AddrUtil.getAddresses("119.45.136.121:11211"))
                            .build();
            boolean ret = memcachedClient.set("a", 0, "hello");
            System.out.println(ret);
            String str = memcachedClient.get("a");
            System.out.println(str);
            memcachedClient.delete("a");
            str = memcachedClient.get("a");
            System.out.println(str);
            Map<String, String> stats = memcachedClient.stats(AddrUtil.getOneAddress("119.45.136.121:11211"));
            System.out.println(JSON.toJSONString(stats));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
