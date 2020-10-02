package com.cruise.dtx.notyfymsgdemo.bank1.spring;

import com.cruise.dtx.notyfymsgdemo.bank1.entity.AccountPay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 远程调用pay充值系统
 */
@FeignClient(value = "dtx-notifymsg-demo-pay", fallback = PayFallback.class)
public interface PayClient {

    /**
     * 远程调用充值系统的接口查询充值结果
     *
     * @param txNo
     * @return
     */
    @GetMapping(value = "/pay/payResult/{txNo}")
    AccountPay payResult(@PathVariable("txNo") String txNo);
}
