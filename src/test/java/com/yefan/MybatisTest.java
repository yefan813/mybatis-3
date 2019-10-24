package com.yefan;

import com.yefan.dao.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class MybatisTest {

  protected SqlSessionFactory sqlSessionFactory;

  @Before
  public void init(){
    try {
      String resource = "mybatis-config.xml";
      //加载mybatis配置文件获取输入流
      InputStream inputStream = Resources.getResourceAsStream(resource);
      //解析配置文件获取到SqlSessionFactory
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      System.out.println("sqlSessionFactory初始化-->"+sqlSessionFactory);

    }catch (Exception e){
      e.printStackTrace();
    }
  }

  @Test
  public void testXml() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      //blog 数据库为 11
      Blog blog = sqlSession.selectOne("com.yefan.dao.BlogMapper.selectByPrimaryKey", 1);
      System.out.println(blog.getName());

    } finally {
      sqlSession.close();
    }
  }
  @Test
  public void testXml2() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      Blog blog2 = sqlSession.selectOne("com.yefan.dao.BlogMapper.selectByPrimaryKey", 1);
      System.out.println(blog2.getName());
    } finally {
      sqlSession.close();
    }
  }

  @Test
  public void testMapper() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
      Blog blog = blogMapper.selectByPrimaryKey(1);
      System.out.println(blog.getName());
    } finally {
      sqlSession.close();
    }
  }
}
