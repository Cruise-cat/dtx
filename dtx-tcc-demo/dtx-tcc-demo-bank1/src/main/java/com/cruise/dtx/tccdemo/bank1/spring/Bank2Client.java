package com.cruise.dtx.tccdemo.bank1.spring;

import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "tcc-demo-bank2", fallback = Bank2ClientFallback.class)
public interface Bank2Client {
    /**
     * 远程调用李四的微服务
     *
     * @param amount
     * @return
     */
    @GetMapping("/bank2/transfer")
    @Hmily // 必须带有此注解才会将全局事务 ID 传递
    Boolean transfer(@RequestParam("amount") Double amount);
}
