package com.lance.service.activiti;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by perdonare on 2015/6/16.
 */
public interface IActivitiService {

    boolean deploy(List<MultipartFile> list,String name);
    void createActiviti(String username,String processDefinationKey,Map<String,Object> variables);
    List<Task> getUserActiviti(String user);
    void completeUserActiviti(String taskId);
    List<ProcessDefinition> getActivitiDeployBO();
    void deleteProcessDefinition(String deploymentId);

    void getActivitiPic(HttpServletResponse response, String deploymentId, String diagramResourceName);
}
