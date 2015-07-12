package com.lance.service.impl;

import com.lance.service.IBatchService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by perdonare on 2015/7/12.
 */
@Service
public class BatchServiceImpl implements IBatchService{
    @Autowired
    private JobLauncher jobLauncher;
    @Resource
    private Job fileBatchJob;
    @Override
    public void startJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        jobLauncher.run(fileBatchJob,new JobParameters());
    }
}
