package com.qfedu.hrs.persistence;

import java.util.List;

import com.qfedu.hrs.domain.Dept;
import com.qfedu.hrs.domain.Emp;

public interface EmpDAO extends BaseDAO<Emp, Integer> {

	List<Emp> findByDept(Dept dept);

}
