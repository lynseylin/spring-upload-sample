# spring-upload-sample
## 框架
Spring Boot + MySQL + JQuery + Bootstrap Fileinput

## 实现功能
学员上传自己的作业：
com.fox.web.HomeworkController为控制器（url路径为/homework)
homework/upload.html为主页面
参数为 userId（学员ID，Integer）、classId（班级ID，Integer），lessonId（课程编号,Integer），
上传的文件只能是ＰＰＴ，ＰＤＦ类型，大小在５Ｍ以内，如果不符合则删除服务器上的保存的文件，并对话框提示具体的错误，
如果userId＋classId　＋lessonId对应的作业在数据库中已经存在，则删除原来的文件（不存在也不报错），上传新文件，并且更新原有的数据库记录。
成功后弹出对话框，提示完成。
