package love.xuqinqin.suiMark.service.impl;

import love.xuqinqin.suiMark.mapper.AccountMapper;
import love.xuqinqin.suiMark.model.Account;
import love.xuqinqin.suiMark.model.AccountInfo;
import love.xuqinqin.suiMark.model.dto.AccountAndInfo;
import love.xuqinqin.suiMark.model.dto.Msg;
import love.xuqinqin.suiMark.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author FGuy
 * @Date 2020/8/20 9:07
 */
@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> getAccounts() {
        return accountMapper.getAccounts();
    }

    /**
     * 添加账户
     *
     * @param accountAndInfo
     * @return
     */

    @Override
    public Msg addAccount(AccountAndInfo accountAndInfo) {
        if (accountAndInfo == null || this.accountAndInfoIsEmpty(this.removeBlankAccountAndInfo(accountAndInfo))) {
            return new Msg(false, "名称、账号、密码不能为空");
        }
        if (this.accountExist(accountAndInfo.getUsername())) {
            return new Msg(false, "账号已存在");
        }
        Account account = new Account(0, accountAndInfo.getUsername(), accountAndInfo.getPassword());
        AccountInfo accountInfo = new AccountInfo(0, accountAndInfo.getName());
        int i = accountMapper.addAccount(account);//影响行数
        if (i >= 1) {
            accountInfo.setId(account.getId());
            if (accountMapper.addAccountInfo(accountInfo) >= 1) {
                return new Msg(true, "注册成功");
            }
        }
        return new Msg(false, "注册异常请重试");
    }

    /**
     * 登录账户
     *
     * @param account
     * @return
     */

    public Msg logAccount(Account account) {
        if (account == null || this.accountIsEmpty(this.removeBlankAccount(account))) {
            return new Msg(false, "账号、密码不能为空");
        }
        if (!this.accountExist(account.getUsername())) {
            return new Msg(false, "账号不存在");
        }
        if (accountMapper.getAccountByUsername(account.getUsername()).getPassword().equals(account.getPassword())) {
            return new Msg(true,"登录成功");
        }
        return new Msg(false, "用户名或密码错误");
    }


    /**
     * 账户信息是否为空
     *
     * @param accountAndInfo
     * @return
     */
    private boolean accountAndInfoIsEmpty(AccountAndInfo accountAndInfo) {
        String name = accountAndInfo.getName();
        String username = accountAndInfo.getUsername();
        String password = accountAndInfo.getPassword();
        return name.equals("") || username.equals("") || password.equals("");
    }

    /**
     * 账户是否为空
     *
     * @param account
     * @return
     */
    private boolean accountIsEmpty(Account account) {
        String username = account.getUsername();
        String password = account.getPassword();
        return username.equals("") || password.equals("");
    }

    /**
     * 去掉账户信息对象属性空白
     *
     * @param accountAndInfo
     * @return
     */
    private AccountAndInfo removeBlankAccountAndInfo(AccountAndInfo accountAndInfo) {
        accountAndInfo.setName(accountAndInfo.getName().replace(" ", ""));
        accountAndInfo.setUsername(accountAndInfo.getUsername().replace(" ", ""));
        accountAndInfo.setPassword(accountAndInfo.getPassword().replace(" ", ""));
        return accountAndInfo;
    }

    /**
     * 去掉账户对象属性空白
     *
     * @param account
     * @return
     */
    private Account removeBlankAccount(Account account) {
        account.setUsername(account.getUsername().replace(" ", ""));
        account.setPassword(account.getPassword().replace(" ", ""));
        return account;
    }


    /**
     * 账户是否存在
     *
     * @param username
     * @return
     */
    private boolean accountExist(String username) {
        System.out.println(accountMapper.getAccountByUsername(username));
        return accountMapper.getAccountByUsername(username) != null;
    }


}

