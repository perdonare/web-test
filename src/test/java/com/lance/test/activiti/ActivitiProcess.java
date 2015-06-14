package com.lance.test.activiti;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.util.List;

/**
 * Created by perdonare on 2015/6/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-config.xml"})
public class ActivitiProcess {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    /**
     * 测试完整流程
     * 1.部署
     * 2.启动
     * 3.设置变量
     * 4.完成任务
     */

    @Test
    public void testProcess(){
        //testDeploy();
        //testStartProcess();
        //testQueryTask();
        testCompleteTask();

    }

    private void testCompleteTask() {
        taskService.setVariable("50004","testtest","testtest");
        taskService.complete("50004");
    }

    private void testDeploy(){
        InputStream inputStream = ActivitiProcess.class.getClassLoader().getResourceAsStream("activiti/MyTest.bpmn");
        repositoryService.createDeployment()
                .addInputStream("MyTest.bpmn",inputStream)
                .deploy();
    }

    private void testStartProcess() {
        runtimeService.startProcessInstanceByKey("test");
        System.out.println("流程启动成功");
    }

    private void testQueryTask() {
        String name="zhangsan";
        taskService.setAssignee("50004",name);
        List<Task> tasks = taskService.createTaskQuery()
                .taskAssignee(name)
                .list();
        for (Task task : tasks) {
            task.setAssignee(name);
            System.out.println(task.getName());
            System.out.println(task.getAssignee());
        }
    }






















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
