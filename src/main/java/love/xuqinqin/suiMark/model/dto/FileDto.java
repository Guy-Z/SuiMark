package love.xuqinqin.suiMark.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author FGuy
 * @Date 2020/8/23 15:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileDto {

    private int success;
    private String message;
    private String url;

}
