package com.ctag.library.interfaces.rest.book;

import org.seedstack.business.assembler.BaseAssembler;

import com.ctag.library.domain.model.book.Book;
import com.ctag.library.domain.model.book.BookId;

public class BookAssembler extends BaseAssembler<Book, BookRepresentation> {

  @Override
  public void mergeAggregateIntoDto(Book sourceAggregate, BookRepresentation targetDto) {
    targetDto.setIdBook(sourceAggregate.getIdBook());
    targetDto.setAuthor(sourceAggregate.getAuthor());
    targetDto.setTitle(sourceAggregate.getTitle());
    targetDto.setPrice(sourceAggregate.getPrice());
    targetDto.setQuantity(sourceAggregate.getQuantity());
  }

  @Override
  public void mergeDtoIntoAggregate(BookRepresentation sourceDto, Book targetAggregate) {
    targetAggregate.setIdBook(new BookId(sourceDto.getIdBook()));
    targetAggregate.setAuthor(sourceDto.getAuthor());
    targetAggregate.setTitle(sourceDto.getTitle());
    targetAggregate.setPrice(sourceDto.getPrice());
    targetAggregate.setQuantity(sourceDto.getQuantity());
  }

}
