package com.library.microlibrary.dto.editorialDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEditorialDto {
    private String editorialNameDto;
    private Integer cityIdDto;
}
