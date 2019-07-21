package com.danhuang.elastic;

import com.danhuang.elastic.bean.Article;
import com.danhuang.elastic.bean.Book;
import com.danhuang.elastic.repository.BookRespository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03ElasticApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRespository bookrespository;

    //这个测试可能有点问题
    @Test
    public void test02(){
//        Book book = new Book();
//        book.setId(1);
//        book.setBookName("西游记");
//        book.setAuthor("吴承恩");
//        bookrespository.index(book);

        for (Book book : bookrespository.findByBookNameLike("游")) {
            System.out.println(book);
        }

    }

    @Test
    public void contextLoads() {
        //1.给es中索引（保存）一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("张三");
        article.setContent("hello world");
        //构建一个索引功能
        Index index = new Index.Builder(article).index("danhuang").type("news").build();

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //测试搜索
    @Test
    public void search(){
        //用content搜索，带hello的
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("danhuang").addType("news").build();

        //执行
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
