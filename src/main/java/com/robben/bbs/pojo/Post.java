package com.robben.bbs.pojo;import lombok.Data;import org.springframework.stereotype.Component;import java.sql.Timestamp;import java.util.Date;import java.util.List;@Component@Datapublic class Post{    private Integer postId;    private Timestamp postingTime;    private Integer posterId;//发布者ID    private String tittle;    private String content;    private Integer readTimes;//阅读次数    private String topic;  //主题}