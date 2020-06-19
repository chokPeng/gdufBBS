package com.robben.bbs.service;import com.robben.bbs.pojo.Square;import org.springframework.web.multipart.MultipartFile;import java.io.IOException;import java.util.List;public interface SquareService {    List<Square> getSquare(String topic);    Square getSquareById(Long id);    Integer saveSquare(Long posterId,                       String content, MultipartFile[] multipartFile, String topic) throws IOException;    Integer deleteSquareById(Long id);    Integer updateSquare(Square square);    Integer saveSquareLike(Long id, Long userId);    List getUserSquareLike(Long userId);    Integer deleteSquareLike(Long userId, Long squareId);}