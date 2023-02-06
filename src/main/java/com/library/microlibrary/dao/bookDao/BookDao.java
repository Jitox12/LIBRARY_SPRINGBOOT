package com.library.microlibrary.dao.bookDao;

import com.library.microlibrary.dto.bookDto.CreateBookDto;
import com.library.microlibrary.dto.bookDto.EditBookDto;
import com.library.microlibrary.dto.cityDto.CreateCityDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.entities.BookEntity;
import com.library.microlibrary.entities.CityEntity;

import java.io.IOException;
import java.util.List;

public interface BookDao {

    public BookEntity findBookByIdDao(Integer bookId) throws IOException;
    public List<BookEntity> findBookListDao() throws IOException;
    public void createBookDao(CreateBookDto bookDto) throws IOException;
    public void editBookDao(EditBookDto bookDto) throws IOException;
}
