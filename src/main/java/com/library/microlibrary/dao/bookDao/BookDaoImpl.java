package com.library.microlibrary.dao.bookDao;

import com.library.microlibrary.dto.bookDto.CreateBookDto;
import com.library.microlibrary.dto.bookDto.EditBookDto;
import com.library.microlibrary.entities.BookEntity;
import com.library.microlibrary.repositories.AuthorRepository;
import com.library.microlibrary.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@AllArgsConstructor
@Component
public class BookDaoImpl implements BookDao{

    private  final BookRepository bookRepository;


    @Override
    public BookEntity findBookByIdDao(Integer bookId) {
        return null;
    }

    @Override
    public List<BookEntity> findBookListDao() {
        return null;
    }

    @Override
    public void createBookDao(CreateBookDto bookDto){
    }

    @Override
    public void editBookDao(EditBookDto bookDto) {

    }
}
