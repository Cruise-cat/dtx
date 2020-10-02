package com.cruise.dtx.notyfymsgdemo.bank1.spring;

import com.cruise.dtx.notyfymsgdemo.bank1.entity.AccountPay;
import org.springframework.stereotype.Component;

@Component
public class PayFallback implements PayClient {

    @Override
    public AccountPay payResult(String txNo) {
        AccountPay accountPay = new AccountPay();
        accountPay.setResult("fail");
        return accountPay;
    }
}
