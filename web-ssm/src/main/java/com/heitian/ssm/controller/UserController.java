package com.heitian.ssm.controller;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.gson.Gson;
import com.heitian.ssm.model.Status;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import com.heitian.ssm.utils.Utils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
     //   model.addAttribute("ppp",userList);
        return "showUser";
    }



    @RequestMapping(value = "/getUser/{uid}",produces = "text/json;charset=UTF-8")
    public @ResponseBody String  getUser(@PathVariable("uid")String uid)
    {
        //log.info("in get user ");
        try {
            //log.info("get uid >> "+uid);
            long id = Long.parseLong(uid);
            User u = userService.getUserById(id);
            Gson gson = new Gson();
            String g = gson.toJson(u);
            //log.info(""+ g);
            return g;
        }catch (Exception e){
            e.printStackTrace();
        }

        return "fail";
    }

    @RequestMapping(value = "/addUser",consumes = "application/formed; charset=utf-8",produces ="application/json; charset=utf-8")
    public @ResponseBody String addUser(String username,String userPhone,String userEmail,String pwd)
    {
        Status status = new Status();
        //status.setStatus_code();
        Gson gson = Utils.getGson();

        User user = new User();
        user.setUserName(username);
        user.setUserEmail(userEmail);
        user.setUserPhone(userPhone);

        String salt = UUID.randomUUID().toString();
        pwd = Utils.cryptoWithAES(pwd,salt);
        user.setUserPwd(pwd);
        user.setPwdSalt(salt);


        return gson.toJson(status) ;
    }
}
