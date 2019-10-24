package com.yefan;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.InputStream;

public class BaseTest {
  protected SqlSessionFactory sqlSessionFactory;

  @Before
  public void init(){
    try {
      String resource = "mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      System.out.println("sqlSessionFactory初始化-->"+sqlSessionFactory);

    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
