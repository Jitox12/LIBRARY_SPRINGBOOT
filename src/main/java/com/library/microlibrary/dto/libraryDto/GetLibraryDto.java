package com.library.microlibrary.dto.libraryDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetLibraryDto {
    private Integer libraryIdDto;
    private String libraryNameDto;
    private String cityNameDto;
    private String countryNameDto;
}
