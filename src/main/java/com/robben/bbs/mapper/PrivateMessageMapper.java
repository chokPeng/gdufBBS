package com.robben.bbs.mapper;import org.springframework.stereotype.Repository;import java.util.List;@Repositorypublic interface PrivateMessageMapper {    Boolean savePrivateMessage(Integer senderId,String content,                               Integer receiverId);    List getAllPrivateMessage(Integer receiverId);}