package com.library.microlibrary.dao.bookDao;

import com.library.microlibrary.dto.bookDto.CreateBookDto;
import com.library.microlibrary.dto.bookDto.EditBookDto;
import com.library.microlibrary.dto.cityDto.CreateCityDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.entities.BookEntity;
import com.library.microlibrary.entities.CityEntity;

import java.util.List;

public interface BookDao {

    public BookEntity findBookByIdDao(Integer bookId);
    public List<BookEntity> findBookListDao();
    public void createBookDao(CreateBookDto bookDto);
    public void editBookDao(EditBookDto bookDto);
}
