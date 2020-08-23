package love.xuqinqin.suiMark.controller.mark;

import love.xuqinqin.suiMark.model.Mark;
import love.xuqinqin.suiMark.model.dto.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author FGuy
 * @Date 2020/8/21 11:16
 */
@Controller
@RequestMapping("mark")
public class MarkController {

    @GetMapping("add")
    public String addView(){
        return "creatMark";
    }

    @PostMapping("add")
    @ResponseBody
    public Msg add(Mark mark){
        System.out.println(mark);
        return new Msg();
    }

}
