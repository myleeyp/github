package com.qfedu.hrs.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.qfedu.hrs.domain.Dept;
import com.qfedu.hrs.service.DeptService;

public class DeptControllerTest {
	
	@Test
	public void testShowDepts() throws Exception {
		
		DeptController controller = new DeptController();
		DeptService deptService = Mockito.mock(DeptService.class);
		List<Dept> deptList = new ArrayList<>();
		Mockito.when(deptService.listAllDepts()).thenReturn(deptList);
		controller.setDeptService(deptService);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/showDepts"))
			.andExpect(MockMvcResultMatchers.model().attributeExists("deptList"))
			.andExpect(MockMvcResultMatchers.view().name("dept"));
		
	}
}
