package com.library.microlibrary.dao.bookAuthorDao;

import com.library.microlibrary.dto.authorDto.GetAuthorCityDto;
import com.library.microlibrary.dto.authorDto.GetAuthorDto;
import com.library.microlibrary.dto.bookAuthorDto.BookAuthorDto;
import com.library.microlibrary.dto.bookDto.GetBookDto;

import java.io.IOException;
import java.util.List;

public interface BookAuthorDao {
    public  void createBookAuthorDao(Integer bookIdDto, List<Integer> authorIdDto) throws IOException;
}
