package com.lance.test.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

/**
 * Created by perdonare on 2015/6/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-config.xml"})
public class ActivitiQuery {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService  runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ProcessEngine processEngine;


    //流程定义查询
    @Test
    public  void testQueryProcessDefinition() {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                //.deploymentId("helloworld")//使用部署id查询
                .processDefinitionKey("helloworld")
                //.processDefinitionId("helloworld")//使用流程定义id查询
                //.processDefinitionKey("helloworld")//使用流程定义名称查询
                //.processDefinitionKeyLike("he")//使用流程定义名称模糊查询
                .orderByDeploymentId()//排序
                .desc()//降序
                //.list()//查询结果为列表
                .singleResult();//结果只有一个
        System.out.println(processDefinition.getId());//id是流程定义key+version+随机数
        System.out.println(processDefinition.getName());//bpmn文件中对应的name
        System.out.println(processDefinition.getKey());//bpmn文件中对应的key
        System.out.println(processDefinition.getVersion());//版本
        System.out.println(processDefinition.getResourceName());//资源部署文件名
        System.out.println(processDefinition.getDiagramResourceName());//资源部署流程图文件名
        System.out.println(processDefinition.getDeploymentId());//流程部署id
        System.out.println(processDefinition.getCategory());
    }

    //流程定义删除
    @Test
    public  void testQueryPic() throws IOException {
        InputStream inputStream = repositoryService.getResourceAsStream("12501","activiti/MyProcess.png");
        if (inputStream!=null){
            File file = new File("d:/a.png");
            FileUtils.copyInputStreamToFile(inputStream,file);
        }

    }

    //流程定义删除
    //流程定义不能修改，只能版本升级
    @Test
    public  void testDeleteProcessDefinition() {
        //不带级联的删除 只能删除没有启动的流程，否则抛出异常
        //repositoryService.deleteDeployment("15001");
        //级联的删除
        repositoryService.deleteDeployment("15001",true);
        System.out.println("删除成功");
    }

    //查询最新版本
    //技巧  map集合的特点是如果key相同，后一个值会替换前一个值
    //map.put(ProcessDefinition.getKey),ProcessDefinition)





































    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public void setProcessEngine(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }
}
