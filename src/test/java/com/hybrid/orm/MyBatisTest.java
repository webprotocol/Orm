package com.hybrid.orm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hybrid.orm.domain.City;

public class MyBatisTest {
	static Log log = LogFactory.getLog(MyBatisTest.class);

	public static void main(String[] args) throws IOException {
		
		String resource = "META-INF/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "world");

		SqlSession session = sqlSessionFactory.openSession();
		
		City c = session.selectOne("com.hybrid.orm.mapper.CityMapper.findOne", 1);
		log.info("id = " + c.getId());
		log.info("name = " + c.getName());
		
		session.close();
	}

}
