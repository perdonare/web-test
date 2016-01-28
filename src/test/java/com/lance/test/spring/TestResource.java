package com.lance.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2015/12/19.
 */
public class TestResource {
    private Resource resource;

    public Resource show() {
        System.out.println(resource);
        return resource;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
