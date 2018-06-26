package com.springboot.controller;


import com.springboot.Dao.AccountDao;
import com.springboot.Util.RedisUtils;
import com.springboot.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by fangzhipeng on 2017/4/20.
 * 这里省略了service层，实际开发加上；
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountDao accountDao;

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountDao.findAll();
    }

    @RequestMapping(value = "/{byid}", method = RequestMethod.GET)
    public Account getAccountById(int id) {
        return accountDao.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        Account account1 = accountDao.saveAndFlush(account);

        return account1.toString();

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        Account account1 = accountDao.save(account);
        return account1.toString();

    }

    @RequestMapping("/saveRedisSql")
    public void saveRedisSql(Map<String, Object> model){
        List<Account> accountList = accountDao.findAll();
        redisUtils.set("accountList",accountList);
    }

    @RequestMapping("/getRedisSql")
    public Object getRedisSql(Map<String, Object> model){
        Object accountList = redisUtils.get("accountList");
        System.out.println(accountList);
        return accountList;
    }
}
