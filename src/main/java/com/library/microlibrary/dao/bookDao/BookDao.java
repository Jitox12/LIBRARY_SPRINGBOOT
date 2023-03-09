package com.library.microlibrary.dao.bookDao;

import com.library.microlibrary.dto.authorDto.GetAuthorCityDto;
import com.library.microlibrary.dto.bookDto.CreateBookDto;
import com.library.microlibrary.dto.bookDto.EditBookDto;
import com.library.microlibrary.dto.categoryDto.GetCategoryDto;
import com.library.microlibrary.entities.BookEntity;

import java.io.IOException;
import java.util.List;

public interface BookDao {

    public BookEntity findBookByIdDao(Integer bookId) throws IOException;
    public List<BookEntity> findBookListDao() throws IOException;
    public void createBookDao(CreateBookDto bookDto, GetCategoryDto categoryDto) throws IOException;
    public void editBookDao(EditBookDto bookDto, GetCategoryDto categoryDto, List<GetAuthorCityDto> authorDto) throws IOException;
}
