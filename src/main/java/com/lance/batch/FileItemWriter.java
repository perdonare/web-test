package com.lance.batch;

import com.lance.persistence.model.User;
import org.springframework.batch.item.file.ResourceAwareItemWriterItemStream;
import org.springframework.batch.item.support.AbstractItemStreamItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import java.util.List;

/**
 * Created by perdonare on 2015/7/12.
 */
public class FileItemWriter<T> extends AbstractItemStreamItemWriter<T> implements ResourceAwareItemWriterItemStream<T>, InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setResource(Resource resource) {

    }

    @Override
    public void write(List<? extends T> items) throws Exception {
        for (T t : items){
            User user = (User) t;
            System.out.println(user.getName());
        }
    }

}
