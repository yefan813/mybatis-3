package com.yefan;

import com.yefan.dao.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest extends BaseTest{

  @Test
  public void testXml() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      Blog blog = sqlSession.selectOne("com.yefan.dao.BlogMapper.selectByPrimaryKey",1);
      System.out.println(blog.getName());
    }finally {
      sqlSession.close();
    }
  }

  @Test
  public void testMapper() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try{
      BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
      Blog blog = blogMapper.selectByPrimaryKey(1);
      System.out.println(blog.getName());
    }finally {
      sqlSession.close();
    }
  }
}
