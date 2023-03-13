package com.library.microlibrary.services;

import com.library.microlibrary.dto.bookDto.CreateBookDto;
import com.library.microlibrary.dto.bookDto.EditBookDto;
import com.library.microlibrary.dto.bookDto.GABookDto;
import com.library.microlibrary.dto.bookDto.GetBookDto;

import java.util.List;

public interface BookService {

    public GetBookDto findBookByIdService(Integer bookId);
    public List<GABookDto> findBookListService();
    public void createBookService(CreateBookDto bookDto);
    public void editBookService(EditBookDto bookDto, Integer bookId);
}
