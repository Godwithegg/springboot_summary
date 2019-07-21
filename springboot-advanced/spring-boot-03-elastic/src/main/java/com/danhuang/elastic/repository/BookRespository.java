package com.danhuang.elastic.repository;

import com.danhuang.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRespository extends ElasticsearchRepository<Book,Integer> {

    public List<Book> findByBookNameLike(String bookName);
}
