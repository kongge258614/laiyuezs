package com.laiyuezs.account.service;

import com.laiyuezs.account.dao.AccountRepository;
import com.laiyuezs.account.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Description：
 *
 * @author fangliangsheng
 * @date 2019-04-05
 */
@Service
public class AccountService {

    private static final String ERROR_USER_ID = "1002";

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void debit(String userId, BigDecimal num) {
        Account account = accountRepository.findByUserId(userId);

        System.out.println("---------account-----------"+account);
        account.setMoney(account.getMoney().subtract(num));
        accountRepository.save(account);

        if (ERROR_USER_ID.equals(userId)) {
            throw new RuntimeException("account branch exception");
        }
    }
}
