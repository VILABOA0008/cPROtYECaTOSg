package com.ctag.library.infrastructure.jpa.customer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.seedstack.jpa.BaseJpaRepository;

import com.ctag.library.application.utils.LibraryUtils;
import com.ctag.library.domain.model.customer.Customer;
import com.ctag.library.domain.model.customer.CustomerId;
import com.ctag.library.domain.model.customer.CustomerRepository;
import com.ctag.library.infrastructure.jpa.JpaRepository;
import com.google.inject.Inject;

@JpaRepository
public class CustomerJpaRepository extends BaseJpaRepository<Customer, CustomerId>
    implements CustomerRepository {

  private EntityManager entityManager;

  @Inject
  CustomerJpaRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Customer> customerList() {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);
    Root<Customer> root = criteriaQuery.from(Customer.class);
    criteriaQuery.select(root);
    return entityManager.createQuery(criteriaQuery).getResultList();
  }

  @Override
  public List<Customer> getCustomerBy(String column, String value) {
    LibraryUtils.isEmptyParams(Customer.TABLE_NAME, column, value);
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);
    Root<Customer> root = criteriaQuery.from(Customer.class);
    criteriaQuery.select(root).where(builder.equal(root.get(column), value));
    return entityManager.createQuery(criteriaQuery).getResultList();
  }

}
