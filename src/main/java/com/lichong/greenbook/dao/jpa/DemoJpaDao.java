package com.lichong.greenbook.dao.jpa;

import com.emdata.common.mvc.dao.BaseRepository;
import com.lichong.greenbook.entity.Demo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/25 11:30
 */
public interface DemoJpaDao extends BaseRepository<Demo> {

    List<Demo> findByNameAndAddress(String name, String address);

    List<Demo> findByName(String name);

    @Query(value = "from #{#entityName} u where u.name=:name")
    List<Demo> findByName1(@Param("name") String name);

    @Query(value = "select * from demo u where u.name=?1", nativeQuery = true)
    List<Demo> findByName2(String name);

    @Query(value = "SELECT * FROM demo WHERE name = ?1 ORDER BY ?#{#pageable}",
            countQuery = "SELECT count(*) FROM demo WHERE name = ?1 ORDER BY ?#{#pageable}", nativeQuery = true)
    Page<Demo> findPageByName(String lastname, Pageable pageable);

}
