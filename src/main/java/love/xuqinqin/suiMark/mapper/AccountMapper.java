package love.xuqinqin.suiMark.mapper;

import love.xuqinqin.suiMark.model.Account;
import love.xuqinqin.suiMark.model.AccountInfo;
import love.xuqinqin.suiMark.model.dto.AccountAndInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author FGuy
 * @Date 2020/8/19 14:57
 */
@Mapper
public interface AccountMapper {

    List<Account> getAccounts();

    Integer addAccount(Account account);

    Integer addAccountInfo(AccountInfo accountInfo);

    Account getAccountByUsername(String username);

    AccountInfo getAccountInfoByUsername(Integer id);

}
