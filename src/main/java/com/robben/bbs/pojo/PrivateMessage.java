package com.robben.bbs.pojo;import lombok.Data;import org.springframework.stereotype.Component;import java.sql.Timestamp;@Data@Componentpublic class PrivateMessage {    private Long senderId;    private String content;    private Timestamp sendingTime;    private Long receiverId;}