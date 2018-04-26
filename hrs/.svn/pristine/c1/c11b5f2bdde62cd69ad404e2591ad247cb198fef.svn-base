package com.qfedu.hrs.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qfedu.hrs.domain.Dept;
import com.qfedu.hrs.domain.Emp;
import com.qfedu.hrs.persistence.BaseDAOHibernateAdapter;
import com.qfedu.hrs.persistence.EmpDAO;

@Repository
public class EmpDAOImpl 
		extends BaseDAOHibernateAdapter<Emp, Integer> 
		implements EmpDAO {

	@Override
	public List<Emp> findByDept(Dept dept) {
		return sessionFactory.getCurrentSession()
			.createQuery("from Emp as e where e.dept=:dept", Emp.class)
			.setParameter("dept", dept)
			.getResultList();
	}

}
