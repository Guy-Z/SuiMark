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
import java.util.List;

/**
 * @Author FGuy
 * @Date 2020/8/21 11:16
 */
@Controller
@RequestMapping("mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    /**
     * 添加'随记'页面
     *
     * @return
     */
    @GetMapping("add")
    public String addView() {

        /*
            需验证登录
         */

        return "creatMark";
    }

    /**
     * 添加'随记'
     *
     * @param mark
     * @param session
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public Msg add(Mark mark, HttpSession session) {
        if (!this.isLogin(session)) {
            return new Msg(false, "未登录");
        }

        if (markService.addMark(mark, (AccountAndInfo) session.getAttribute("login")) >= 1) {
            return new Msg(true, "提交成功");
        }
        return new Msg(false, "失败，请重试");
    }

    /**
     * 我的'随记'
     *
     * @param session
     * @return
     */
    @PostMapping("mine")
    @ResponseBody
    public List<Mark> myMark(HttpSession session){
        if (!this.isLogin(session)) {
            return null;
        }
        return markService.getMarkByCreator(((AccountAndInfo) session.getAttribute("login")).getId());
    }

    /**
     * 编辑'随记'
     *
     * @param mark
     * @param session
     * @return
     */
    @PostMapping("edit")
    @ResponseBody
    public Msg edit(Mark mark,HttpSession session){

        if (!this.isLogin(session)) {
            return new Msg(false,"未登录");
        }

        if(markService.updateMark(mark,(AccountAndInfo) session.getAttribute("login")) >= 1){
            return new Msg(true,"编辑成功");
        }

        return new Msg(false,"失败，请重试");
    }


    @PostMapping("del")
    @ResponseBody
    public Msg del(Integer id,HttpSession session){
        return new Msg();
    }



    //******************************************************************************************************************

    /**
     * 该session是否有用户登录
     *
     * @param session
     * @return
     */
    private boolean isLogin(HttpSession session) {
        return (session.getAttribute("login") != null) && session.getAttribute("login") instanceof AccountAndInfo;
    }

}
