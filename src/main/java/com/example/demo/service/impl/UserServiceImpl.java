package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

import com.example.demo.utils.passWordM5Util;
import com.example.demo.utils.primaryKeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.List;


/**
 * @param $
 * @author liuyong
 * @ClassName UserServiceImpl
 * @Descrrption TODO
 * @return $
 * @date $ $
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao userDao;

    @Override
    public boolean login(String userName, String passWord) {

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)) {
            logger.error("登录信息为空，username={},passWord={}",userName,passWord);
            return false;
        }

        logger.info("登录信息，username={},passWord={}",userName,passWord);

        User user = new User();
        user.setName(userName);

        String newPassWord = passWordM5Util.passWordMd5(passWord);
        user.setPassword(newPassWord);

        User loginUser = null;
        try {
            loginUser = userDao.selectByUserBean(user).get(0);
            //throw new Exception();
        } catch (Exception e) {
            logger.error("登录异常，username={},passWord={}，异常信息为",userName,passWord,e);
        }

        if (loginUser != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean insertUser(String userName, String passWord) {

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)){
            logger.error("新增用户信息为空，userName{},passWord={}",userName,passWord);
        }

        User user = new User();
        user.setId(primaryKeyUtil.makePrimaryKey());
        user.setName(userName);

        String newPassWord = passWordM5Util.passWordMd5(passWord);
        user.setPassword(newPassWord);

        Integer i = userDao.insert(user);
        if (i == 1){
            logger.info("i==1");
            return  true;
        }
        return false;
    }

    @Override
    public List<User> listUser(UserDto userDto) {

        logger.info("查询用户表，查询条件={}",userDto);

        String id = userDto.getId();
        String name = userDto.getName();

        User user = new User();

        if (id != null && !id.equalsIgnoreCase("")) {
            user.setId(id);
        }

        if (name != null && !name.equalsIgnoreCase("")) {
            user.setName(name);
        }

        List<User> users = null;
        try {
            users = userDao.selectByUserBean(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        logger.info(""+users.size());
        return users;
    }
}
