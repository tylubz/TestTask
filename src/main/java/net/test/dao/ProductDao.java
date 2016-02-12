package net.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.test.model.Product;

/**
 * Product dao interface
 * 
 * @author Sergey
 */
@Repository
public interface ProductDao extends CrudRepository<Product, Long> {

	public List<Product> findByName(String name);
}
