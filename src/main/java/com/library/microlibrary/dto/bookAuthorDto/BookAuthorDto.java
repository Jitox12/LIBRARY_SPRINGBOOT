package com.library.microlibrary.dto.bookAuthorDto;

import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.BookEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookAuthorDto {
    private BookEntity bookDto;
    private List<AuthorEntity> authorDto;
}
