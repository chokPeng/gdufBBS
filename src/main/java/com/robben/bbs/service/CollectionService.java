package com.robben.bbs.service;import com.robben.bbs.pojo.Collection;import java.util.List;public interface CollectionService {    Integer saveCollection(Collection collection);    Integer deleteCollection(Long collectorId, Long postId);    List getCollection(Long collectorId);    List getCollectedPostIdList(Long collectorId);}