package com.library.microlibrary.dao.bookDao;

import com.library.microlibrary.dto.authorDto.GetAuthorCityDto;
import com.library.microlibrary.dto.bookDto.CreateBookDto;
import com.library.microlibrary.dto.bookDto.EditBookDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryDto;
import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.BookEntity;
import com.library.microlibrary.entities.CategoryEntity;
import com.library.microlibrary.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class BookDaoImpl implements BookDao {

    private final BookRepository bookRepository;


    @Override
    public BookEntity findBookByIdDao(Integer bookId) {
        BookEntity book = null;
        book = bookRepository.findByBookId(bookId);

        return book;
    }

    @Override
    public List<BookEntity> findBookListDao() {
        List<BookEntity> bookList = null;
        bookList = bookRepository.findAll();

        return bookList;
    }

    @Override
    public void createBookDao(CreateBookDto bookDto, GetCategoryDto categoryDto) {
        BookEntity book = null;
        CategoryEntity category = null;

        category = CategoryEntity.builder()
                .categoryId(categoryDto.getCategoryIdDto())
                .categoryName(categoryDto.getCategoryNameDto())
                .build();


        book = BookEntity.builder()
                .bookName(bookDto.getBookNameDto())
                .bookDescription(bookDto.getBookDescriptionDto())
                .bookIsbn(bookDto.getBookIsbnDto())
                .category(category)
                .build();

        bookRepository.save(book);
    }

    @Override
    public void editBookDao(EditBookDto bookDto, GetCategoryDto categoryDto, List<GetAuthorCityDto> authorDto) {

    }
}
