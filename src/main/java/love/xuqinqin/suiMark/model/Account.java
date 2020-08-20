package love.xuqinqin.suiMark.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author FGuy
 * @Date 2020/8/20 8:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {

    private Integer id;
    private String username;
    private String password;

}
