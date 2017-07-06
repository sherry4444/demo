package com.example.demo.config;

import com.example.demo.entity.SUser;
import com.example.demo.entity.SecurityUser;
import com.example.demo.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Administrator on 2017/7/6.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired  //数据库服务类
    private SUserService suserService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //SUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用SUser中的email作为用户名:
        SUser user = suserService.findUserByEmail(userName);
        System.out.println("========== user: "+user);

        if (user == null){
            throw new UsernameNotFoundException("userName:"+userName+"not found");
        }

        // SecurityUser实现UserDetails并将SUser的Email映射为username
        SecurityUser securityUser = new SecurityUser(user);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return securityUser;
    }
}