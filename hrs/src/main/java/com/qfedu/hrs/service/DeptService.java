package com.qfedu.hrs.service;

import java.util.List;

import com.qfedu.hrs.domain.Dept;

// Transaction Script Pattern
// User request ---> method ---> transaction script
public interface DeptService {

	List<Dept> listAllDepts();
	
	boolean addNewDept(Dept dept);
	
	boolean removeDeptByNO(Integer no);
}
