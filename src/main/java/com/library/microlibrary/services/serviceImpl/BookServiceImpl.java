package com.library.microlibrary.services.serviceImpl;


import com.library.microlibrary.dao.AuthorDao;
import com.library.microlibrary.dao.BookAuthorDao;
import com.library.microlibrary.dao.BookDao;
import com.library.microlibrary.dao.CategoryDao;
import com.library.microlibrary.dto.bookDto.CreateBookDto;
import com.library.microlibrary.dto.bookDto.EditBookDto;
import com.library.microlibrary.dto.bookDto.GABookDto;
import com.library.microlibrary.dto.bookDto.GetBookDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryDto;
import com.library.microlibrary.entities.BookEntity;
import com.library.microlibrary.entities.CategoryEntity;
import com.library.microlibrary.mappers.AuthorMappers;
import com.library.microlibrary.mappers.BookMappers;
import com.library.microlibrary.mappers.CategoryMappers;
import com.library.microlibrary.services.BookService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService {

    //DAO
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;
    private final BookAuthorDao bookAuthorDao;

    //MAPPERS
    private final CategoryMappers categoryMappers;
    private final AuthorMappers authorMappers;
    private final BookMappers bookMapper;

    public BookServiceImpl(BookDao bookDao, AuthorDao authorDao, CategoryDao categoryDao, BookAuthorDao bookAuthorDao, CategoryMappers categoryMappers, AuthorMappers authorMappers, BookMappers bookMapper) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
        this.bookAuthorDao = bookAuthorDao;
        this.categoryMappers = categoryMappers;
        this.authorMappers = authorMappers;
        this.bookMapper = bookMapper;
    }


    @Override
    public GetBookDto findBookByIdService(Integer bookId) {
        return null;
    }

    @Override
    public List<GABookDto> findBookListService()  {
        List<GABookDto> bookDtoList = null;
        List<BookEntity> bookList = null;

        try{
            bookList = bookDao.findBookListDao();
            bookDtoList = bookList.stream().map(bookMapper::BookToGABookDto).collect(Collectors.toList());

            return bookDtoList;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createBookService(CreateBookDto bookDto) {
        CategoryEntity category = null;
        GetCategoryDto categoryDto = null;

        BookEntity book =null;

        try {
            category = categoryDao.findCategoryByIdDao(bookDto.getCategoryIdDto());
            categoryDto = categoryMappers.categoryEntityToGetCategoryDto(category);

            book = bookDao.createBookDao(bookDto, categoryDto);
            bookDto.setBookIdDto(book.getBookId());

            bookAuthorDao.createBookAuthorDao(bookDto.getBookIdDto(), bookDto.getAuthorIdListDto());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editBookService(EditBookDto bookDto, Integer bookId) {

    }
}
