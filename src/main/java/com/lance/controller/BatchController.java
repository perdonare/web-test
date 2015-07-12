package com.lance.controller;

import com.lance.service.IBatchService;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by perdonare on 2015/7/12.
 */
@Controller
@RequestMapping("/batch")
public class BatchController {
    @Autowired
    private IBatchService batchService;
    @RequestMapping("/test")
    public String fileBatch(){
        try {
            batchService.startJob();
            return "batch/success";
        } catch (Exception e) {
            e.printStackTrace();
            return "batch/fail";
        }
    }
}
