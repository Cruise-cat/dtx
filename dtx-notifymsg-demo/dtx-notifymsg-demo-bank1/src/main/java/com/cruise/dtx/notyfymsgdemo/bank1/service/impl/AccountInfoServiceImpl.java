package com.cruise.dtx.notyfymsgdemo.bank1.service.impl;

import com.cruise.dtx.notyfymsgdemo.bank1.dao.AccountInfoDao;
import com.cruise.dtx.notyfymsgdemo.bank1.entity.AccountPay;
import com.cruise.dtx.notyfymsgdemo.bank1.model.AccountChangeEvent;
import com.cruise.dtx.notyfymsgdemo.bank1.service.AccountInfoService;
import com.cruise.dtx.notyfymsgdemo.bank1.spring.PayClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    AccountInfoDao accountInfoDao;

    @Autowired
    PayClient payClient;

    /**
     * 更新账户金额
     *
     * @param accountChange
     */
    @Override
    @Transactional
    public void updateAccountBalance(AccountChangeEvent accountChange) {
        //幂等校验
        if (accountInfoDao.isExistTx(accountChange.getTxNo()) > 0) {
            log.info("已处理：{}", accountChange.getTxNo());
            return;
        }
        accountInfoDao.updateAccountBalance(accountChange.getAccountNo(), accountChange.getAmount());
        // 判断 RocketMQ 是否会重发消息
        if (accountChange.getAmount() == 1000) {
            throw new RuntimeException();
        }
        // 插入事务记录，用于幂等控制
        accountInfoDao.addTx(accountChange.getTxNo());
    }

    /**
     * 远程调用查询充值结果
     *
     * @param tx_no
     * @return
     */
    @Override
    public AccountPay queryPayResult(String tx_no) {
        // 远程调用
        AccountPay payresult = payClient.payResult(tx_no);
        if ("success".equals(payresult.getResult())) {
            // 更新账户金额
            AccountChangeEvent accountChangeEvent = new AccountChangeEvent();
            // 账号
            accountChangeEvent.setAccountNo(payresult.getAccountNo());
            // 金额
            accountChangeEvent.setAmount(payresult.getPayAmount());
            // 充值事务号
            accountChangeEvent.setTxNo(payresult.getId());
            updateAccountBalance(accountChangeEvent);
        }
        return payresult;
    }
}
