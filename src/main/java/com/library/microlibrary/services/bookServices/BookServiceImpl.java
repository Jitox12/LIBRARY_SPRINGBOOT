package com.library.microlibrary.services.bookServices;


import com.library.microlibrary.dao.authorDao.AuthorDao;
import com.library.microlibrary.dao.bookAuthorDao.BookAuthorDao;
import com.library.microlibrary.dao.bookDao.BookDao;
import com.library.microlibrary.dao.categoryDao.CategoryDao;
import com.library.microlibrary.dto.authorDto.GetAuthorCityDto;
import com.library.microlibrary.dto.bookDto.CreateBookDto;
import com.library.microlibrary.dto.bookDto.EditBookDto;
import com.library.microlibrary.dto.bookDto.GetBookDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryDto;
import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.BookEntity;
import com.library.microlibrary.entities.CategoryEntity;
import com.library.microlibrary.mappers.authorMappers.AuthorEntityToGetFullAuthorDtoMapper;
import com.library.microlibrary.mappers.bookMappers.BookToBookDtoMapper;
import com.library.microlibrary.mappers.categoryMappers.CategoryEntityToGetCategoryDtoMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;
    private final BookAuthorDao bookAuthorDao;

    private final CategoryEntityToGetCategoryDtoMapper categoryEntityToGetCategoryDtoMapper;
    private final AuthorEntityToGetFullAuthorDtoMapper authorEntityToGetFullAuthorDtoMapper;
    private final BookToBookDtoMapper bookMapper;

    public BookServiceImpl(BookDao bookDao,
                           AuthorDao authorDao,
                           CategoryDao categoryDao,
                           BookAuthorDao bookAuthorDao,
                           CategoryEntityToGetCategoryDtoMapper categoryEntityToGetCategoryDtoMapper,
                           AuthorEntityToGetFullAuthorDtoMapper authorEntityToGetFullAuthorDtoMapper,
                           BookToBookDtoMapper bookMapper) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
        this.bookAuthorDao = bookAuthorDao;
        this.categoryEntityToGetCategoryDtoMapper = categoryEntityToGetCategoryDtoMapper;
        this.authorEntityToGetFullAuthorDtoMapper = authorEntityToGetFullAuthorDtoMapper;
        this.bookMapper = bookMapper;
    }

    @Override
    public GetBookDto findBookByIdService(Integer bookId) {
        return null;
    }

    @Override
    public List<GetBookDto> findBookListService() {
        return null;
    }

    @Override
    public void createBookService(CreateBookDto bookDto) {

        CategoryEntity category = null;
        GetCategoryDto categoryDto = null;

        BookEntity book =null;

        try {
            category = categoryDao.findCategoryByIdDao(bookDto.getCategoryIdDto());
            categoryDto = categoryEntityToGetCategoryDtoMapper.categoryEntityToGetCategoryDto(category);

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
