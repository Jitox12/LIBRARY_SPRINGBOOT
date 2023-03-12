package com.library.microlibrary.mappers.bookMappers;

import com.library.microlibrary.dto.bookDto.GetBookDto;
import com.library.microlibrary.entities.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")

public interface BookToBookDtoMapper {

    BookToBookDtoMapper INSTANCE = Mappers.getMapper(BookToBookDtoMapper.class);

    @Mapping(source = "bookId", target = "bookIdDto")
    @Mapping(source = "bookName", target = "bookNameDto")
    @Mapping(source = "bookDescription", target = "bookDescriptionDto")
    @Mapping(source = "bookIsbn", target = "bookIsbnDto")
    @Mapping(source = "category", target = "categoryDto")
    GetBookDto BookToBookDto(BookEntity book);
}
