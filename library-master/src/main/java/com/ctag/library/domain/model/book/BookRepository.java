package com.ctag.library.domain.model.book;

import java.util.List;

import org.seedstack.business.domain.Repository;

public interface BookRepository extends Repository<Book, BookId> {

  List<Book> booksList();

  List<Book> getBooksBy(String column, String value);

}
