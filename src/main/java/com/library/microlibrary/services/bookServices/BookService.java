package com.library.microlibrary.services.bookServices;

import com.library.microlibrary.dto.bookDto.CreateBookDto;
import com.library.microlibrary.dto.bookDto.EditBookDto;
import com.library.microlibrary.dto.bookDto.GetBookDto;
import com.library.microlibrary.entities.BookEntity;

import java.util.List;

public interface BookService {

    public GetBookDto findBookByIdService(Integer bookId);
    public List<GetBookDto> findBookListService();
    public void createBookService(CreateBookDto bookDto);
    public void editBookService(EditBookDto bookDto, Integer bookId);
}
