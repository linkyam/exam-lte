package com.fb.exam.code.controller;

import com.fb.exam.code.service.SpecialityService;
import com.fb.exam.code.vo.SpecialityDetail;
import com.fb.exam.code.vo.SpecialitySearch;
import com.fb.exam.common.code.ResCode;
import com.fb.exam.common.result.DetailResult;
import com.fb.exam.common.result.PageResult;
import com.fb.exam.common.result.Result;
import com.fb.exam.common.result.TableResult;
import com.fb.exam.common.vo.Speciality;
import com.fb.exam.common.vo.Speyears;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 16-2-20.
 * 专业信息页面处理类
 */
@Controller
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    /**
     * 查询 专业信息 列表
     *
     * @param iDisplayStart  开始
     * @param iDisplayLength 长度
     * @param collegeId      学院ID
     * @param speyearsId     学制ID
     * @param specialityName 专业名称
     * @return 列表
     * @throws Exception
     */
    @RequestMapping(value = "/speciality/getBySearch", method = {RequestMethod.GET})
    @ResponseBody
    public Result getSpecialityDetailBySearch(@RequestParam(required = false) Integer iDisplayStart,
                                              @RequestParam(required = false) Integer iDisplayLength,
                                              @RequestParam(required = false) Integer collegeId,
                                              @RequestParam(required = false) Integer speyearsId,
                                              @RequestParam(required = false) String specialityName) throws Exception {
        SpecialitySearch specialitySearch = new SpecialitySearch();
        specialitySearch.setBegin(iDisplayStart);
        specialitySearch.setLength(iDisplayLength);
        specialitySearch.setCollegeId(collegeId);
        specialitySearch.setSpeyearsId(speyearsId);
        if(StringUtils.isNotEmpty(specialityName)){
            specialitySearch.setSpecialityName("%" + specialityName + "%");
        }
        List<SpecialityDetail> list = specialityService.getSpecialityDetailBySearch(specialitySearch);
        TableResult<SpecialityDetail> result = new TableResult<>(ResCode.SUCCESS, null);
        result.setData(list);
        result.setRecordsTotal(specialitySearch.getTotalRecords());
        result.setRecordsFiltered(specialitySearch.getTotalRecords());
        return result;
    }

    /**
     * 查询所有学制信息列表
     *
     * @return 列表
     * @throws Exception
     */
    @RequestMapping(value = "/speYears/getAllSpeYears", method = {RequestMethod.GET})
    @ResponseBody
    public Result getAllSpeYears() throws Exception {
        PageResult<Speyears> result = new PageResult<>(ResCode.SUCCESS, null);
        List<Speyears> list = specialityService.getAllSpeYears();
        result.setData(list);
        return result;
    }

    /**
     * 根据主键ID删除
     * @param specialityId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/speciality/delById", method = {RequestMethod.GET})
    @ResponseBody
    public Result delSpecialityById(int specialityId) throws Exception{
        Result result=new Result(ResCode.SUCCESS,null);
        boolean success=specialityService.delSpecialityById(specialityId);
        return result;
    }

    /**
     * 保存专业信息
     * @param speciality
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/speciality/addSpecialityInfo", method = {RequestMethod.POST})
    @ResponseBody
    public Result addSpecialityInfo(@RequestBody Speciality speciality) throws Exception{
        DetailResult<Integer> result=new DetailResult<>(ResCode.SUCCESS,null);
        boolean isExist = specialityService.getSpecialityByName(speciality.getSpecialityName());
        if(!isExist){
            boolean success=specialityService.saveSpecialityInfo(speciality);
            result.setData(speciality.getSpecialityId());
        }else{
            result.setMessage("专业名称已经存在。");
            result.setCode(ResCode.FAILE);
        }
        return result;
    }
}
