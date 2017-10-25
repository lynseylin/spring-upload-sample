package com.fox.web.service;

import com.fox.web.mapper.HomeworkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by linxiaofang on 2017/10/12.
 */
@Service
public class HomeworkService {
    @Autowired
    HomeworkMapper homeworkMapper;


}
