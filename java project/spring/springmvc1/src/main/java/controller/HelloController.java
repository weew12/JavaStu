package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname HelloController
 * @Description
 * @Date 2019-11-30
 * @Created by 枫weew12
 */
/*控制器*/
@Controller
@RequestMapping("/hello")
public class HelloController {

    /*action*/
    @RequestMapping("/hi")
    public String hi(Model model) {
        //向模型中添加属性msg与值，将与页面模板渲染后输出
        model.addAttribute("msg","hello spring mvc!");
        return "hi";
    }
}
