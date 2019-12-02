package com.asiainfo.obsch.web;


import com.asiainfo.obsch.service.HBaseServicePermission;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.security.access.Permission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/Permission")
public class HBaseServicePermissionControl {
    @Resource(name = "HBaseServicePermission")
    HBaseServicePermission hBaseServicePermission;

    @RequestMapping("/grant")
   public void grant(Configuration configuration, String tableName, String userName, String family, String qual, Permission.Action... actions) throws Throwable {
        hBaseServicePermission.grant(configuration, tableName, userName, family, qual, actions);
    }
    @RequestMapping("/revoke")
   public void revoke(Configuration configuration, String tableName, String userName, String family, String qual, Permission.Action... actions) throws Throwable {
       hBaseServicePermission.revoke(configuration, tableName, userName, family, qual, actions);
   }


}
