package love.xuqinqin.suiMark.controller.account;

import love.xuqinqin.suiMark.model.Account;
import love.xuqinqin.suiMark.model.dto.AccountAndInfo;
import love.xuqinqin.suiMark.model.dto.Msg;
import love.xuqinqin.suiMark.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author FGuy
 * @Date 2020/8/20 9:11
 */
@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("accounts")
    @ResponseBody
    public List<Account> accounts(){
        return accountService.getAccounts();
    }

    @PostMapping("reg")
    @ResponseBody
    public Msg reg(AccountAndInfo accountAndInfo){
        return accountService.addAccount(accountAndInfo);
    }

    @PostMapping("login")
    @ResponseBody
    public Msg login(Account account){
        return accountService.logAccount(account);
    }



}
