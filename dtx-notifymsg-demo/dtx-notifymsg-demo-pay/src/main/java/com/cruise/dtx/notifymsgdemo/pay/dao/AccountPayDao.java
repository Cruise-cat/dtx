package com.cruise.dtx.notifymsgdemo.pay.dao;

import com.cruise.dtx.notifymsgdemo.pay.entity.AccountPay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AccountPayDao {
    /**
     * 插入充值记录
     *
     * @param id
     * @param accountNo
     * @param pay_amount
     * @param result
     * @return
     */
    @Insert("insert into account_pay(id,account_no,pay_amount,result) values(#{id},#{accountNo},#{payAmount},#{result})")
    int insertAccountPay(@Param("id") String id, @Param("accountNo") String accountNo, @Param("payAmount") Double pay_amount, @Param("result") String result);

    /**
     * 查询充值记录
     *
     * @param txNo
     * @return
     */
    @Select("select id,account_no accountNo,pay_amount payAmount,result from account_pay where id=#{txNo}")
    AccountPay findByIdTxNo(@Param("txNo") String txNo);

}
