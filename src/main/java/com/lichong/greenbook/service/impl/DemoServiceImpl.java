package com.lichong.greenbook.service.impl;

import com.emdata.common.models.DataGrid;
import com.emdata.common.models.PageParams;
import com.emdata.common.models.PageableTools;
import com.emdata.common.mvc.bind.enums.SearchOperator;
import com.emdata.common.mvc.bind.search.Search;
import com.emdata.common.mvc.service.BaseService;
import com.github.pagehelper.PageInfo;
import com.lichong.greenbook.dao.jpa.DemoJpaDao;
import com.lichong.greenbook.dao.mybatis.DemoMyBatisDao;
import com.lichong.greenbook.entity.Demo;
import com.lichong.greenbook.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/2 11:23
 */
@Service
public class DemoServiceImpl extends BaseService<Demo> implements DemoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Autowired
    private DemoJpaDao demoJpaDao;

    @Autowired
    private DemoMyBatisDao demoMyBatisDao;

    @Override
    public List<Demo> findAll() {
        return demoJpaDao.findAll();
    }

    @Override
    public List<Demo> findByName(String name) {
        // jpa 查询
        List<Demo> userList = demoJpaDao.findByName(name);
        List<Demo> userList1 = demoJpaDao.findByName1(name);
        List<Demo> userList2 = demoJpaDao.findByName2(name);
        Page<Demo> userList3 = demoJpaDao.findPageByName(name, Pageable.unpaged());



        // search查询
        Search search = new Search();
        // search.addSearchaFilter("name", SearchOperator.eq, name);
        List<String> list = new ArrayList();
        list.add(name);
//        search.addOrSearchaFilter("name", SearchOperator.in, list);
        search.addSearchaFilter("name",SearchOperator.eq,list);
        List<Demo> userList4 = super.findAll(search);
        System.out.println(userList4);


        // mybatis查询
        Demo demo = new Demo();
        demo.setName(name);
        List<Demo> mybatisUserList = demoMyBatisDao.selectAll();


        LOGGER.info("测试日志打印");
        // throw new ServiceException("测试全局异常处理");

        return userList;
    }

    @Override
    public void saveUser(Demo book) {
        demoJpaDao.save(book);
    }

    @Cacheable("users")
    @Override
    public Demo findOne(String id) {
        System.out.println("Cached Pages");
        return super.findOne(id);
    }

    @Override
    public void delete(String id) {
        demoJpaDao.deleteById(id);
    }

    @Override
    public DataGrid findPage(PageParams page, Demo demo) {
        Pageable pageable = PageableTools.basicPage(page.getPageIndex(), page.getPageSize(), page.getOrderField(),
                page.getOrderType());
        Page<Demo> data = demoJpaDao.findAll(pageable);
        // Page<Demo> data = demoJpaDao.findPageByName(demo.getName(),pageable);
        return new DataGrid(data.getTotalElements(), data.getContent());
    }

    @Override
    public DataGrid findPageByMyBatis(PageParams page, Demo demo) {
        // 设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        // PageHelper.startPage(page.getPageNo(), page.getPageSize());
        PageableTools.basicPageHelper(page.getPageIndex(), page.getPageSize(), page.getOrderField(),
                page.getOrderType());

        List<Demo> list = demoMyBatisDao.selectByParams(demo);
        PageInfo<Demo> pageInfo = new PageInfo<Demo>(list);

        return new DataGrid(pageInfo.getTotal(), pageInfo.getList());
    }

}
