package com.library.microlibrary.controllers;

import com.library.microlibrary.dto.bookDto.CreateBookDto;
import com.library.microlibrary.dto.bookDto.EditBookDto;
import com.library.microlibrary.dto.bookDto.GetBookDto;
import com.library.microlibrary.services.bookServices.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/find/{bookId}")
    public GetBookDto findBookById(@PathVariable Integer bookId){
        GetBookDto bookDto = null;

        return bookDto;
    }

    @GetMapping(value="/find-all")
    public List<GetBookDto> findBookList(){
        List<GetBookDto> bookDtoList = null;

        return bookDtoList;
    }

    @PostMapping(value ="/create")
    public String createBook(@RequestBody CreateBookDto bookDto){
        bookService.createBookService(bookDto);

        return "BOOK CREATED";
    }

    @PutMapping(value = "/edit/{bookId}")
    public String editBook(@PathVariable Integer bookId, @RequestBody EditBookDto bookDto){

        return "BOOK EDITED";
    }
}