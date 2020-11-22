package com.oopvr.production.service;

import com.oopvr.production.mapper.InternetUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternetUserService {

    @Autowired
    private InternetUserMapper internetUserMapper;
}
