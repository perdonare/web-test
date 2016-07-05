package com.lance.test.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by perdonare on 2016/6/24.
 */
public class MockitoTest {

    @Test
    public void helloWorldTest() {
        List<String> list =  mock(List.class);
        when(list.get(0)).thenReturn("hello world");
        String result = list.get(0);
        verify(list).get(0);
        Assert.assertEquals("hello world",result);
    }
}
