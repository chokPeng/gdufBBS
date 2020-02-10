package com.robben.bbs.service.impl;import com.robben.bbs.mapper.LostAndFoundMapper;import com.robben.bbs.pojo.LostAndFound;import com.robben.bbs.service.LostAndFoundService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.security.core.parameters.P;import org.springframework.stereotype.Service;import java.util.List;@Servicepublic class LostAndFoundServiceImpl implements LostAndFoundService {    LostAndFoundMapper lostAndFoundMapper;    @Autowired    public LostAndFoundServiceImpl(LostAndFoundMapper lostAndFoundMapper){        this.lostAndFoundMapper=lostAndFoundMapper;    }    @Override    public List getAllLostAndFound() {        return lostAndFoundMapper.getAllLostAndFound();    }    @Override    public Boolean saveLostProperty(LostAndFound lostAndFound) {        return lostAndFoundMapper.saveLostProperty(lostAndFound);    }    @Override    public Boolean saveFoundProperty(LostAndFound lostAndFound) {        return lostAndFoundMapper.saveFoundProperty(lostAndFound);    }    @Override    public Boolean updateLostAndFoundById(LostAndFound lostAndFound) {        return lostAndFoundMapper.updateLostAndFoundById(lostAndFound);    }    @Override    public Boolean deleteLostAndFoundById(Integer id) {        return lostAndFoundMapper.deleteLostAndFoundById(id);    }}