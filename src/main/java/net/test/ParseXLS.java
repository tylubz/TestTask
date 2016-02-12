package net.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.test.model.Product;

public class ParseXLS {
	List<Product> productList = null;

	public List<Product> parse(String absPath) {
		productList = new ArrayList<Product>();
		InputStream in = null;
		XSSFWorkbook wb = null;
		try {
			in = new FileInputStream(absPath);
			wb = new XSSFWorkbook(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> it = sheet.iterator();
		it.next();
		while (it.hasNext()) {
			Product tmp = new Product();
			Row row = it.next();
			Iterator<Cell> cells = row.iterator();
			tmp.setKey(new Double(cells.next().getNumericCellValue()).longValue());
			tmp.setName(cells.next().getStringCellValue());
			tmp.setPrice(cells.next().getNumericCellValue());
			tmp.setDate(cells.next().getDateCellValue());
			tmp.toString();
			productList.add(tmp);
		}
		return productList;
	}
}
