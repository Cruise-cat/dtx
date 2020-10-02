package com.cruise.dtx.txmsgdemo.bank1.service;


import com.cruise.dtx.txmsgdemo.bank1.model.AccountChangeEvent;

public interface AccountInfoService {

    /**
     * 向mq发送转账消息
     *
     * @param accountChangeEvent
     */
    void sendUpdateAccountBalance(AccountChangeEvent accountChangeEvent);

    /**
     * 更新账户，扣减金额
     *
     * @param accountChangeEvent
     */
    void doUpdateAccountBalance(AccountChangeEvent accountChangeEvent);

}
