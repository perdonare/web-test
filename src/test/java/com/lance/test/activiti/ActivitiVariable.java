package com.lance.test.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by perdonare on 2015/6/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-config.xml"})
public class ActivitiVariable {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService  runtimeService;
    @Autowired
    private TaskService taskService;



    //设置流程变量 2种方式
    //支持设置基本类型和 实体对象 要求实体对象序列化【添加序列化id】
    @Test
    public void variableSetting(){
        Map<String,String> map = new HashMap<>();
        map.put("name","lance");
        map.put("age","30");
        //方式1
        //runtimeService.setVariable("20001","age",30);
        runtimeService.setVariableLocal("20001","age","30");//local表示与任务绑定
        //runtimeService.setVariables("20001",map);
        //方式2
        taskService.setVariable("22504","age",25);
        taskService.setVariable("22504","name","lance");
        //taskService.setVariables("22504",map);
    }
    //获取流程变量
    @Test
    public void variableGetting(){
        //int age = (int) taskService.getVariable("22504","age");
        Map map = new HashMap<>();
        //Map m = taskService.getVariables("22504",map);
        //System.out.println(age);
    }
    //模拟设置和获取流程变量的场景
    @Test
    public void variableSimulation(){
        String taskId = "37505";

        /*taskService.setVariable(taskId,"username","lance");
        taskService.setVariable(taskId,"password","llll");
        taskService.setVariableLocal(taskId, "birthday", "1989");
        taskService.complete(taskId);
        System.out.println("完成任务，任务ID:  " + taskId);*/
        Map map = taskService.getVariables(taskId);
        Set<Map.Entry> entry = map.entrySet();
        for (Map.Entry e : entry){
            System.out.println("key: " + e.getKey() + " value: " + e.getValue());
        }
        taskService.setVariable(taskId,"password","aaaaa");
        taskService.complete(taskId);

    }
    //查询流程变量历史
    //HistoricVariableInstance





































    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

}
