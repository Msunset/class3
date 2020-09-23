package com.example.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.demo.domain.User;
import com.example.demo.domain.vo.UserVo;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "毕业生打印系统")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 查询所有用户列表
     * @return
     */
    @PostMapping("/finduser")
    @ApiOperation("查找全部用户信息")
    public Object findUser(){

        return userService.findUser();
    }
    /**
     * excel文件录入数据库
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/excel")
    @ApiOperation("excel文件导入")
    public String test(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), User.class, new AnalysisEventListener<User>() {
            private static final int BATCH_COUNT = 3000;
            List<User> list = new ArrayList<User>();


            @Override
            public void invoke(User user, AnalysisContext analysisContext) {
                list.add(user);
                if (list.size() >= BATCH_COUNT) {
                    list.clear();
                }
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                saveData();
            }

            private void saveData() {


                userService.saveData(list);
            }
        }).sheet().doRead();



        return "导入成功";
    }

    /**
     * 根据id生成
     * @param user
     * @return
     * @throws IOException
     */
    @PostMapping("/word")
    @ApiOperation("模板打印")
    public String word(@RequestBody UserVo user ) throws IOException {
        return userService.getUserInfo(user);

    }



    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/adduser")
    @ApiOperation("添加用户")
    public String addUser(@RequestBody User user){

        return userService.addUser(user);



    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @PostMapping("/deleteuser")
    @ApiOperation("删除用户")
    public String deleta(@RequestBody User user){

        return  userService.deleteUser(user);


    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PostMapping("/updateuser")
    @ApiOperation("修改用户")
    public String updateUser(@RequestBody User user){

       return userService.updateUser(user);
    }

    @PostMapping("/findbyid")
    @ApiOperation("根据id查找")
    public List<User> findById(@RequestBody User user){


       return userService.findById(user);

    }


}
