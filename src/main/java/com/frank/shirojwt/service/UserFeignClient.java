package com.frank.shirojwt.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 小石潭记
 * @date 2020/6/22 21:48
 * @Description: ${todo}
 */
@FeignClient(
    //服务名
    name = "user-service",
    //服务地址
    url = "http://localhost:8081/api"
)
public interface UserFeignClient {

    //对应的服务里的接口地址，及请求方式
    @RequestMapping(value = "/getSuccessInfo", method = RequestMethod.GET)
    @ResponseBody
    String getSuccessInfo();

    @RequestMapping(value = "/getFailInfo", method = RequestMethod.GET)
    @ResponseBody
    String getFailInfo();

    /**
     * 容错处理类，当调用失败时，简单返回空字符串
     */
    @Component
    class DefaultFallback implements UserFeignClient {
        @Override
        public String getSuccessInfo(){
            return "getSuccessInfo serve is bad.";
        }

        @Override
        public String getFailInfo() {
            return "getFailInfo serve is bad.";
        }
    }
}
