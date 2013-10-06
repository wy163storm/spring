package test.com.jd.risk.demo.spring.jdbc;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jd.risk.demo.spring.bean.UserEntity;
import com.jd.risk.demo.spring.jdbc.IRiskDataDAO;
import com.jd.risk.demo.spring.jdbc.impl.RiskDataDAOImpl;

public class TestJdbcDAo extends TestCase{

	private static final String configLocation = "classpath:/config/spring/spring-jdbc.xml";
	private ApplicationContext ctx = null;
	
	@Override
	protected void setUp() throws Exception {

		ctx = new ClassPathXmlApplicationContext(configLocation);
	}
	
//	@Test
	public void testAddUser(){
		
		IRiskDataDAO riskDao = ctx.getBean(RiskDataDAOImpl.class);
		for(int i =2;i<=100;i++){
			UserEntity entity = new UserEntity();
			entity.setUserName("wangyong_"+i);
			riskDao.insert(entity);
		}
	}
	@Test
	public void testQuery(){
		IRiskDataDAO riskDao = ctx.getBean(RiskDataDAOImpl.class);
		List<UserEntity> entities = riskDao.query();
		for(UserEntity entity : entities){
			System.out.println("Id : "+entity.getUserId()+" usr Name: "+entity.getUserName());
		}
		
	}
}
