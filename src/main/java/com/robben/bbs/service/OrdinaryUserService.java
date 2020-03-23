package com.robben.bbs.service;import com.robben.bbs.pojo.OrdinaryUser;import org.springframework.web.multipart.MultipartFile;import java.io.IOException;import java.util.HashMap;public interface OrdinaryUserService {   OrdinaryUser queryByUsername(String username);   Integer saveUser(OrdinaryUser user);   OrdinaryUser getUserInfoById(Long userId);   OrdinaryUser getUserNumberAndAvatarByUserId(String userId);   Integer updateUser(MultipartFile avatarFile,OrdinaryUser ordinaryUser) throws IOException;   //Integer getUserNumber(String userId);  //因为springsecurity里的username就是userId}