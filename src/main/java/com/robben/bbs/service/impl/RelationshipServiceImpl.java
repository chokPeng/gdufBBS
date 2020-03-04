package com.robben.bbs.service.impl;import com.robben.bbs.mapper.RelationshipMapper;import com.robben.bbs.service.RelationshipService;import org.springframework.stereotype.Service;import java.util.HashMap;import java.util.List;@Servicepublic class RelationshipServiceImpl implements RelationshipService {    private final RelationshipMapper relationshipMapper;    public RelationshipServiceImpl(RelationshipMapper relationshipMapper){        this.relationshipMapper=relationshipMapper;    }    @Override    public List<HashMap> getFollower(Long followeeId) {        return relationshipMapper.getFollower(followeeId);    }    @Override    public List<HashMap> getFollowee(Long followerId) {        return relationshipMapper.getFollowee(followerId);    }    @Override    public List<HashMap> saveFollower(Long followeeId, Long followerId) {         relationshipMapper.saveFollower(followeeId,followerId);         return relationshipMapper.getFollowee(followerId);    }    @Override    public List<HashMap> deleteFollower(Long followeeId, Long followerId) {        relationshipMapper.deleteFollower(followeeId,followerId);        return relationshipMapper.getFollowee(followerId);    }}