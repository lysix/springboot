package com.example.demo.dao;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @param $
 * @author liuyong
 * @ClassName UserDao
 * @Descrrption TODO
 * @return $
 * @date 20181206$ 1059$
 */

@Mapper
public interface UserDao {

    public User selectByPrimaryKey(@Param("id")int id);

    public void deleteByPrimaryKey(@Param("id") int id);

    public void updateByPrimaryKey(User user);

    public Integer insert(User user);

    public List<User> selectByUserBean(User user);

    public List<User> list();
}
