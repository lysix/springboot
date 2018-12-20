package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @param $
 * @author liuyong
 * @ClassName UserController
 * @Descrrption TODO
 * @return $
 * @date 20181206$ 1101$
 */
@Controller
@RequestMapping("user")
@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login",method = RequestMethod.GET)
    @ResponseBody
    public boolean userLoginIn(String userName,String passWord){

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)) {
            logger.error("登陆信息为空，userName={}，passWord={}",userName,passWord);
            return false;
        }

        logger.info("用户登陆信息，userName={}，passWord={}",userName,passWord);
        boolean flag = userService.login(userName,passWord);
        return flag;
    }

    @RequestMapping(value = "register",method = RequestMethod.GET)
    @ResponseBody
    public boolean registerUser(String userName ,String passWord){

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)) {
            logger.error("注册信息为空，userName={}，passWord={}",userName,passWord);
            return false;
        }

        logger.info("用户注册信息，userName={}，passWord={}",userName,passWord);
        userService.insertUser(userName,passWord);

        return true;
    }

    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView listUser(UserDto userDto, Model model){

        logger.info("查询用户列表，查询条件={}",userDto);
        List<User> users = userService.listUser(userDto);

        model.addAttribute("userList",users);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/userInfo");
        return modelAndView;
    }

    @RequestMapping("/test")
    public List<User> test() {
        System.out.println("111");
        List<User> list = userService.list();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
        return list;
    }

    @RequestMapping("test1")
    public ModelAndView list(Model model) {
        List<User> list = userService.list();
        model.addAttribute("userList", list);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userInfo");
        return modelAndView;
    }
}
