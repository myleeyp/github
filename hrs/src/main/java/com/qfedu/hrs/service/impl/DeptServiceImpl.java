package com.qfedu.hrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.hrs.domain.Dept;
import com.qfedu.hrs.persistence.DeptDAO;
import com.qfedu.hrs.service.DeptService;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDAO deptDAO;
	@Autowired
	private RedisTemplate<String, List<Dept>> redisTemplate;
	
	@Override
	public List<Dept> listAllDepts() {
		List<Dept> deptList = redisTemplate.opsForValue().get("deptList");
		if (deptList == null) {
			deptList = deptDAO.findAll();
			redisTemplate.opsForValue().set("deptList", deptList);
		}
		return deptList;
	}

	@Override
	public boolean addNewDept(Dept dept) {
		if (deptDAO.findById(dept.getNo()) == null) {
			deptDAO.save(dept);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeDeptByNO(Integer no) {
		return deptDAO.deleteById(no);
	}

}
