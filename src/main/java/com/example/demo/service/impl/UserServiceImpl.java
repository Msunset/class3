package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.domain.dto.UserDto;
import com.example.demo.domain.vo.UserVo;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class UserServiceImpl implements UserService {




    @Value("${target.url}")
    private String TARGET_URL;
    @Value("${source.url}")
    private String SOURCE_URL;

    @Autowired
    private UserMapper userMapper;


    /**
     * 查找所有用户
     * @return
     */
    @Override
    public List<User> findUser() {

        return userMapper.findUser();
    }
    /**
     * 批量插入数据库
     * @param users
     */
    @Override
    public void saveData(List<User> users) {

        System.out.println("----");
        userMapper.insertUser(users);
        System.out.println("存入成功");

    }
    /**
     *  word格式
     * @param user
     */
    @Override
    public void getUserInfo(UserVo user) {
        String s = this.getClass().getResource("/").getPath().replaceFirst("/", "");
        UserDto userInfo = userMapper.getUserInfo(user.getId());
        userInfo.setDate(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
        try {
            Configuration configuration = new Configuration(new Version("2.3.0"));
            configuration.setDefaultEncoding("utf-8");
            configuration.setDirectoryForTemplateLoading(new File(s+"static"));
            File outFile = new File(TARGET_URL+"/" + userInfo.getName() + "--" + userInfo.getCertificateNumber() + ".doc");
            Template template = configuration.getTemplate("test.ftl", "utf-8");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
            template.process(userInfo, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        /**
         *添加用户信息
         * @param user
         * @return
         */
        @Override
        public String addUser (User user){
            UserDto userInfo = userMapper.getUserInfoByIdCard(user.getIdcard());
            if (userInfo!=null){
                return "身份证号重复";

            }
            userMapper.addUser(user);

            return "添加成功";
        }


    /**
     * 删除
     * @param user
     */
    @Override
    public String deleteUser(User user) {

            userMapper.deleteUser(user.getId());
            return "删除成功";
    }


    /**
     * 修改
     * @param user
     */
    @Override
    public String updateUser(User user) {
        UserDto userInfo = userMapper.getUserInfoByIdCard(user.getIdcard());
//        UserDto userInfoByIdCard = userMapper.getUserInfoByIdCard(user.getIdcard());

        if (userInfo!=null){
            return "修改失败，身份证信息重复";
        }

        userMapper.updateUser(user);
        return "修改成功";
    }


}
