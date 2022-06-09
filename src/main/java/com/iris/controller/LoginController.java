package com.iris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Description:
 * Author: zyq
 * Version: 1.0
 * Create Date Time: 2022/6/5 10:32.
 * Update Date Time:
 *
 * @see
 */
@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){
        // 用户的业务判断
        if (!StringUtils.isEmpty(username) && "111".equals(password)){
            session.setAttribute("loginuser", username);
            return "redirect:/dashboard.html";
        }else {
            model.addAttribute("msg", "username or password wrong ");
            return "index";
        }
    }
}
