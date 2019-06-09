package com.software.Service;


import com.software.Dao.CompanyRepository;
import com.software.Dao.UserRepository;
import com.software.Domain.Company;
import com.software.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private CompanyRepository companyRepository;

    //注册
    public User userRegister(User user) {
        User user1=userRepository.save(user);
        userRepository.flush();
        System.out.println(user1.getUserid());
        return user1;
    }

    //更改用户信息
    public User userUpdate(User user) {
        return userRepository.save(user);
    }

    //根据id获取用户user
    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    //根据name获取user
    public User findUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    //根据id获取user
    public User findUserById(int id){return userRepository.findByUserid(id);}

    //登录
    public int[] userLogin(String name, String password) {
        int flag = 0;
        int[] a = new int[2];
        a[0] = 0;
        a[1] = 0;
        User user;
        Company company;
        System.out.println(name+"  "+ password);
        user = findUserByName(name);
        if (user == null)
        {
            company = companyRepository.findByCompanyusername(name);
            if(company == null) a[1] = 0; //用户名在两个表中都不存在不存在
            else
            {
                a[0] = 2;
                company = companyRepository.findByCompanyusernameAndCompanypassword(name, password);
                if(company == null)
                    a[1] = -1;
                else
                    a[1] = company.getCompanyid();
            }
        }
        else
        {
            a[0] = 1;
            user = userRepository.findByUsernameAndPassword(name, password);
            if (user == null) a[1] = -1;//密码错误
            else a[1]=user.getUserid();
        }
        return a;
    }
}
