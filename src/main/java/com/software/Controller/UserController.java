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
    注册

     */

    @RequestMapping(value = "/UserRegister") //0 用户名存在 //1 成功
    public Integer Xyregister(@RequestParam(value = "name",required = false) String name,
                              @RequestParam(value = "code",required = false) String code,
                              @RequestParam(value = "mail",required = false) String mail,
                              @RequestParam(value = "phone",required = false) String phone,
                              @RequestParam(value = "age",required = false) String age,
                              @RequestParam(value = "sex",required = false) String sex)
    {
        User user = new User();
        user.setName(name);
        user.setPassword(code);
        user.setEmail(mail);
        user.setUserphone(phone);
        user.setAge(Integer.parseInt(age));
        user.setSex(sex);
        System.out.println(user.getUsername());
        User user1 = userService.findUserByName(user.getUsername());
        if(user1 == null)
        {
            userService.userRegister(user);
            return 1;
        }
        else
        return 0;
    }

    /*
    登录,返回值为0是用户名不存在，-1为密码错误
     */
    @RequestMapping(value = "/UserLogin")
    public int[] userLogin( @RequestParam(value = "username",required = false) String username,
                          @RequestParam(value = "password",required = false) String password){

        System.out.println(username + " " + password);
        return userService.userLogin(username,password);
    }
    /*
    根据id获取user
     */
    @RequestMapping(value = "/UserById")
    //Todo  用户信息(名字，性别，年龄，邮箱，电话)
    public User findUserByid(@RequestParam("token")int id){
//        System.out.println("收到信息请求");
        User user= userService.findUserById(id);
        return user;
    }

    /*
    根据用户名获取用户id
     */
    @RequestMapping(value = "/getUseridByname")
    public int getUserIdByname(@RequestParam(value = "username",required = false) String username){

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
    public User updateUser2(@RequestBody User user){
        return userService.userUpdate(user);
    }


    @RequestMapping(value = "/CompanyById")
    //Todo  用户信息(名字，性别，年龄，邮箱，电话)
    public User findCompanyByid(@RequestParam("id")int id){
        System.out.println("收到信息请求");
        User user= userService.findUserById(id);
        return user;
    }
}

