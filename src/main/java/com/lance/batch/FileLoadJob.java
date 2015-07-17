package com.lance.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.jsr.step.BatchletStep;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.AbstractStep;
import org.springframework.batch.core.step.item.Chunk;
import org.springframework.batch.core.step.item.ChunkOrientedTasklet;
import org.springframework.batch.core.step.item.ChunkProcessor;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2015/7/11.
 */
@Service
public class FileLoadJob implements Tasklet{
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        return null;
    }
}
