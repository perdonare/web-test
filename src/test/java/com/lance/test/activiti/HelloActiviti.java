package com.lance.test.activiti;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by perdonare on 2015/6/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-config.xml"})
public class HelloActiviti {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService  runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;

    /**
     * 完整流程
     * 1.部署流程
     * 2.启动流程
     * 3.查询个人流程
     * 4.完成流程
     * 5.下个流程处理
     */

    //部署流程
    @Test
    public  void deployProcessDefinition(){
        Deployment deployment = repositoryService.createDeployment()//创建部署对象
                .name("helloworld")//添加部署的名称
                .addClasspathResource("activiti/MyProcess.bpmn")//添加资源，一次只能添加一个
                .addClasspathResource("activiti/MyProcess.png")
                .deploy();//部署
        System.out.println("deploy id is " + deployment.getId());
        System.out.println("deploy name is " + deployment.getName());
    }
    @Test
    //启动流程
    public  void startProcessInstance(){
        String processEngineKey = "test";
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processEngineKey);
        System.out.println("processDefinitionId is " + processInstance.getProcessDefinitionId());
        System.out.println("processInstanceId is " + processInstance.getId());

    }

    @Test
    //查询当前人的个人任务
    public void queryUserTask(){
        String assignee = "张三";
        List<Task> tasks = taskService.createTaskQuery()
                .taskAssignee(assignee)
                .list();
        if (tasks!=null && tasks.size()>0){
            for (Task task : tasks) {
                System.out.println("任务ID    " + task.getId());
                System.out.println("任务名称    " + task.getName());
                System.out.println("任务创建时间  " + task.getCreateTime());
                System.out.println("任务办理人   " + task.getAssignee());
                System.out.println("任务流程实例ID    " + task.getProcessInstanceId());
                System.out.println("执行对象ID"  + task.getExecutionId());
            }
        }
    }

    @Test
    //完成流程
    public void completeUserTask(){
        //String taskId = "2504";
        //String taskId = "5002";
        String taskId = "32502";
        taskService.complete(taskId);
        System.out.println("完成任务，任务ID:  " + taskId);
    }

    @Test
    //查询当前人的个人任务
    public void queryNextUserTask(){
        //String assignee = "李四";
        String assignee = "王五";
        List<Task> tasks = taskService.createTaskQuery()
                .taskAssignee(assignee)
                .list();
        if (tasks!=null && tasks.size()>0){
            for (Task task : tasks) {
                System.out.println("任务ID    " + task.getId());
                System.out.println("任务名称    " + task.getName());
                System.out.println("任务创建时间  " + task.getCreateTime());
                System.out.println("任务办理人   " + task.getAssignee());
                System.out.println("任务流程实例ID    " + task.getProcessInstanceId());
                System.out.println("执行对象ID"  + task.getExecutionId());
            }
        }
    }

    @Test
    //判断当前流程实例是否已经结束
    public void checkProcessInstanceRunning(){
        String instanceId = "20001";
        ProcessInstance processInstance =  runtimeService.createProcessInstanceQuery()
                .processInstanceId(instanceId)
                .singleResult();
        if (processInstance ==null){
            System.out.println("编号为 " +instanceId+"的流程实例已经结束");
        } else {
            System.out.println("编号为 " +instanceId+"的流程实例正在运行");
        }
    }

    @Test
    //查询历史任务
    public void queryTaskHistory(){
        String assignee = "张三";
        List<HistoricTaskInstance> historicTaskInstances = historyService.createHistoricTaskInstanceQuery()
                .taskCreatedBefore(new Date())
                .list();

        for (HistoricTaskInstance historicTaskInstance : historicTaskInstances) {
            System.out.println(historicTaskInstance.getName());
            System.out.println(historicTaskInstance.getStartTime());
            System.out.println(historicTaskInstance.getEndTime());
            System.out.println(historicTaskInstance.getProcessInstanceId());
        }
    }

    @Test
    //查询历史流程纪录
    public void queryProcessInstanceHistory(){
        List<HistoricProcessInstance> historicProcessInstances = historyService.createHistoricProcessInstanceQuery()
                .finishedBefore(new Date())
                .list();
        for (HistoricProcessInstance historicProcessInstance : historicProcessInstances){
            System.out.println(historicProcessInstance.getProcessDefinitionId());
            System.out.println(historicProcessInstance.getName());
            System.out.println(historicProcessInstance.getDeleteReason());

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

    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }
}
