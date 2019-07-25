package com.lichong.greenbook.dao.mybatis;

import com.lichong.greenbook.entity.Demo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/25 13:20
 */
@Mapper
public interface DemoMyBatisDao {

    List<Demo> selectAll();

    List<Demo> selectByParams(Demo demo);

    List<Map<String,String>> getDemoMap();
}
