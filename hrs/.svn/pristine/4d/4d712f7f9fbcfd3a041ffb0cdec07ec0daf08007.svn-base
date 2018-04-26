package com.qfedu.hrs.view;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.qfedu.hrs.domain.Dept;

public class DeptExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, Workbook workbook, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fname = URLEncoder.encode("部门信息表.xls", "utf-8");
		// System.out.println(fname);
		response.setHeader("Content-Disposition", "attachment; filename=" + fname);
		HSSFWorkbook book = (HSSFWorkbook) workbook;
		HSSFSheet sheet = book.createSheet();
		HSSFRow headerRow = sheet.createRow(0);
		String[] headerNames = { "编号", "名称", "所在地" };
		for (int i = 0; i < headerNames.length; ++i) {
			headerRow.createCell(i).setCellValue(headerNames[i]);
		}
		List<Dept> depList = (List<Dept>) model.get("deptList");
		int rownum = 1;
		String[] propNames = { "no", "name", "location" };
		for (Dept dept : depList) {
			HSSFRow row = sheet.createRow(rownum);
			for (int i = 0; i < propNames.length; ++i) {
				row.createCell(i).setCellValue(BeanUtils.getProperty(dept, propNames[i]));
			}
			rownum += 1;
		}
	}

}
