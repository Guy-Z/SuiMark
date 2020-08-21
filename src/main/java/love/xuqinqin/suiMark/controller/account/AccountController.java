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

import javax.servlet.http.HttpSession;
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
    public Msg login(Account account, HttpSession session){
        Msg msg = accountService.logAccount(account);
        if(msg.isFlag()){
            session.setAttribute("login",accountService.getAccountByUsername(account.getUsername()));
        }
        System.out.println(session.getAttribute("login"));
        return msg;
    }

    @PostMapping("now")
    @ResponseBody
    public AccountAndInfo now(HttpSession session){
        return (AccountAndInfo) session.getAttribute("login");
    }

    @PostMapping("out")
    @ResponseBody
    public Msg out(HttpSession session){
        session.removeAttribute("login");
        return new Msg(true,"注销成功");
    }



}
