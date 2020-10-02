package com.cruise.dtx.seatademo.bank2.controller;

import com.cruise.dtx.seatademo.bank2.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bank2Controller {

    @Autowired
    AccountInfoService accountInfoService;

    /**
     * 接收张三的转账
     *
     * @param amount
     * @return
     */
    @GetMapping("/transfer")
    public String transfer(Double amount) {
        // 李四增加金额
        accountInfoService.updateAccountBalance("2", amount);
        return "bank2" + amount;
    }
}
