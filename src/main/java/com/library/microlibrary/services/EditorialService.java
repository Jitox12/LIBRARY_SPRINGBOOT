package com.library.microlibrary.services;

import com.library.microlibrary.dto.bookDto.GABookDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.dto.editorialDto.GetEditorialDto;

import java.util.List;

public interface EditorialService {


    public GetEditorialDto findEditorialByIdService(Integer editorialId);
    public List<GetEditorialDto> findEditorialListService();
    public void createEditorialService(CreateEditorialDto editorialDto);
    public void editEditorialService(EditEditorialDto editorialDto, Integer editorialId);
    public void createBookToEditorialService(Integer editorialId, List<GABookDto> bookList);

}
