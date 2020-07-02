package com.pp.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.pp.common.ResultObj;
import com.pp.pojo.User;
import com.pp.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    Userservice userservice;
    @RequestMapping("/tologin")
    public String ToLogin(){
        return "login";
    }
    @RequestMapping("/login")
   @ResponseBody
    public ResultObj login(@RequestParam("loginname")String loginname,@RequestParam("pwd")String password,@RequestParam("code")String code,HttpSession session){
        User user = userservice.FindUser(loginname, password);
        //先判断验证码，如果验证码不对就不用查
        Object getcode = session.getAttribute("code");
        System.out.println(getcode);
        if (null!=code&&getcode.equals(code)){
           if (null!=user){
               session.setAttribute("user",user);
               return new ResultObj(200, "登陆成功");
           }else{
               return new ResultObj(-1,"用户名密码不正确");
           }
        }else
        {
            return new ResultObj(-1,"验证码不正确");
        }

    }
    @RequestMapping("/getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(116, 36, 4, 10);
        String code = captcha.getCode();
        session.setAttribute("code",code);
        System.out.println(code);
        ServletOutputStream outputStream = response.getOutputStream();
        captcha.write(outputStream);
        outputStream.close();
    }
}
