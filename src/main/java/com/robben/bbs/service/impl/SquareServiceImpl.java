package com.robben.bbs.service.impl;import com.robben.bbs.mapper.SquareMapper;import com.robben.bbs.pojo.Square;import com.robben.bbs.service.ActiveService;import com.robben.bbs.service.SquareCommentService;import com.robben.bbs.service.SquareService;import com.robben.bbs.service.ImageService;import com.robben.bbs.utilities.UniqueId;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import org.springframework.web.multipart.MultipartFile;import java.io.IOException;import java.util.List;@Servicepublic class SquareServiceImpl implements SquareService {    private final ImageService imageService;    private final SquareMapper squareMapper;    private final SquareCommentService squareCommentService;    private final ActiveService activeService;    @Autowired    public SquareServiceImpl(SquareMapper squareMapper, ImageService imageService,                             SquareCommentService squareCommentService, ActiveService activeService){        this.activeService=activeService;        this.squareMapper = squareMapper;        this.squareCommentService=squareCommentService;        this.imageService=imageService;    }    @Override    public List<Square> getSquare(String topic) {       return squareMapper.getSquare(topic);    }    @Override    public Square getSquareById(Long id) {        return squareMapper.getSquareById(id);    }    @Override    public Integer saveSquare(Long posterId,String content,                                      MultipartFile[] pictures,String topic)            throws IOException {        Long squareId= UniqueId.getUniquePostId();        if((pictures!=null)&&(pictures.length!=0)){            imageService.saveSquareImage(pictures,squareId);        }        activeService.saveActive(posterId,squareId,"在广场发表了");        return squareMapper.saveSquare(posterId,content,                squareId,topic);    }    /**     * 删除表白墙和表白墙图片     * @param id     * @return     */    @Override    public Integer deleteSquareById(Long id){        //删除图片        imageService.deleteImageBySquareId(id);        //删除评论        squareCommentService.deleteSquareCommentBySquareId(id);        //删除对应的所有动态        activeService.deleteAllRelativeActive(id);        return squareMapper.deleteSquareById(id);    }    @Override    public Integer updateSquare(Square square){        return squareMapper.updateSquare(square);    }    @Override    public Integer saveSquareLike(Long id, Long userId) {        activeService.saveActive(userId,id,"点赞了");        squareMapper.saveSquareLike(userId,id);        return squareMapper.addSquareLike(id);//将square的like+1    }    @Override    public List getUserSquareLike(Long userId) {        return squareMapper.getUserSquareLike(userId);    }    @Override    public Integer deleteSquareLike(Long userId, Long squareId) {         squareMapper.deleteSquareLike(userId, squareId);         activeService.deleteActive(userId, squareId,"点赞了");         return squareMapper.decreaseSquareLike(squareId);    }}