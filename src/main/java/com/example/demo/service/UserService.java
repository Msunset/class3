package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.vo.UserVo;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;


public interface UserService {

    /**
     * 查找所有用户
     * @return
     */
    List<User> findUser();

    /**
     * 批量插入到数据库
     * @param users
     */
    void saveData(List<User> users);

    /**
     * 获取ID
     * @param user
     */
    void getUserInfo(UserVo user);


    /**
     * 添加用户
     * @param user
     */
    String addUser(User user);


    /**
     * 删除用户信息
     * @param user
     */
    String   deleteUser(User user);


    /**
     * 修改用户
     * @param user
     * @return
     */
    String updateUser(User user);


}
