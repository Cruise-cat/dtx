package com.cruise.dtx.notifymsgdemo.pay.service;

import com.cruise.dtx.notifymsgdemo.pay.entity.AccountPay;

public interface AccountPayService {

    /**
     * 充值
     *
     * @param accountPay
     * @return
     */
    AccountPay insertAccountPay(AccountPay accountPay);

    /**
     * 查询充值结果
     *
     * @param txNo
     * @return
     */
    AccountPay getAccountPay(String txNo);
}
