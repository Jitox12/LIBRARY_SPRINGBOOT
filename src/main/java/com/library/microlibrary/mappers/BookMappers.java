package com.library.microlibrary.mappers;

import com.library.microlibrary.dto.bookDto.GABookDto;
import com.library.microlibrary.dto.bookDto.GetBookDto;
import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMappers {

    BookMappers INSTANCE = Mappers.getMapper(BookMappers.class);

    @Mapping(source = "bookId", target = "bookIdDto")
    @Mapping(source = "bookName", target = "bookNameDto")
    @Mapping(source = "bookDescription", target = "bookDescriptionDto")
    @Mapping(source = "bookIsbn", target = "bookIsbnDto")
    @Mapping(source = "category", target = "categoryDto")
    GetBookDto BookToBookDto(BookEntity book);

    default List<String> authorName(List<AuthorEntity> authorList){
        List<String> authorNameList = new ArrayList<>();

        authorList.forEach((AuthorEntity author) -> {
            authorNameList.add(author.getAuthorName());
        });
        return authorNameList;
    }

    @Mapping(source = "bookId", target = "bookIdDto")
    @Mapping(source = "bookName", target = "bookNameDto")
    @Mapping(source = "category.categoryName", target = "categoryNameDto")
    @Mapping(source = "authors", target = "authorNameDto")
    GABookDto BookToGABookDto(BookEntity book);
}
