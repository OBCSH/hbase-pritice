package com.asiainfo.obsch.ScanTable;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import java.io.IOException;

public class ScanTable{


    private static Configuration conf = HBaseConfiguration.create();
    public static void main(String tablename,String columnFamilys,String column) throws IOException {


        Connection connection = ConnectionFactory.createConnection(conf);

        Table table = connection.getTable(TableName.valueOf(tablename));
        Scan scan = new Scan();


        scan.addColumn(Bytes.toBytes(columnFamilys), Bytes.toBytes(column));
//        scan.addColumn(Bytes.toBytes(columnFamilys), Bytes.toBytes("city"));


        ResultScanner scanner = table.getScanner(scan);


        byte[] row = scanner.next().getRow();
        String result = Bytes.toString(row);
        System.out.println("Found row : " + result);
        scanner.close();
    }
}
