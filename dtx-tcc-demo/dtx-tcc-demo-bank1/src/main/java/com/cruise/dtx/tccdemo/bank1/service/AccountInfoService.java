package com.cruise.dtx.tccdemo.bank1.service;

public interface AccountInfoService {

    /**
     * 账户扣款
     *
     * @param accountNo
     * @param amount
     */
    void updateAccountBalance(String accountNo, Double amount);
}
