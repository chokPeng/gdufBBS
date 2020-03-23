package com.robben.bbs.mapper;import com.robben.bbs.pojo.OrdinaryUser;import org.apache.ibatis.annotations.Param;import org.springframework.security.core.GrantedAuthority;import org.springframework.stereotype.Repository;import java.util.HashMap;import java.util.List;@Repositorypublic interface OrdinaryUserMapper {    OrdinaryUser queryByUsername(@Param("username") String username);    Integer saveUser(OrdinaryUser user);    GrantedAuthority getAuthoritiesByUserId(Long userId);    OrdinaryUser getUserById(Long userId);    OrdinaryUser getUserNumberAndAvatarByUserId(String userId);    Integer updateUser(OrdinaryUser ordinaryUser);    String getUserAvatar(Long userId);    List queryUser(String username);    Integer getUserNumber(Long userId);}