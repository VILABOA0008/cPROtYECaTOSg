package ctag.infrastructure.jpa.customer;

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

import com.google.inject.Inject;

import ctag.domain.model.customer.Customer;
import ctag.domain.model.customer.CustomerId;
import ctag.domain.model.customer.CustomerRepository;
import ctag.domain.model.customer.Customer_;
import ctag.domain.model.product.Product_;
import ctag.domain.model.shop.Shop_;
import ctag.infrastructure.jpa.JpaRepository;

@JpaRepository
public class CustomerJpaRepository extends BaseJpaRepository<Customer, CustomerId>
    implements CustomerRepository {

  private EntityManager em;

  @Inject
  CustomerJpaRepository(EntityManager em) {
    this.em = em;
  }

  @Override
  public List<Customer> customerList() {

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
    Root<Customer> emp = cq.from(Customer.class);
    cq.select(emp);
    TypedQuery<Customer> tp = em.createQuery(cq);
    List<Customer> results = tp.getResultList();

    return results;
  }

  @Override
  public Customer getCustomersById(int id) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
    Root<Customer> emp = cq.from(Customer.class);
    cq.select(emp).where(cb.equal(emp.get(Customer_.ID_CUSTOMER), id));
    TypedQuery<Customer> tp = em.createQuery(cq);
    List<Customer> results = tp.getResultList();
    Customer cc = results.get(0);

    return cc;
    
  }
  

  @Override
  public List<Customer> findByAll(String column, String id) {
    System.out.println(column + "  " + id);
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
    Root<Customer> emp = cq.from(Customer.class);
    cq.select(emp).where(cb.equal(emp.get(column), id));
    TypedQuery<Customer> tp = em.createQuery(cq);
    List<Customer> results = tp.getResultList();

    return results;

  }

  @Override
  public List<Customer> idShops(int id) {

    Specification<Customer> spec = getSpecificationBuilder().of(Customer.class)
        .property(Customer_.SHOP + '.' + Shop_.ID_SHOP).between(id, id + 3).build();

    return get(spec).collect(Collectors.toList());
  }

  @Override
  public List<Customer> richClientes(float minMoney) {
    Specification<Customer> spec = getSpecificationBuilder().of(Customer.class)
        .property(Customer_.MONEY).greaterThan(minMoney).build();

    return get(spec).collect(Collectors.toList());

  }

  @Override
  public List<Customer> vipCustomers(float minCostProducts) {
    Specification<Customer> spec = getSpecificationBuilder().of(Customer.class)
        .property(Customer_.SHOP + "." + Shop_.PRODUCTS + "." + Product_.COST)
        .lessThan(minCostProducts).build();

    
    return get(spec).collect(Collectors.toList());

  }

  @Override
  public boolean customerDelete(int id) {

    Optional<Customer> customer = get(getSpecificationBuilder().of(Customer.class)
        .property(Customer_.ID_CUSTOMER).equalTo(id).build()).findFirst();
    try {
      this.remove(customer.get());
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  @Override
  public Customer customerModMoney(int id, float money) {

    Optional<Customer> customer = get(getSpecificationBuilder().of(Customer.class)
        .property(Customer_.ID_CUSTOMER).equalTo(id).build()).findFirst();
    if (customer.isPresent()) {
      customer.get().setMoney(money);
      add(customer.get());
      return customer.get();
    }
    return null;



  }

}
