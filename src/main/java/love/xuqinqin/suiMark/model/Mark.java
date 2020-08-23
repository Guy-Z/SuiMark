package love.xuqinqin.suiMark.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author FGuy
 * @Date 2020/8/22 12:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mark {

    private Integer id;
    private Integer creator;
    private String content;
    private Long creat_time;
    private Long editor_time;
    private Integer status;

}
