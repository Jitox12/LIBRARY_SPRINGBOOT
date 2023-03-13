package com.library.microlibrary.dao.daoImpl;

import com.library.microlibrary.dao.BookAuthorDao;
import com.library.microlibrary.entities.BookAuthorEntity;
import com.library.microlibrary.repositories.BookAuthorRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookAuthorDaoImpl implements BookAuthorDao {

    private final BookAuthorRepository bookAuthorRepository;

    public BookAuthorDaoImpl(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository = bookAuthorRepository;
    }

    @Override
    public void createBookAuthorDao(Integer bookIdDto, List<Integer> authorIdDto) {
        List<BookAuthorEntity> bookAuthorList = new ArrayList<>();
        List<BookAuthorEntity> bookSaved = null;

        authorIdDto.forEach((Integer id)-> {
            bookAuthorList.add(BookAuthorEntity.builder()
                    .bookId(bookIdDto)
                    .authorId(id)
                    .build());
        });
        bookAuthorRepository.saveAll(bookAuthorList);
    }
}