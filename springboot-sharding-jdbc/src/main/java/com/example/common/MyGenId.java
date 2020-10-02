package com.example.common;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import tk.mybatis.mapper.genid.GenId;

/**
 * @author jameszhou
 */
public class MyGenId implements GenId<Long> {

    private static final IdGenerator ID_GENERATOR = new CommonSelfIdGenerator();

    @Override
    public Long genId(String table, String column) {
        return ID_GENERATOR.generateId().longValue();
    }
}
