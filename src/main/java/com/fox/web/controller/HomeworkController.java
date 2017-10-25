package com.fox.web.controller;

import com.fox.web.annotation.MaxFileSize;
import com.fox.web.domain.Homework;
import com.fox.web.domain.Result;
import com.fox.web.domain.ResultEnum;
import com.fox.web.mapper.HomeworkMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.List;

/**
 * Created by linxiaofang on 2017/10/12.
 */

@Controller
@Validated
public class HomeworkController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeworkController.class);

    @Autowired
    ServletContext context;
    @Autowired
    HomeworkMapper homeworkMapper;

    @RequestMapping(value = "/homework", method = RequestMethod.GET)
    public String uploadHomework() {
        return "/homework/upload.html";
    }

    @RequestMapping(value = "/uploadhomework", method = RequestMethod.POST)
    @ResponseBody
    public Result uploadFile(@RequestParam("file") @MaxFileSize MultipartFile file,
                             @RequestParam("userId") @NotNull Integer userId,
                             @RequestParam("classId") @NotNull Integer classId,
                             @RequestParam("lessonId") @NotNull Integer lessonId) {
        try {
            List<Homework> homeworkList = homeworkMapper.selectByUserIdAndClassIdAndLessonId(userId, classId, lessonId);
            if (homeworkList.size() > 0) {
                homeworkList.forEach(homework -> homeworkMapper.deleteByPrimaryKey(homework.getId()));
            }
            String filePath = saveFile(file);
            Homework homework = new Homework();
            homework.setUserId(userId);
            homework.setClassId(classId);
            homework.setLessonId(lessonId);
            homework.setHomeworkFilePath(filePath);
            homework.setHomeworkFileName(file.getOriginalFilename());
            homeworkMapper.insert(homework);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new Result(ResultEnum.ERROR);
        }

        return new Result(ResultEnum.SUCCESS);
    }

    private String saveFile(MultipartFile file) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String root = context.getRealPath("/");
                File path = new File(root + "/upload");
                if (!path.exists()) {
                    boolean status = path.mkdirs();
                }
                String filePath = path + "/" + file.getOriginalFilename();

                // 转存文件
                file.transferTo(new File(filePath));
                return filePath;
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
        return "";
    }

}
