package com.robben.bbs.service.impl;import com.robben.bbs.mapper.ImageMapper;import com.robben.bbs.pojo.Image;import com.robben.bbs.service.ImageService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import org.springframework.web.multipart.MultipartFile;import java.io.File;import java.io.IOException;import java.util.ArrayList;import java.util.List;@Servicepublic class ImageServiceImpl implements ImageService {    private final String basicPathName="/Users/pengchunkao/gdufBBSImage/";    private final ImageMapper imageMapper;    @Autowired    public ImageServiceImpl(ImageMapper imageMapper){        this.imageMapper=imageMapper;    }    @Override    public Integer saveConfessionWallImage(MultipartFile[] filesToSave, Long confessionWallId) throws IOException {        ArrayList<Image> imageArrayList=new ArrayList<>();        for(int i=0,length=filesToSave.length;i<length;i++){            Image image=new Image();            String location=                    confessionWallId+"_"+i+"."+filesToSave[i].getContentType().substring(6);            image.setConfessionWallId(confessionWallId);//posterId和confessionWallId相同            image.setLocation(location);            //图片存储命名：poster_当前i的值+文件类型            File file = new File(basicPathName+location);            image.setLocation(location);            filesToSave[i].transferTo(file);            imageArrayList.add(image);        }        return  imageMapper.saveConfessionWallImages(imageArrayList);    }    @Override    public Integer deleteImageByConfessionWallId(Long confessionWallId) {        List<String> imageList=                imageMapper.getImageLocationByConfessionWallId(confessionWallId);        if(imageList.size()!=0){            for(String  imageName: imageList){                File file=new File(basicPathName+imageName);                file.delete();            }        }        return imageMapper.deleteImageByConfessionWallId(confessionWallId);    }}