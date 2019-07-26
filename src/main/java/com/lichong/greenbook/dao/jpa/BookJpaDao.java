package com.lichong.greenbook.dao.jpa;

import com.emdata.common.mvc.dao.BaseRepository;
import com.lichong.greenbook.entity.Book;
import com.lichong.greenbook.entity.Category;

import java.util.List;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/26 14:44
 */
public interface BookJpaDao extends BaseRepository<Book> {

    List<Book> findAllByCategoryId(Category category);

    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1,String keyword2);
}
