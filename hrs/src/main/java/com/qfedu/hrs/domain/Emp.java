package com.qfedu.hrs.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TbEmp")
public class Emp implements Serializable {
	@Id
	@Column(name = "empno")
	private Integer no;
	@Column(name = "ename")
	private String name;
	private String job;
	@ManyToOne
	@JoinColumn(name = "mgr")
	private Emp manager;
	private Integer sal;
	@ManyToOne
	@JoinColumn(name = "dno")
	private Dept dept;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Emp getManager() {
		return manager;
	}

	public void setManager(Emp manager) {
		this.manager = manager;
	}

	public Integer getSal() {
		return sal;
	}

	public void setSal(Integer sal) {
		this.sal = sal;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}
