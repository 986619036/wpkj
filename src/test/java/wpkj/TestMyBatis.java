package wpkj;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.wpkj.domain.Usert;
import com.wpkj.service.UsertService;

@RunWith(SpringJUnit4ClassRunner.class)//继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class TestMyBatis {
	 private static Logger logger = Logger.getLogger(TestMyBatis.class);
	 @Resource
	 private UsertService usertService;
	 
	 @Test
	 public void test(){
		 Usert u=usertService.getEntity(1);
		 logger.info(JSON.toJSONString(u));
	 }
}
