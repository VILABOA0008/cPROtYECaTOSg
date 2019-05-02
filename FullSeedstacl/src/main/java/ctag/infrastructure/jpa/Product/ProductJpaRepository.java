package ctag.infrastructure.jpa.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.seedstack.business.specification.Specification;
import org.seedstack.jpa.BaseJpaRepository;

import ctag.domain.model.product.Product;
import ctag.domain.model.product.ProductId;
import ctag.domain.model.product.ProductRepository;
import ctag.domain.model.product.Product_;
import ctag.infrastructure.jpa.JpaRepository;

@JpaRepository
public class ProductJpaRepository extends BaseJpaRepository<Product, ProductId>
    implements ProductRepository {

  @Override
  public List<Product> productList() {
    EntityManager em = getEntityManager();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Product> cq = cb.createQuery(Product.class);
    Root<Product> emp = cq.from(Product.class);
    cq.select(emp);
    TypedQuery<Product> tp = em.createQuery(cq);
    List<Product> results = tp.getResultList();

    return results;
  }

  @Override
  public Product getproductById(int id) {
    EntityManager em = getEntityManager();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Product> cq = cb.createQuery(Product.class);
    Root<Product> emp = cq.from(Product.class);
    cq.select(emp).where(cb.equal(emp.get(Product_.ID_PRODUCT), id));
    TypedQuery<Product> tp = em.createQuery(cq);
    List<Product> results = tp.getResultList();
    Product cc = results.get(0);

    return cc;
  }

  @Override
  public boolean productDelete(int id) {

    Optional<Product> p = get(getSpecificationBuilder().of(Product.class)
        .property(Product_.ID_PRODUCT).equalTo(id).build()).findFirst();
    try {
      this.remove(p.get());
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  @Override
  public Product productModPrice(int id, float price) {

    Optional<Product> p = get(getSpecificationBuilder().of(Product.class)
        .property(Product_.ID_PRODUCT).equalTo(id).build()).findFirst();
    if (p.isPresent()) {
      System.out.println(p.get().toString());
      p.get().setCost(price);
      this.add(p.get());
      return p.get();
    }
    return null;

  }

  @Override
  public List<Product> expensiveProducts(float price) {

    Specification<Product> spec = getSpecificationBuilder().of(Product.class).property("cost")
        .greaterThan(price).build();
    List<Product> p = get(spec).collect(Collectors.toList());

    return p;
  }
}
