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


/**
 * @Author FGuy
 * @Date 2020/8/20 9:11
 */
@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

//    @PostMapping("accounts")
//    @ResponseBody
//    public List<Account> accounts(){
//        return accountService.getAccounts();
//    }

    /**
     * 用户注册
     *
     * @param accountAndInfo
     * @return
     */
    @PostMapping("reg")
    @ResponseBody
    public Msg reg(AccountAndInfo accountAndInfo){
        return accountService.addAccount(accountAndInfo);
    }

    /**
     * 用户登录
     *
     * @param account
     * @param session
     * @return
     */
    @PostMapping("login")
    @ResponseBody
    public Msg login(Account account, HttpSession session){
        Msg msg = accountService.logAccount(account);
        if(msg.isFlag()){
            session.setAttribute("login",accountService.getAccountByUsername(account.getUsername()));
        }
        return msg;
    }

    /**
     * 当前用户
     *
     * @param session
     * @return
     */
    @PostMapping("now")
    @ResponseBody
    public AccountAndInfo now(HttpSession session){
        return (AccountAndInfo) session.getAttribute("login");
    }

    /**
     * 注销登录
     *
     * @param session
     * @return
     */
    @PostMapping("out")
    @ResponseBody
    public Msg out(HttpSession session){
        session.removeAttribute("login");
        return new Msg(true,"注销成功");
    }



}
