package com.hybrid.orm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hybrid.orm.domain.Dept;

public class MyBatisTest {
	static Log log = LogFactory.getLog(MyBatisTest.class);

	public static void main(String[] args) throws IOException {
		
		String resource = "META-INF/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "world");
//		City c = session.selectOne("com.hybrid.orm.mapper.CityMapper.findOne", 1);
//		log.info("id = " + c.getId());
//		log.info("name = " + c.getName());		
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "employee");

		SqlSession session = sqlSessionFactory.openSession();
		Dept c = session.selectOne("com.hybrid.orm.mapper.DeptMapper.findOne", 10);
		log.info("id = " + c.getDeptno());
		log.info("name = " + c.getDname());	

		
		session.close();
		
	}

}
