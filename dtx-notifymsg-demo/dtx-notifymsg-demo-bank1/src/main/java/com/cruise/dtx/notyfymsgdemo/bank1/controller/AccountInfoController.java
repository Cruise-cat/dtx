package com.cruise.dtx.notyfymsgdemo.bank1.controller;

import com.cruise.dtx.notyfymsgdemo.bank1.entity.AccountPay;
import com.cruise.dtx.notyfymsgdemo.bank1.service.AccountInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AccountInfoController {

    @Autowired
    private AccountInfoService accountInfoService;

    /**
     * 主动查询充值结果
     *
     * @param txNo 事务 ID
     * @return
     */
    @GetMapping(value = "/payResult/{txNo}")
    public AccountPay result(@PathVariable("txNo") String txNo) {
        AccountPay accountPay = accountInfoService.queryPayResult(txNo);
        return accountPay;
    }
}
