package com.qfedu.hrs.service;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qfedu.hrs.domain.Dept;

// Keep your bar green!
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean.xml")
public class DeptServiceTest  {
	
	@Autowired
	private DeptService deptService;

	@Test
	public void testListAllDepts() {
		List<Dept> list = deptService.listAllDepts();
		assertNotNull(list);
		assertTrue(list.size() > 0);
		assertThat(list.get(0), instanceOf(Dept.class));
	}
	
	
	@Test
	public void testAddAndRemoveDept() {
		Dept dept = new Dept();
		dept.setNo(50);
		dept.setName("吃饭部");
		dept.setLocation("深圳");
		assertTrue(deptService.addNewDept(dept));
		assertTrue(deptService.removeDeptByNO(50));
	}
}
