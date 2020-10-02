package com.cruise.dtx.seatademo.bank1.service;

public interface AccountInfoService {

    /**
     * 张三扣减金额
     *
     * @param accountNo
     * @param amount
     */
    void updateAccountBalance(String accountNo, Double amount);
}
