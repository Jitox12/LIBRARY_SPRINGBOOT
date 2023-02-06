package com.library.microlibrary.dto.libraryDto;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateLibraryDto {
    private String libraryNameDto;
    private Integer cityIdDto;
}
