package com.cruise.dtx.txmsgdemo.bank2.service;

import com.cruise.dtx.txmsgdemo.bank2.model.AccountChangeEvent;

public interface AccountInfoService {

    /**
     * 更新账户，增加金额
     *
     * @param accountChangeEvent
     */
    void addAccountInfoBalance(AccountChangeEvent accountChangeEvent);
}
