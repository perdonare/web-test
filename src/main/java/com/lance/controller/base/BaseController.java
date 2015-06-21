package com.lance.controller.base;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by perdonare on 2015/6/20.
 */
public class BaseController {
    public List convertRequestToFileList(HttpServletRequest request){
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        Map<String,MultipartFile> map = Maps.newHashMap();
        List<MultipartFile> list = Lists.newArrayList();
        map = multipartHttpServletRequest.getFileMap();
        for (Map.Entry<String,MultipartFile> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }

}
