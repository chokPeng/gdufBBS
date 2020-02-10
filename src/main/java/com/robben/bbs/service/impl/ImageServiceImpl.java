package com.robben.bbs.service.impl;import com.robben.bbs.mapper.ImageMapper;import com.robben.bbs.pojo.Image;import com.robben.bbs.service.ImageService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import org.springframework.web.multipart.MultipartFile;import java.io.File;import java.io.IOException;import java.util.ArrayList;import java.util.List;@Servicepublic class ImageServiceImpl implements ImageService {    private final String basicPathName="/Users/pengchunkao/gdufBBSImage/";    private final ImageMapper imageMapper;    @Autowired    public ImageServiceImpl(ImageMapper imageMapper){        this.imageMapper=imageMapper;    }    /**     * 往磁盘和数据库存入image     * @param filesToSave     * @param postId     * @return     * @throws IOException     */    @Override    public Integer savePostImage(MultipartFile[] filesToSave, Long postId) throws IOException {        ArrayList<Image> imageArrayList = new ArrayList<>();        for (int i = 0,length=filesToSave.length; i <length; i++) {            Image imageToSave=new Image();            String location=                    postId+"_"+i+"."+filesToSave[i].getContentType().substring(6);            imageToSave.setPostId(postId);            imageToSave.setLocation(location);            //图片存储命名：poster_当前i的值+文件类型            File file = new File(basicPathName+location);            filesToSave[i].transferTo(file);            imageArrayList.add(imageToSave);        }        //插入图片信息到数据库        return imageMapper.savePostImages(imageArrayList);    }    @Override    public Integer saveConfessionWallImage(MultipartFile[] filesToSave,                                           Integer posterId) throws IOException {        ArrayList<Image> imageArrayList=new ArrayList<>();        for(int i=0,length=filesToSave.length;i<length;i++){            Image image=new Image();            String location=                    posterId+"_"+i+"."+filesToSave[i].getContentType().substring(6);            image.setConfessionWallId(posterId);//posterId和confessionWallId相同            image.setLocation(location);            //图片存储命名：poster_当前i的值+文件类型            File file = new File(basicPathName+location);            filesToSave[i].transferTo(file);            imageArrayList.add(image);        }        return  imageMapper.saveConfessionWallImages(imageArrayList);    }    @Override    public Integer deleteImageByPostId(Long postId,String basicPathName) {        List<String> imageList=imageMapper.getImageLocationByPostId(postId);        if(imageList.size()!=0){            for(String  imageName: imageList){                File file=new File(basicPathName+imageName);                file.delete();            }        }        return imageMapper.deleteImageByPostId(postId);    }    @Override    public Integer deleteImageByConfessionWallId(Integer confessionWallId) {        List<String> imageList=                imageMapper.getImageLocationByConfessionWallId(confessionWallId);        if(imageList.size()!=0){            for(String  imageName: imageList){                File file=new File(basicPathName+imageName);                file.delete();            }        }        return imageMapper.deleteImageByConfessionWallId(confessionWallId);    }}