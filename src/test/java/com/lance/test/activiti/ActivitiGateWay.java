package com.lance.test.activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by perdonare on 2015/6/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-config.xml"})
public class ActivitiGateWay {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;

    @Test
    public void testZipCompress() throws IOException {
        File file = new File("d:/MyProcess1.zip");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ZipEntry zipEntry = new ZipEntry("MyProcess1.bpmn");
        ZipEntry zipEntry2 = new ZipEntry("MyProcess1.png");
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        zipOutputStream.putNextEntry(zipEntry);

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("activiti/MyProcess1.bpmn");
        InputStream inputStream2 = this.getClass().getClassLoader().getResourceAsStream("activiti/MyProcess1.png");
        byte[] bytes = new byte[1024];
        int count = 0;
        while ((count =inputStream.read(bytes))!=-1){
            zipOutputStream.write(bytes,0,count);
        }
        zipOutputStream.flush();
        zipOutputStream.putNextEntry(zipEntry2);
        while ((count =inputStream2.read(bytes))!=-1){
            zipOutputStream.write(bytes,0,count);
        }
        zipOutputStream.close();
        inputStream.close();
        inputStream2.close();
        fileOutputStream.close();

    }


    @Test
    public void testZipDeploy() throws FileNotFoundException {
        File file = new File("d:/MyProcess1.zip");
        InputStream inputStream = new FileInputStream(file);
        //InputStream is = this.getClass().getClassLoader().getResourceAsStream("activiti/MyProcess1.zip");
        ZipInputStream zis = new ZipInputStream(inputStream);
        repositoryService.createDeployment().addZipInputStream(zis).deploy();
    }

    @Test
    public void testStartProcess(){
        String processKey = "myProcess";
        runtimeService.startProcessInstanceByKey(processKey);
    }

    @Test
    public void testStartTaskWay1Step1(){
        taskService.setAssignee("60007","xiaoming");
        String taskId = taskService.createTaskQuery().taskAssignee("xiaoming").singleResult().getId();
        taskService.complete(taskId);
    }

    @Test
    public void testStartTaskWay1Step2(){
        //taskService.addComment("62504","60001","ok");
        taskService.complete("65003");
    }

    @Test
    public void testStartTaskWay2Step1(){}

    @Test
    public void testStartTaskWay2Step2(){}


















    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }
}
