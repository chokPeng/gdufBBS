package com.robben.bbs.controller;import com.robben.bbs.service.RelationshipService;import com.robben.bbs.utilities.ResultInfo;import org.springframework.web.bind.annotation.*;@RestController@RequestMapping("/relationship")public class RelationshipController {    private final RelationshipService relationshipService;    public RelationshipController(RelationshipService relationshipService) {        this.relationshipService = relationshipService;    }    @GetMapping("/followers/{userId}")    public ResultInfo getFollowerByUserId(@PathVariable("userId") Long userId) {        return ResultInfo.success(relationshipService.getFollower(userId));    }    @GetMapping("/followees/{userId}")    public ResultInfo getFolloweeByUserId(@PathVariable("userId") Long userId) {        return ResultInfo.success(relationshipService.getFollowee(userId));    }    /**     * @param followeeId 被关注者Id     * @param followerId 关注者Id     * @return     */    @PostMapping("/follow")    public ResultInfo saveFollower(Long followeeId, Long followerId) {        return ResultInfo.success(relationshipService.saveFollower(followeeId, followerId));    }    @PostMapping("/unfollow")    public ResultInfo deleteFollower(Long followeeId, Long followerId) {        return ResultInfo.success(relationshipService.deleteFollower(followeeId, followerId));    }}