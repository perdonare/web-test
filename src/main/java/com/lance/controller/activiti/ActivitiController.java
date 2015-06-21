package com.lance.controller.activiti;

import com.lance.controller.base.BaseController;
import com.lance.persistence.model.UserLeavePO;
import com.lance.persistence.service.IUserLeaveService;
import com.lance.service.activiti.IActivitiService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by perdonare on 2015/6/16.
 */
@Controller
@RequestMapping("/activiti")
public class ActivitiController extends BaseController{

    @Resource
    private IActivitiService activitiService;

    @Resource
    private IUserLeaveService userLeaveService;

    /**
     * 展示当前用户所有流程
     */
    @RequestMapping("show")
    public String  showActiviti(HttpSession session){
        String user = (String) session.getAttribute("user");

        return "activiti/show";
    }

    /**
     * 查看当前流程
     */
    @RequestMapping("view")
    public ModelAndView viewActiviti(HttpSession session){
        String username = (String) session.getAttribute("username");
        List<UserLeavePO> userLeafPOs = userLeaveService.getList(username);
        ModelAndView modelAndView = new ModelAndView("activiti/userActiviti");
        modelAndView.addObject("userLeavePOs", userLeafPOs);
        return modelAndView;
    }

    /**
     * 审批当前流程
     */
    @RequestMapping("check")
    public String checkActiviti(String processDefinationKey){
        return "activiti/check";
    }

    /**
     * 审批完成
     */
    @RequestMapping("complete")
    public String completeActiviti(){
        return "activiti/complete";
    }

    /**
     * 部署流程
     */
    @RequestMapping("deploy")
     public ModelAndView deployActiviti(){
        List<ProcessDefinition> processDefinitions = activitiService.getActivitiDeployBO();
        ModelAndView modelAndView = new ModelAndView("activiti/deploy");
        modelAndView.addObject("processDefinitions",processDefinitions);
        return modelAndView;
    }

    /**
     * 部署流程处理
     */
    @RequestMapping(value = "deploy-process",method= RequestMethod.POST)
    public String deployActivitiProcess(HttpServletRequest request,HttpSession session,String name){
        List<MultipartFile> list = convertRequestToFileList(request);
        if (activitiService.deploy(list,name)){
            session.setAttribute("deployFlag",true);
        } else {
            session.setAttribute("deployFlag",false);
        }
        return "redirect:deploy";
    }

    /**
     * 终止流程
     */
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public String deleteActiviti(String deploymentId){
        activitiService.deleteProcessDefinition(deploymentId);
        return "redirect:deploy";
    }

    /**
     * 查看流程图片
     */
    @RequestMapping("showPic")
    public void viewPic(HttpServletResponse response,String deploymentId,String diagramResourceName){
        activitiService.getActivitiPic(response,deploymentId,diagramResourceName);
    }

    @RequestMapping("add")
    public String addActviti(){
        return "activiti/add";
    }

    @RequestMapping(value = "addUserLeave",method = RequestMethod.POST)
    public String addUserLeave(HttpSession session,UserLeavePO userLeavePO){
        userLeavePO.setName((String) session.getAttribute("username"));
        userLeavePO.setStatus("0");
        userLeaveService.add(userLeavePO);
        return "redirect:view";
        //return "activiti/userActiviti";
    }

}
