package com.lance.batch;

import com.lance.persistence.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.CompositeItemProcessor;

/**
 * Created by perdonare on 2015/7/12.
 */
public class FileItemProcessor implements ItemProcessor{
    @Override
    public Object process(Object item) throws Exception {
        String[] strings = (String[]) item;
        User user = new User();
        for (String str : strings){
            user.setName(str);
            System.out.println(str);
        }

        return user;
    }
}
