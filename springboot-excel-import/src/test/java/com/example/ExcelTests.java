package com.example;

import com.alibaba.excel.EasyExcel;
import com.example.excel.DownloadData;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jameszhou
 */
class ExcelTests {

    @Test
    public void testWrite() {
        EasyExcel.write(new File("/tmp/t.xlsx"), DownloadData.class)
                .sheet(1)
                .doWrite(data());
    }

    private List<DownloadData> data() {
        List<DownloadData> list = new ArrayList<DownloadData>();
        for (int i = 0; i < 10; i++) {
            DownloadData data = new DownloadData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}
