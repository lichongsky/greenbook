package com.lichong.greenbook.service;

import com.emdata.common.models.DataGrid;
import com.emdata.common.models.PageParams;
import com.emdata.common.mvc.service.IBaseService;
import com.lichong.greenbook.entity.Demo;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/25 11:23
 */
public interface DemoService extends IBaseService<Demo> {
    @Override
    public List<Demo> findAll();

    public void saveUser(@Valid Demo demo);

    @Override
    public Demo findOne(String id);

    @Override
    public void delete(String id);

    public List<Demo> findByName(String name);

    public DataGrid findPage(PageParams page, Demo demo);

    public DataGrid findPageByMyBatis(PageParams page, Demo demo);


}
