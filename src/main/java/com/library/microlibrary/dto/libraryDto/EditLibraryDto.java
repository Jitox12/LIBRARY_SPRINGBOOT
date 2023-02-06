package com.library.microlibrary.dto.libraryDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditLibraryDto {
    private Integer libraryIdDto;
    private String libraryNameDto;
    private Integer cityIdDto;

}
