package com.asiainfo.obsch.web;

import com.asiainfo.obsch.service.CountRowsWithCoprocessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/CountRows")
public class CountRowsWithCoprocessorCntrol {
    @Resource(name = "countRowsWithCoprocessor")
    CountRowsWithCoprocessor countRowsWithCoprocessor;
    @RequestMapping("/countRowsWithCoprocessor")
    Long countRowsWithCoprocessor(String tablename) throws Throwable {
       return countRowsWithCoprocessor.countRowsWithCoprocessor(tablename);
    }
}
