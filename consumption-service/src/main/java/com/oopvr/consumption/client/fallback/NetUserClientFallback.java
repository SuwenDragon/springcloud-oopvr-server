package com.oopvr.consumption.client.fallback;

import com.oopvr.consumption.client.NetUserClient;
import com.oopvr.consumption.pojo.InternetUser;
import org.springframework.stereotype.Component;

@Component
public class NetUserClientFallback implements NetUserClient {
    @Override
    public InternetUser queryUserId(int id) {
        InternetUser internetUser = new InternetUser();
        internetUser.setUserId(id);
        internetUser.setUserName("用户异常");
        return internetUser;
    }
}
