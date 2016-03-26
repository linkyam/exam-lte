package com.fb.exam.code.service;

import com.fb.exam.code.vo.SpecialityDetail;
import com.fb.exam.code.vo.SpecialitySearch;
import com.fb.exam.common.vo.Speciality;
import com.fb.exam.common.vo.Speyears;

import java.util.List;

/**
 * Created by Administrator on 16-2-24.
 */
public interface SpecialityService {
    /**
     * 查询 专业信息 列表
     * @param specialitySearch 查询条件
     * @return 列表
     * @throws Exception
     */
    List<SpecialityDetail> getSpecialityDetailBySearch(SpecialitySearch specialitySearch) throws Exception;

    /**
     * 查询所有学制信息列表
     * @return 列表
     * @throws Exception
     */
    List<Speyears> getAllSpeYears() throws Exception;

    /**
     * 根据ID删除专业信息
     * @param specialityId 专业主键ID
     * @return 操作结果
     * @throws Exception
     */
    boolean delSpecialityById(int specialityId) throws Exception;

    /**
     * 根据名称判断专业是否存在
     * @param specialityName
     * @return
     * @throws Exception
     */
    boolean getSpecialityByName(String specialityName) throws Exception;

    /**
     * 保存专业信息
     * @param speciality
     * @return
     * @throws Exception
     */
    boolean saveSpecialityInfo(Speciality speciality) throws Exception;
}
