package com.oopvr.production.service;

import com.oopvr.production.mapper.InternetUserMapper;
import com.oopvr.production.pojo.InternetUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternetUserService {

    @Autowired
    private InternetUserMapper internetUserMapper;

   public InternetUser AqueryUser(int id){
        return  internetUserMapper.selectByPrimaryKey(id);
    }

    public  InternetUser queryUser(int id){
        return internetUserMapper.queryUser(id);
    }
}