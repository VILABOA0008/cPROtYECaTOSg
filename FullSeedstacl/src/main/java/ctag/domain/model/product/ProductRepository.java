package ctag.domain.model.product;

import java.util.List;

import org.seedstack.business.domain.Repository;

public interface ProductRepository extends Repository<Product, ProductId> {

  List<Product> productList();

  Product getproductById(int id);

  boolean productDelete(int id);

  Product productModPrice(int id, float price);
  
  List<Product> expensiveProducts(float price);
  
}
