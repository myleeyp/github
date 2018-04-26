package com.qfedu.hrs.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.qfedu.hrs.domain.Dept;
import com.qfedu.hrs.service.DeptService;

@WebListener
public class PreLoadDataListener implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		ApplicationContext ctx = 
				WebApplicationContextUtils.getWebApplicationContext(sc);
		RedisTemplate<String, List<Dept>> template = 
				ctx.getBean(RedisTemplate.class);
		template.opsForValue().set("deptList", null);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		ApplicationContext ctx = 
				WebApplicationContextUtils.getWebApplicationContext(sc);
		ctx.getBean(DeptService.class).listAllDepts();
	}

}
