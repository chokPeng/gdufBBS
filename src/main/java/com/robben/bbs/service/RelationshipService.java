package com.robben.bbs.service;import java.util.HashMap;import java.util.List;public interface RelationshipService {    List<HashMap> getFollower(Long followeeId);    List<HashMap> getFollowee(Long followerId);    List<HashMap> saveFollower(Long followeeId,Long followerId);    List<HashMap> deleteFollower(Long followeeId,Long followerId);}