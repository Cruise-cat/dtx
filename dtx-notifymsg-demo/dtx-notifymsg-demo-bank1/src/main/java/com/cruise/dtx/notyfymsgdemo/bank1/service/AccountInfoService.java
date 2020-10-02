package com.cruise.dtx.notyfymsgdemo.bank1.service;

import com.cruise.dtx.notyfymsgdemo.bank1.entity.AccountPay;
import com.cruise.dtx.notyfymsgdemo.bank1.model.AccountChangeEvent;

public interface AccountInfoService {

    /**
     * 更新账户金额
     *
     * @param accountChange
     */
    void updateAccountBalance(AccountChangeEvent accountChange);

    /**
     * 查询充值结果（远程调用）
     *
     * @param tx_no
     * @return
     */
    AccountPay queryPayResult(String tx_no);

}
