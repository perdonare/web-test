package com.lance.batch;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 * Created by perdonare on 2015/7/12.
 */
public class FileItemReader<T> extends AbstractItemCountingItemStreamItemReader<T> implements ResourceAwareItemReaderItemStream<T>, InitializingBean {
    private Resource resource;
    private BufferedReader bufferedReader;
    private LineMapper lineMapper;
    private int lineCount;


    @Override
    protected void doOpen() throws Exception {
        File file = resource.getFile();
        if (!file.exists()){
            throw  new Exception("file not exists");
        }
        try{
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    protected T doRead() throws Exception {
        String line = bufferedReader.readLine();
        //SimpleAsyncTaskExecutor
        //FlatFileItemReader
        if (line==null){
            return null;
        }
        lineCount++;
        return (T) lineMapper.mapLine(line,lineCount);
    }


    @Override
    protected void doClose() throws Exception {
        lineCount = 0;
        bufferedReader.close();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(resource);
    }

    @Override
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void setLineMapper(LineMapper lineMapper) {
        this.lineMapper = lineMapper;
    }

    @Override
    public void setExecutionContextName(String name) {
        super.setExecutionContextName(name);
    }

    @Override
    public void setMaxItemCount(int count) {
        super.setMaxItemCount(count);
    }
}
