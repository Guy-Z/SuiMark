package love.xuqinqin.suiMark.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author FGuy
 * @Date 2020/8/20 19:50
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Msg {

    private boolean flag;
    private String msg;

}
