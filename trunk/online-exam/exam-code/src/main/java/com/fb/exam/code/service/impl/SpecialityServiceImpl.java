package com.fb.exam.code.service.impl;

import com.fb.exam.code.dao.SpecialityDetailMapper;
import com.fb.exam.code.service.SpecialityService;
import com.fb.exam.code.vo.SpecialityDetail;
import com.fb.exam.code.vo.SpecialitySearch;
import com.fb.exam.common.dao.SpecialityMapper;
import com.fb.exam.common.dao.SpeyearsMapper;
import com.fb.exam.common.vo.Speciality;
import com.fb.exam.common.vo.SpecialityExample;
import com.fb.exam.common.vo.Speyears;
import com.fb.exam.common.vo.SpeyearsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 16-2-24.
 */
@Service
public class SpecialityServiceImpl implements SpecialityService {
    @Autowired
    private SpecialityMapper specialityMapper;

    @Autowired
    private SpeyearsMapper speyearsMapper;

    @Autowired
    private SpecialityDetailMapper specialityDetailMapper;

    /**
     * 查询 专业信息 列表
     *
     * @param specialitySearch 查询条件
     * @return 列表
     * @throws Exception
     */
    @Override
    public List<SpecialityDetail> getSpecialityDetailBySearch(SpecialitySearch specialitySearch) throws Exception {
        int count = specialityDetailMapper.countSpecialityBySearch(specialitySearch);
        specialitySearch.setTotalRecords(count);
        return specialityDetailMapper.getSpecialityDetailBySearch(specialitySearch);
    }

    /**
     * 查询所有学制信息列表
     *
     * @return 列表
     * @throws Exception
     */
    @Override
    public List<Speyears> getAllSpeYears() throws Exception {
        return speyearsMapper.selectByExample(new SpeyearsExample());
    }

    /**
     * 根据ID删除专业信息
     *
     * @param specialityId 专业主键ID
     * @return 操作结果
     * @throws Exception
     */
    @Override
    public boolean delSpecialityById(int specialityId) throws Exception {
        return specialityMapper.deleteByPrimaryKey(specialityId)>0;
    }

    /**
     * 根据名称判断专业是否存在
     *
     * @param specialityName
     * @return
     * @throws Exception
     */
    @Override
    public boolean getSpecialityByName(String specialityName) throws Exception {
        SpecialityExample example=new SpecialityExample();
        example.createCriteria().andSpecialityNameEqualTo(specialityName.trim());
        return specialityMapper.countByExample(example)>0;
    }

    /**
     * 保存专业信息
     *
     * @param speciality
     * @return
     * @throws Exception
     */
    @Override
    public boolean saveSpecialityInfo(Speciality speciality) throws Exception {
        return specialityMapper.insertSelective(speciality)>0;
    }
}
