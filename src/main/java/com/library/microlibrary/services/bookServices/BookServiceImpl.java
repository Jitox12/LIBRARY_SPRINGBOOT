package com.library.microlibrary.services.bookServices;


import com.library.microlibrary.dto.bookDto.CreateBookDto;
import com.library.microlibrary.dto.bookDto.EditBookDto;
import com.library.microlibrary.entities.BookEntity;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Override
    public BookEntity findBookByIdService(Integer bookId) {
        return null;
    }

    @Override
    public List<BookEntity> findBookListService() {
        return null;
    }

    @Override
    public void createBookService(CreateBookDto bookDto) {

    }

    @Override
    public void editBookService(EditBookDto bookDto, Integer bookId) {

    }
}
