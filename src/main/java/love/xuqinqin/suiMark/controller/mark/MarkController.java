package love.xuqinqin.suiMark.controller.mark;

import love.xuqinqin.suiMark.model.Mark;
import love.xuqinqin.suiMark.model.dto.AccountAndInfo;
import love.xuqinqin.suiMark.model.dto.Msg;
import love.xuqinqin.suiMark.service.impl.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author FGuy
 * @Date 2020/8/21 11:16
 */
@Controller
@RequestMapping("mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    @GetMapping("add")
    public String addView() {
        return "creatMark";
    }

    @PostMapping("add")
    @ResponseBody
    public Msg add(Mark mark, HttpSession session) {
        AccountAndInfo accountAndInfo;
        if (session.getAttribute("login") != null) {
            accountAndInfo = (AccountAndInfo) session.getAttribute("login");
        }else{
            return new Msg(false,"未登录账户");
        }

        mark.setCreator(accountAndInfo.getId());
        mark.setCreat_time(System.currentTimeMillis());
        mark.setEditor_time(mark.getCreat_time());

        if(markService.addMark(mark) >= 1){
         return new Msg(true,"提交成功");
        }
        return new Msg(false, "失败，请重试");
    }

}
