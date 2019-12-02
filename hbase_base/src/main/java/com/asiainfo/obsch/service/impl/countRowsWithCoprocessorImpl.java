package com.asiainfo.obsch.service.impl;

import com.asiainfo.obsch.config.HbaseConfig;
import com.asiainfo.obsch.service.CountRowsWithCoprocessor;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.apache.hadoop.hbase.client.coprocessor.LongColumnInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service("countRowsWithCoprocessor")
public class countRowsWithCoprocessorImpl implements CountRowsWithCoprocessor {
    @Autowired
    HbaseConfig config;
    private static Configuration conf = HBaseConfiguration.create();
    private static Admin admin = null;
    /**
     * 利用协处理器进行全表count统计
     *
     * @param tablename
     */
    @Override
    public Long countRowsWithCoprocessor(String tablename) throws Throwable {
        TableName name=TableName.valueOf(tablename);
        HTableDescriptor descriptor = admin.getTableDescriptor(name);

        String coprocessorClass = "org.apache.hadoop.hbase.coprocessor.AggregateImplementation";
        if (! descriptor.hasCoprocessor(coprocessorClass)) {
            admin.disableTable(name);
            descriptor.addCoprocessor(coprocessorClass);
            admin.modifyTable(name, descriptor);
            admin.enableTable(name);
        }

        //计时
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Scan scan = new Scan();

        AggregationClient aggregationClient = new AggregationClient(conf);

        Long count = aggregationClient.rowCount(name, new LongColumnInterpreter(), scan);

        stopWatch.stop();
        System.out.println("RowCount：" + count +  "，全表count统计耗时：" + stopWatch.getTotalTimeMillis());

        return count;
    }
    }

