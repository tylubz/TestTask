package net.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.test.dao.ProductDao;
import net.test.model.Product;

public class DBData {

	@Autowired
	static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

	public List<Product> getPersonsListFromDB() {
		ProductDao dao = context.getBean(ProductDao.class);
		List<Product> list = (List<Product>) dao.findAll();
		return list;
	}

	public void addDatatoDB(String absPath) {
		ProductDao dao = context.getBean(ProductDao.class);
		ParseXLS parse = new ParseXLS();
		List<Product> peterList = parse.parse(absPath);
		for (Product tmp : peterList) {
			dao.save(tmp);
		}
	}
}
