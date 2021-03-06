package com.cruise.dtx.notifymsgdemo.pay.service.impl;

import com.cruise.dtx.notifymsgdemo.pay.dao.AccountPayDao;
import com.cruise.dtx.notifymsgdemo.pay.entity.AccountPay;
import com.cruise.dtx.notifymsgdemo.pay.service.AccountPayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountPayServiceImpl implements AccountPayService {

    @Autowired
    AccountPayDao accountPayDao;

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    /**
     * 插入充值记录
     *
     * @param accountPay
     * @return
     */
    @Override
    public AccountPay insertAccountPay(AccountPay accountPay) {
        int success = accountPayDao.insertAccountPay(accountPay.getId(), accountPay.getAccountNo(), accountPay.getPayAmount(), "success");
        if (success > 0) {
            // 发送通知,使用普通消息发送通知
            // 不需要确保消息一定发送了
            accountPay.setResult("success");
            rocketMQTemplate.convertAndSend("topic_notifymsg", accountPay);
            return accountPay;
        }
        return null;
    }

    /**
     * 查询充值记录，接收通知方调用此方法来查询充值结果
     *
     * @param txNo
     * @return
     */
    @Override
    public AccountPay getAccountPay(String txNo) {
        AccountPay accountPay = accountPayDao.findByIdTxNo(txNo);
        return accountPay;
    }
}
