package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.domain.dto.UserDto;
import com.example.demo.domain.dto.UserWordDto;
import com.example.demo.domain.vo.UserVo;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
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

    @Value("${baseUrl}")
    private String baseUrl;

    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    private User user;
    /**
     * 查找所有用户
     * @return
     */
    @Override
    public List<User> findUser() {

        return userMapper.findUser();
    }
    /**
     * excel插入数据库
     * @param user
     */
    @Override
    public void saveData(List<User> user) {


//          Date data = new Date();
//         user.setCertificateNumber("XB"+new SimpleDateFormat("yyyMMddhhmmss").format(data));
//       for (User users: user) {
//            String s =    new SimpleDateFormat("yyyy-MM-dd").format(users.getTimeOne());
////            String ss =(s+((int)(Math.random()*1000)));
//
//            users.setTimeOne(s);
//        }

        userMapper.insertUser(user);


    }
    /**
     *  word格式
     * @param user
     */
    @Override
    public String getUserInfo(User user) {
        User userInfo = userMapper.getUserInfo(user.getId());
 //       userInfo.setTimeOne(new SimpleDateFormat("yyyy--MM--dd").format(user.getTimeOne()));
//        userInfo.setTimeTwo(new SimpleDateFormat("yyyy   MM   dd").format(user.getTimeTwo()));
        try {
            UserWordDto userWordDto = new UserWordDto();
            BeanUtils.copyProperties(userInfo,userWordDto);
            userWordDto.setTimeOne(new SimpleDateFormat("yyyy.MM.dd").format(userInfo.getTimeOne()));
            userWordDto.setTimeTwo(new SimpleDateFormat("yyyy   MM   dd").format(userInfo.getTimeTwo()));
            Configuration configuration = new Configuration(new Version("2.3.0"));
            configuration.setDefaultEncoding("utf-8");
            configuration.setDirectoryForTemplateLoading(new File(SOURCE_URL));
            String name = userInfo.getName() + "--" + userInfo.getCertificateNumber() + ".doc";
            File outFile = new File(TARGET_URL+"/" + name);
            Template template = configuration.getTemplate("test.ftl", "utf-8");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
            template.process(userWordDto, out);
            out.close();
            return baseUrl+name;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "导出失败";

    }

        /**
         *添加用户信息
         * @param user
         * @return
         */
        @Override
        public String addUser (User user){
            User userInfo = userMapper.getUserInfoByIdCard(user.getIdcard());
            if (userInfo!=null){
                return "身份证号重复";
            }
//            Date data = new Date();
//            String s = "HG"+(new SimpleDateFormat("yyyMMddhh")).format(data);
//            String ss =(s+((int)(Math.random()*1000)));
//            user.setCertificateNumber(ss);

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
        User userInfo = userMapper.getUserInfoByIdCard(user.getIdcard());
//        UserDto userInfoByIdCard = userMapper.getUserInfoByIdCard(user.getIdcard());

        if (userInfo!=null){
            if (!userInfo.getId().equals(user.getId()))
                return "修改失败，身份证信息重复";
        }

        userMapper.updateUser(user);
        return "修改成功";
    }

    /**
     * 根据id查找
     * @param user
     * @return
     */
    @Override
    public List<User> findById(User user) {


        return  userMapper.findById(user.getId());


    }


    /**
     * 根据姓名查找
     * @param user
     * @return
     */
    @Override
    public List<User> findName(User user) {
        return userMapper.findName(user.getName());

    }


}
