package com.qfedu.hrs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.qfedu.hrs.domain.Dept;
import com.qfedu.hrs.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	private DeptService deptService; 
	
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	@GetMapping(value = "/to_add")
	public String toAddDept(Model model) {
		Dept dept = new Dept();
		model.addAttribute("dept", dept);
		return "add_dept";
	}
	
	@GetMapping(value = "/showDepts")
	public String showDepts(Model model) {
		model.addAttribute("deptList", deptService.listAllDepts());
		return "dept";
	}
	
	@PostMapping(value = "/addDept")
	public String addDept(@Valid Dept dept, Errors errors, Model model) {
		if (errors.hasErrors()) 
			return "add_dept";
		if (deptService.addNewDept(dept)) {
			return "redirect: showDepts";
		} else {
			model.addAttribute("hint", "���Ӳ���ʧ��");
			return "add_dept";
		}
	}
	
	@GetMapping(value = "/excel")
	public String exportExcel(ModelMap map) {
		map.put("deptList", deptService.listAllDepts());
		return "deptExcel";
	}
	
	@GetMapping(value = "/pdf")
	public String exportPdf(ModelMap map) {
		map.put("deptList", deptService.listAllDepts());
		return "deptPdf";
	}
	
}
