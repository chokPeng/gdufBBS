package com.robben.bbs.pojo;import lombok.Data;import org.springframework.stereotype.Component;import java.sql.Timestamp;import java.util.HashMap;import java.util.List;@Component@Datapublic class ConfessionWallComment {    private Integer Id;    private Long confessionWallId;    private HashMap commenter;    private String content;    private Timestamp commentingTime;    private List<CommentReply> commentReply;}