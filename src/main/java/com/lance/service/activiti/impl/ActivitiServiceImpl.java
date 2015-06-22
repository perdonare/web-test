package com.lance.service.activiti.impl;

import com.lance.persistence.mapper.UserLeaveMapper;
import com.lance.persistence.model.UserLeavePO;
import com.lance.service.activiti.IActivitiService;
import com.lance.service.activiti.impl.vo.ActivitiDeployBO;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * Created by perdonare on 2015/6/16.
 */
@Service
public class ActivitiServiceImpl implements IActivitiService {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private UserLeaveMapper userLeaveMapper;

    @Override
    public List<Task> getUserActiviti(String user) {
        return taskService.createTaskQuery().taskAssignee(user).list();
    }

    @Override
    public void completeUserActiviti(String taskId) {
        taskService.complete(taskId);
    }

    @Override
    public List<ProcessDefinition> getActivitiDeployBO() {
        return repositoryService.createProcessDefinitionQuery().orderByProcessDefinitionName().desc().list();
    }

    @Override
    public void deleteProcessDefinition(String deploymentId) {
        repositoryService.deleteDeployment(deploymentId);
    }

    @Override
    public boolean deploy(List<MultipartFile> list, String name) {
        for (MultipartFile multipartFile : list) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(multipartFile.getBytes());
                ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);
                repositoryService.createDeployment().addZipInputStream(zipInputStream).name(name).deploy();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void createActiviti(String username, String processDefinationKey, Map<String, Object> variables) {
        runtimeService.startProcessInstanceByKey(processDefinationKey, variables);
    }

    @Override
    public void getActivitiPic(HttpServletResponse response, String deploymentId, String diagramResourceName) {

        try (InputStream inputStream = repositoryService.getResourceAsStream(deploymentId, diagramResourceName);
             OutputStream outputStream = response.getOutputStream()) {
            byte[] bytes = new byte[1024];
            int count = 0;
            while ((count = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void startActiviti(int userLeaveId) {
        UserLeavePO userLeavePO = userLeaveMapper.selectUserLeaveById(userLeaveId);
        //runtimeService.startProcessInstanceById("3" )
    }
}
