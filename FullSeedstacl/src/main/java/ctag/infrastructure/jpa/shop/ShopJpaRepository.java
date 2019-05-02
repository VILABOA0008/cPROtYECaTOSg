package ctag.infrastructure.jpa.shop;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.seedstack.jpa.BaseJpaRepository;

import com.google.inject.Inject;

import ctag.domain.model.product.Product;
import ctag.domain.model.product.Product_;
import ctag.domain.model.shop.Shop;
import ctag.domain.model.shop.ShopId;
import ctag.domain.model.shop.ShopRepository;
import ctag.domain.model.shop.Shop_;
import ctag.infrastructure.jpa.JpaRepository;

@JpaRepository
public class ShopJpaRepository extends BaseJpaRepository<Shop, ShopId> implements ShopRepository {

  private EntityManager em;

  @Inject
  ShopJpaRepository(EntityManager em) {
    this.em = em;
  }

  @Override
  public List<Shop> shopList() {

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Shop> cq = cb.createQuery(Shop.class);
    Root<Shop> emp = cq.from(Shop.class);
    cq.select(emp);
    TypedQuery<Shop> tp = em.createQuery(cq);
    List<Shop> results = tp.getResultList();

    return results;

  }

  @Override
  public Shop getShopsById(int id) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Shop> cq = cb.createQuery(Shop.class);
    Root<Shop> emp = cq.from(Shop.class);
    cq.select(emp).where(cb.equal(emp.get(Shop_.ID_SHOP), id));
    TypedQuery<Shop> tp = em.createQuery(cq);
    List<Shop> results = tp.getResultList();
    Shop cc = results.get(0);

    return cc;
  }

  @Override
  public boolean shopDelete(int id) {

    Optional<Shop> shop = get(
        getSpecificationBuilder().of(Shop.class).property(Shop_.ID_SHOP).equalTo(id).build())
            .findFirst();
    if (shop.isPresent()) {
      remove(shop.get());
      return true;
    }

    return false;
  }

  @Override
  public Shop shoptModName(String name1, String name2) {
System.out.println(name1+"   "+name2);
    Optional<Shop> shop = get(getSpecificationBuilder().of(Shop.class).property(Shop_.NAME_SHOP).equalTo(name1).build()).findFirst();
  
    if (shop.isPresent()) {
      shop.get().setNameShop(name2);
      add(shop.get());
      return shop.get();
    }
    return null;

  }

  @Override
  public List<Product> prductsListByShop(int id) {

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Product> cq = cb.createQuery(Product.class);
    Root<Product> prod = cq.from(Product.class);

    Subquery<Shop> subQuery = cq.subquery(Shop.class);
    Root<Shop> subRoot = subQuery.from(Shop.class);
    subQuery.where(cb.equal(subRoot.get(Shop_.ID_SHOP), id)).select(subRoot.get(Shop_.ID_SHOP));

    /*
     * Predicate parentPredicate = prod.get(Product_.SHOP).in(subQuery);
     * cq.select(prod).where(parentPredicate);
     */
    // cq.select(prod).where(prod.get(Product_.SHOP).in(subQuery)).orderBy(cb.asc(prod.get(Product_.COST)));
    cq.select(prod).where(prod.get(Product_.SHOP).in(subQuery));

    TypedQuery<Product> tp = em.createQuery(cq);
    List<Product> results = tp.getResultList();

    return results;
  }

}

/*
 * @Override public List<Product> prductsListByShop(int id){
 * 
 * CriteriaBuilder cb = em.getCriteriaBuilder(); CriteriaQuery<Product> cq =
 * cb.createQuery(Product.class); Root<Product> prod = cq.from(Product.class);
 * 
 * Subquery<Shop> subQuery = cq.subquery(Shop.class); Root<Shop> subRoot =
 * subQuery.from(Shop.class); subQuery.where(cb.equal(subRoot.get(Shop_.ID_SHOP),id)).select
 * (subRoot.get(Shop_.ID_SHOP));
 * 
 * // Predicate parentPredicate = prod.get(Product_.SHOP).in(subQuery); //
 * cq.select(prod).where(parentPredicate);
 * 
 * 1 line
 * cq.select(prod).where(prod.get(Product_.SHOP).in(subQuery.where(cb.equal(subRoot.get(Shop_.
 * ID_SHOP),id)).select(subRoot.get(Shop_.ID_SHOP))));
 * 
 * cq.select(prod).where(prod.get(Product_.SHOP).in(subQuery)); TypedQuery<Product> tp =
 * em.createQuery(cq); List<Product> results = tp.getResultList();
 * 
 * return results; } }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
