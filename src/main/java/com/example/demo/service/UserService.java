package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @param $
 * @author liuyong
 * @ClassName UserService
 * @Descrrption TODO
 * @return $
 * @date $ $
 */

public interface UserService {

    public boolean login(String userName,String passWord);

    public boolean insertUser(String userName,String passWord);

    public List<User> listUser(UserDto userDto);

    public List<User> list();
}

