package com.robben.bbs.service.impl;import com.robben.bbs.mapper.ConfessionWallCommentMapper;import com.robben.bbs.pojo.ConfessionWallComment;import com.robben.bbs.service.ConfessionWallCommentService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.beans.factory.annotation.Value;import org.springframework.stereotype.Service;import org.springframework.web.multipart.MultipartFile;import java.io.File;import java.io.IOException;import java.util.List;import java.util.stream.Stream;@Servicepublic class ConfessionWallCommentServiceImpl implements ConfessionWallCommentService {    @Autowired    ConfessionWallCommentMapper confessionWallCommentMapper;    final String basicPathName="/Users/pengchunkao/gdufBBSImage/";    @Override    public Integer saveConfessionWallComment(MultipartFile picture,                                      Integer confessionWallId,                                      Integer commenterId,                                      String content) throws IOException {        if(picture!=null){            //图片命名格式：commenterId+时间戳+文件后缀名            String pictureName=                    commenterId+System.currentTimeMillis()+"."+picture.getContentType().substring(6);            File file=new File(basicPathName+pictureName);            picture.transferTo(file);            return confessionWallCommentMapper.saveComment(pictureName,                    confessionWallId,commenterId, content);        }        return confessionWallCommentMapper.saveComment(null,                confessionWallId,commenterId, content);    }    /**     * 删除图片后再删除记录     * @param id     * @return     */    @Override    public Integer deleteConfessionWallCommentById(Integer id,                                                   String pictureName) {        if(pictureName!=null){            File file=new File(basicPathName+pictureName);            file.delete();        }        return confessionWallCommentMapper.deleteConfessionWallCommentById(id);    }    /**     * 根据confessionWallId删除评论和评论的图片     * @param confessionWallId     * @return     */    @Override    public Integer deleteConfessionWallCommentByWallId(Integer confessionWallId) {        List<ConfessionWallComment> confessionWallCommentList=                confessionWallCommentMapper.getConfessionWallCommentsByWallId(confessionWallId);        StringBuffer stringBuffer = new StringBuffer();        stringBuffer.d        //删除图片评论在磁盘里的图片        for(ConfessionWallComment confessionWallComment:confessionWallCommentList){            String pictureName=confessionWallComment.getPicture();            if(pictureName!=null){                File fileToDelete=new File(basicPathName+pictureName);                fileToDelete.delete();            }        }       return confessionWallCommentMapper.deleteConfessionWallCommentByWallId(confessionWallId);    }}