package com.qfedu.hrs.view;

import java.awt.Color;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.qfedu.hrs.domain.Dept;

public class DeptPdfView extends AbstractPdfView {

	private static final Color HEADER_COLOR = new Color(200, 210, 100);

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fname = URLEncoder.encode("部门报表.pdf", "utf-8");
		response.setHeader("Content-Disposition", "inline; filename=" + fname);
		
		document.setPageSize(PageSize.A4);
		document.setMargins(20, 20, 40, 40);
		BaseFont bf = BaseFont.createFont("c:/Windows/Fonts/FZLTCXHJW.TTF", BaseFont.IDENTITY_H, true);
		Font font = new Font(bf , 32, Font.ITALIC, HEADER_COLOR);
		Paragraph header = new Paragraph("部门信息表", font);
		document.add(header);
		Table table = new Table(3);
		Font font2 = new Font(bf, 18, Font.BOLD, Color.BLUE);
		String[] headerNames = { "编号", "名称", "所在地" };
		for (int i = 0; i < headerNames.length; ++i) {
			Cell cell = new Cell(new Paragraph(headerNames[i], font2));
			cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
			cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
			table.addCell(cell);
		}
		Font font3 = new Font(bf, 14, Font.NORMAL, Color.BLACK);
		List<Dept> deptList = (List<Dept>) model.get("deptList");
		String[] propNames = { "no", "name", "location" };
		for (Dept dept : deptList) {
			for (int i = 0; i < propNames.length; ++i) {
				String value = BeanUtils.getProperty(dept, propNames[i]);
				Cell cell = new Cell(new Paragraph(value, font3));
				table.addCell(cell);
			}
		}
		document.add(table);
		// document.newPage();
		// URL url = new URL("https://www.baidu.com/img/bd_logo1.png");
		String filename = request.getServletContext().getRealPath("/img") + "/mm.jpg";
		Image image = Image.getInstance(filename);
		image.scaleToFit(PageSize.A4.getWidth() / 3, PageSize.A4.getHeight() / 3);
		document.add(image);
	}

}
