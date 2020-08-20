package love.xuqinqin.suiMark.service;

import love.xuqinqin.suiMark.model.Account;
import love.xuqinqin.suiMark.model.dto.AccountAndInfo;
import love.xuqinqin.suiMark.model.dto.Msg;

import java.util.List;

/**
 * @Author FGuy
 * @Date 2020/8/20 9:07
 */
public interface IAccountService {

    List<Account> getAccounts();

    Msg addAccount(AccountAndInfo accountAndInfo);

}
