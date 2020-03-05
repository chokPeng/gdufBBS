package com.robben.bbs.controller;import com.robben.bbs.pojo.Square;import com.robben.bbs.service.SquareService;import com.robben.bbs.utilities.ResultInfo;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.*;import org.springframework.web.multipart.MultipartFile;import java.io.IOException;import java.util.List;@RestController@RequestMapping("/square")public class SquareController {    private final SquareService squareService;    @Autowired    public SquareController(SquareService squareService){        this.squareService = squareService;    }    /**     *  查看表白墙     * @return 所有表白墙的内容     */    @GetMapping    public ResultInfo getSquare(String topic){        List<Square> result=                squareService.getSquare(topic);        return ResultInfo.success(result);    }    /**     * 表白墙发帖子     * 接受多文件和userId，content参数，并将文件存入磁盘     * @param multipartFile 存放多个文件的数组     * @param posterId     * @param content     * @return 成功则true     * @throws IOException     */    @PostMapping    public ResultInfo saveSquare(@RequestParam("file") MultipartFile[] multipartFile,                                         Long posterId, String content,String topic) throws IOException {        System.out.println(posterId);        int res= squareService.saveSquare(posterId,content,                multipartFile,topic);        if(res==0){            return ResultInfo.fail("保存失败");        }        return ResultInfo.success();    }    /**     * 删除表白墙     * @param id 表白墙id     * @return     */    @DeleteMapping    public ResultInfo deleteSquareById(Long id){        int result= squareService.deleteSquareById(id);        if(result==0){            return ResultInfo.fail("删除失败");        }        return ResultInfo.success();    }    /**     * 修改表白墙内容     * @param square     * @return     */    @PatchMapping    public ResultInfo updateSquare(@RequestBody Square square){        int res= squareService.updateSquare(square);        if(res==0){            return ResultInfo.fail("修改失败");        }        return ResultInfo.success();    }    @PostMapping("/like")    public ResultInfo addLike(Long id, Long userId){        Integer res= squareService.saveSquareLike(id,userId);        return res==1?ResultInfo.success():ResultInfo.fail("保存失败");    }    @GetMapping("/like")    public ResultInfo getLike(Long userId){        return ResultInfo.success(squareService.getUserSquareLike(userId));    }    @DeleteMapping("/like")    public ResultInfo deleteLike(Long userId,Long squareId){        Integer res= squareService.deleteSquareLike(userId, squareId);        if(res==0){            return ResultInfo.fail("删除失败");        }        return ResultInfo.success();    }}