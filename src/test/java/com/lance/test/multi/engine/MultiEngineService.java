package com.lance.test.multi.engine;

import com.baidu.unbiz.multitask.annotation.TaskBean;
import com.baidu.unbiz.multitask.annotation.TaskService;

import java.util.List;

/**
 * Created by perdonare on 2016/10/15.
 */
@TaskService
public class MultiEngineService{
    @TaskBean("deviceStatFetcher")
    public List<DeviceStatViewItem> queryPlanDeviceData(DeviceStatRequest req) {
        this.checkParam(req);
        return this.mockList1();
    }

    @TaskBean("deviceUvFetcher")
    public List<DeviceUvViewItem> queryPlanDeviceUvData(DeviceUvRequest req) {
        this.checkParam(req);
        return this.mockList2();
    }
}
