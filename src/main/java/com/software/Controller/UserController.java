package com.software.Controller;

import com.software.Domain.User;
import com.software.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserService userService;

    /*
    注册时判断是否有相同用户名
     */
    @GetMapping(value = "/SameUsername/{name}")
    public Boolean userList(@PathVariable("name")String name){
        User user= userService.findUserByName(name);
        if(user==null)return false;
        return true;
    }

    /*
    注册
     */

    @RequestMapping(value = "/UserRegister")
    public User Xyregister(@RequestBody User user) {
        System.out.println(user.getUsername());
        user.setUserid(0);
        return userService.userRegister(user);
    }

    /*
    登录,返回值为0是用户名不存在，-1为密码错误
     */
    @RequestMapping(value = "/UserLogin")
    public int userLogin( @RequestParam(value = "name",required = false) String username,
                          @RequestParam(value = "password",required = false) String password){
        return userService.userLogin(username,password);
    }

    /*
    根据用户名获取用户id
     */
    @RequestMapping(value = "/getUseridByname/{name}")
    public int getUserIdByname(@PathVariable("name") String username){

        User user=userService.findUserByName(username);
        System.out.println(user);
        return user.getUserid();
    }

    /*
    修改用户信息
     */
    @RequestMapping(value = "/updateUserInfo")
    public User updateUser(@PathVariable("id") Integer id,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           @RequestParam("userphone") String userphone
    ){
        User user=new User();
        user.setUserid(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setUserphone(userphone);
        return userService.userUpdate(user);
    }

    /*
    修改用户信息
     */
    @RequestMapping(value = "/updateUserInfoo")
    @ResponseBody
    public User updateUser2(@RequestBody User user){
        return userService.userUpdate(user);
    }

    /*
    根据id获取user
     */
    @GetMapping(value = "/UserById/{id}")
    @ResponseBody
    public User findUserByid(@PathVariable("id")int id){
        User user= userService.findUserById(id);
        return user;
    }
}
