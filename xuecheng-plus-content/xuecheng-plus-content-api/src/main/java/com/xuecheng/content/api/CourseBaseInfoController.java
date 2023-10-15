package com.xuecheng.content.api;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.model.dto.AddCourseDto;
import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.service.CourseBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程信息相关接口
 *
 * @author xuqizheng
 * @date 2023/10/12
 */


@RestController
@Api(value = "课程信息管理", tags = "课程信息管理接口")
public class CourseBaseInfoController {

    @Autowired
    CourseBaseInfoService courseBaseInfoService;

    @ApiOperation("课程查询接口")
    @PostMapping("/course/list")
    public PageResult<CourseBase> list(PageParams params, @RequestBody(required = false) QueryCourseParamsDto queryCourseParamsDto) {
        return courseBaseInfoService.queryCourseBaseList(params,queryCourseParamsDto);

    }
    @ApiOperation("新增课程接口")
    @PostMapping("/course")
    public CourseBaseInfoDto createCourseBase(@RequestBody AddCourseDto addCourseDto){
        //获取到用户所属机构的id
        Long companyId=1232141425L;
        return courseBaseInfoService.createCourseBase(companyId,addCourseDto);
    }

}
