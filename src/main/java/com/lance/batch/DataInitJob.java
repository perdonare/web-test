package com.lance.batch;

import com.google.common.collect.Lists;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.File;
import java.util.List;

/**
 * Created by perdonare on 2015/7/11.
 */
public class DataInitJob implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        List files = ftpInit();
        chunkContext.setAttribute("files",files);
        return RepeatStatus.FINISHED;
    }

    /**
     * 将ftp信息加载到本地
     */
    private List<File> ftpInit(){
        String fileDirectory = "d:/test/";
        String fileName = "job.txt";
        File file = new File(fileDirectory,fileName);
        List<File> files = Lists.newArrayList();
        files.add(file);
        return files;
    }
}
