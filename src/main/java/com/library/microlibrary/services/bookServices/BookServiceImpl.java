package com.library.microlibrary.services.bookServices;


import com.library.microlibrary.dao.authorDao.AuthorDao;
import com.library.microlibrary.dao.bookDao.BookDao;
import com.library.microlibrary.dao.categoryDao.CategoryDao;
import com.library.microlibrary.dto.authorDto.GetAuthorCityDto;
import com.library.microlibrary.dto.bookDto.CreateBookDto;
import com.library.microlibrary.dto.bookDto.EditBookDto;
import com.library.microlibrary.dto.bookDto.GetBookDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryDto;
import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.CategoryEntity;
import com.library.microlibrary.exceptionsConfig.exceptions.BadRequestException;
import com.library.microlibrary.mappers.authorMappers.AuthorEntityToGetFullAuthorDtoMapper;
import com.library.microlibrary.mappers.categoryMappers.CategoryEntityToGetCategoryDtoMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    private final CategoryEntityToGetCategoryDtoMapper categoryEntityToGetCategoryDtoMapper;
    private final AuthorEntityToGetFullAuthorDtoMapper authorEntityToGetFullAuthorDtoMapper;

    public BookServiceImpl(BookDao bookDao, AuthorDao authorDao, CategoryDao categoryDao, CategoryEntityToGetCategoryDtoMapper categoryEntityToGetCategoryDtoMapper, AuthorEntityToGetFullAuthorDtoMapper authorEntityToGetFullAuthorDtoMapper) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
        this.categoryEntityToGetCategoryDtoMapper = categoryEntityToGetCategoryDtoMapper;
        this.authorEntityToGetFullAuthorDtoMapper = authorEntityToGetFullAuthorDtoMapper;
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
        List<AuthorEntity> authorList = null;
        CategoryEntity category = null;
        GetCategoryDto categoryDto = null;

            try{
                category = categoryDao.findCategoryByIdDao(bookDto.getCategoryIdDto());
                categoryDto = categoryEntityToGetCategoryDtoMapper.categoryEntityToGetCategoryDto(category);


                bookDao.createBookDao(bookDto, categoryDto);
            }catch (IOException e){
                throw new RuntimeException(e);
            }
    }

    @Override
    public void editBookService(EditBookDto bookDto, Integer bookId) {

    }
}
