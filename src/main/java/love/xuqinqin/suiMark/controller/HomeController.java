package love.xuqinqin.suiMark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author FGuy
 * @Date 2020/8/19 14:05
 */
@Controller
@RequestMapping("say")
public class HomeController {

    @GetMapping("{msg}")
    public String home(@PathVariable("msg")String msg, Model model){

        model.addAttribute("msg",msg);

        return "home";
    }

}
