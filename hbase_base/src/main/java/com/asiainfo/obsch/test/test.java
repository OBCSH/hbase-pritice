package com.asiainfo.obsch.test;


import com.asiainfo.obsch.utils.HBaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class test {


    @Autowired
    private HBaseUtils hBaseUtils;

    @RequestMapping(value = "/test")
    public Map<String,Object> test(String tablename) {
        String str;
        str = null;
        try {
            str = hBaseUtils.scanAllRecord(tablename);//扫描表
            System.out.println("获取到hbase的内容："+str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("hbaseContent",str);
        return map;
    }

}
