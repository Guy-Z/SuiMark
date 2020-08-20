package love.xuqinqin.suiMark.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author FGuy
 * @Date 2020/8/20 19:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountAndInfo {

    private String name;
    private String username;
    private String password;

}
