package com.cruise.dtx.seatademo.bank2.service.impl;

import com.cruise.dtx.seatademo.bank2.dao.AccountInfoDao;
import com.cruise.dtx.seatademo.bank2.dao.TDao;
import com.cruise.dtx.seatademo.bank2.service.AccountInfoService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    private AccountInfoDao accountInfoDao;
    @Autowired
    private TDao tDao;

    @Transactional
    @Override
    public void updateAccountBalance(String accountNo, Double amount) {
        log.info("bank2 service begin,XID：{}", RootContext.getXID());
        // 李四增加金额
        accountInfoDao.updateAccountBalance(accountNo, amount);
        // 测试插入多个表是否会回滚
        tDao.save("xxx");
        if (amount == 3) {
            //人为制造异常
            throw new RuntimeException("bank2 make exception..");
        }
    }
}
