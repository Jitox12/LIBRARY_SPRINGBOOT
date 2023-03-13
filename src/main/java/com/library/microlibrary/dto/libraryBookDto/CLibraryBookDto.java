package com.library.microlibrary.dto.libraryBookDto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CLibraryBookDto {
    private List<Integer> booksIdDto;
    private Integer libraryIdDto;
}
