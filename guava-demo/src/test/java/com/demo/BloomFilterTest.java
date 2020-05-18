package com.demo;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

/** 布隆过滤器
 * @author jameszhou
 */
public class BloomFilterTest {

    // 创建布隆过滤器，元素类型int,容量1000,错误率0.001;
    private BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),1000,0.001);
   // private BloomFilter<String> bloomFilter2 = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),1000,0.001);

    @Test
    public void test(){
        // 添加元素
        for (int i=0;i<1000;i++){
            bloomFilter.put(i);
        }
        // 判断是否存在
        System.out.println(bloomFilter.mightContain(11)); // true
        System.out.println(bloomFilter.mightContain(1002)); // false
    }
}
