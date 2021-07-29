package com.example.commons.pool2;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhougaojun
 * @since 2021/7/29
 */
public class Pool2Main {

    public static void main(String[] args) throws Exception {

        // 实例化对象生产工厂
        ConnectionObjectFactory factory = new ConnectionObjectFactory();
        // 实例化连接池配置信息
        ConnectionPoolConfig config = new ConnectionPoolConfig();
        config.setMaxTotal(5);
        config.setMaxWaitMillis(1000);
        // 实例化连接池
        GenericObjectPool<Connection> pool = new GenericObjectPool<>(factory, config);

        for (int i = 0; i < 10; i++) {
            // 获取连接
            Connection connection = pool.borrowObject();
            System.out.println(connection);
            // 归还连接
            //  pool.returnObject(connection);
        }

    }

    /**
     * 连接对象
     */
    @Getter
    @Setter
    @ToString
    static class Connection {
        private Integer id;

        public Connection(Integer id) {
            this.id = id;
        }
    }

    /**
     * 对象生产工厂
     */
    static class ConnectionObjectFactory extends BasePooledObjectFactory<Connection> {

        private AtomicInteger atomicInteger = new AtomicInteger(1);

        @Override
        public Connection create() throws Exception {
            // 模拟连接对象的创建过程
            return new Connection(atomicInteger.getAndIncrement());
        }

        @Override
        public PooledObject<Connection> wrap(Connection connection) {
            // 将连接包装成PooledObject对象，要线程安全
            return new DefaultPooledObject<>(connection);
        }
    }

    /**
     * 连接池配置信息
     */
    static class ConnectionPoolConfig extends GenericObjectPoolConfig {
        public ConnectionPoolConfig() {
            setTestWhileIdle(true);
            setMinEvictableIdleTimeMillis(60000);
            setTimeBetweenEvictionRunsMillis(30000);
            setNumTestsPerEvictionRun(-1);
        }
    }
}
