package com.qfedu.hrs.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "TbDept")
public class Dept implements Serializable {
	@Id
	@Column(name = "deptno")
	@Min(value = 10)
	@Max(value = 99)
	private Integer no;
	@Column(name = "dname")
	@Length(min = 3, max = 10)
	private String name;
	@Column(name = "dloc")
	@Pattern(regexp = "^.{2,20}$")
	private String location;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
