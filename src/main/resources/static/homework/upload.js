$(function () {
    $('#file').fileinput({
        language: 'zh',
        uploadUrl: 'uploadhomework',
        allowedFileTypes: ['pdf', 'ppt'],
        allowedFileExtensions : [ "pdf", "ppt" ],
        maxFileSize: 5120,
        showPreview: true,
        previewFileType:'any',
        uploadAsync: true,
        elErrorContainer: "#fileError",
        browseClass: "btn btn-success btn-file btn-sm",
        browseLabel: "选择",
        browseIcon: '<i class="glyphicon glyphicon-search"></i>',
        removeClass: "btn btn-danger btn-file btn-sm",
        removeLabel: "移除",
        removeIcon: '<i class="glyphicon glyphicon-trash"></i>',
        uploadClass: "btn btn-info btn-file btn-sm",
        uploadLabel: "上传",
        uploadIcon: '<i class="glyphicon glyphicon-upload"></i>',
        uploadExtraData: function(previewId, index) {
            var extraData = {};
            extraData.userId = $("#user-id").val();
            extraData.classId = $("#class-id").val();
            extraData.lessonId = $("#lesson-id").val();
            return extraData;
        }
    })
        .on("filepreajax", function() {
            if ($("#user-id").val().length == 0) {
                alert("请输入正确的用户id");
                return false;
            }
            if ($("#class-id").val().length == 0) {
                alert("请输入正确的班级id");
                return false;
            }
            if ($("#lesson-id").val().length == 0) {
                alert("请输入正确的课程id");
                return false;
            }
        })
        .on("fileuploaded", function (e, data) {
            var res = data.response;
            if (res.code == 200) {
                alert("上传成功");
            } else {
                alert("上传失败");
            }
        });
})