package com.example.demo.mapper;

import com.example.demo.domain.User;
import com.example.demo.domain.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    /**
     * 查找所有用户信息
     * @return
     */
    List<User> findUser();

    /**
     * 批量插入（excel）
     * @param users
     */
    void insertUser(List<User> users);

    /**
     * 获取ID（word）
     * @param id
     * @return
     */
    UserDto getUserInfo(Integer id);


    /**
     * 添加用户
     * @param user
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int   deleteUser(Integer id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int  updateUser(User user);


    /**
     * 获取身份证号
     * @param idCard
     * @return
     */
    UserDto getUserInfoByIdCard(String idCard);
}
