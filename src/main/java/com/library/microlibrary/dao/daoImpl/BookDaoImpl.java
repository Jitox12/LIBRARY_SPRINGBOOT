package com.library.microlibrary.dao.daoImpl;

import com.library.microlibrary.dao.BookDao;
import com.library.microlibrary.dto.authorDto.GetAuthorCityDto;
import com.library.microlibrary.dto.bookDto.CreateBookDto;
import com.library.microlibrary.dto.bookDto.EditBookDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryDto;
import com.library.microlibrary.entities.BookEntity;
import com.library.microlibrary.entities.CategoryEntity;
import com.library.microlibrary.repositories.BookAuthorRepository;
import com.library.microlibrary.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Component
public class BookDaoImpl implements BookDao {

    private final BookRepository bookRepository;
    private final BookAuthorRepository bookAuthorRepository;



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

    @Transactional
    @Override
    public BookEntity createBookDao(CreateBookDto bookDto, GetCategoryDto categoryDto) {
        BookEntity book = null;
        CategoryEntity category = null;

        BookEntity bookSaved = null;

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

        bookSaved = bookRepository.save(book);

        return bookSaved;
    }

    @Override
    public void editBookDao(EditBookDto bookDto, GetCategoryDto categoryDto, List<GetAuthorCityDto> authorDto) {

    }
}
