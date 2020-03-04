package com.robben.bbs.config;import com.robben.bbs.pojo.OrdinaryUser;import com.robben.bbs.service.OrdinaryUserService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.security.core.userdetails.User;import org.springframework.security.core.userdetails.UserDetails;import org.springframework.security.core.userdetails.UserDetailsService;import org.springframework.security.core.userdetails.UsernameNotFoundException;import org.springframework.stereotype.Component;@Componentpublic class MyCustomUserDetailsService implements UserDetailsService{    private OrdinaryUserService ordinaryUserService;    @Autowired    MyCustomUserDetailsService(OrdinaryUserService ordinaryUserService){        this.ordinaryUserService=ordinaryUserService;    }    /**         * 验证用户并查询用户权限         * @param username         * @return         * @throws UsernameNotFoundException     */    @Override    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {        System.out.println(username);        //query user by username        OrdinaryUser user =                ordinaryUserService.queryByUsername(username);        return new User(username,user.getPassword(),                user.getAuthorities());    }}