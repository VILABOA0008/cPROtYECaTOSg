package com.ctag.library.infrastructure.jpa.book;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.seedstack.jpa.BaseJpaRepository;

import com.ctag.library.application.utils.LibraryUtils;
import com.ctag.library.domain.model.book.Book;
import com.ctag.library.domain.model.book.BookId;
import com.ctag.library.domain.model.book.BookRepository;
import com.ctag.library.infrastructure.jpa.JpaRepository;
import com.google.inject.Inject;

@JpaRepository
public class BookJpaRepository extends BaseJpaRepository<Book, BookId> implements BookRepository {

  private EntityManager entityManager;

  @Inject
  BookJpaRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Book> booksList() {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
    Root<Book> root = criteriaQuery.from(Book.class);
    criteriaQuery.select(root);
    return entityManager.createQuery(criteriaQuery).getResultList();
  }

  @Override
  public List<Book> getBooksBy(String column, String value) {
    LibraryUtils.isEmptyParams(Book.TABLE_NAME, column, value);
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
    Root<Book> root = criteriaQuery.from(Book.class);
    criteriaQuery.select(root).where(builder.equal(root.get(column), value));
    return entityManager.createQuery(criteriaQuery).getResultList();
  }

}
