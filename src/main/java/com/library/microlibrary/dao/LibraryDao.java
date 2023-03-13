package com.library.microlibrary.dao;

import com.library.microlibrary.dto.bookDto.GABookDto;
import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.libraryDto.CreateLibraryDto;
import com.library.microlibrary.dto.libraryDto.EditLibraryDto;
import com.library.microlibrary.entities.LibraryEntity;

import java.io.IOException;
import java.util.List;

public interface LibraryDao {

    public LibraryEntity findLibraryByIdDao(Integer libraryId) throws IOException;
    public List<LibraryEntity> findLibraryListDao() throws IOException;
    public void createLibraryDao(CreateLibraryDto libraryDto, GetCityCountryDto cityDto) throws IOException;
    public void editLibraryDao(EditLibraryDto libraryDto, GetCityCountryDto cityDto) throws IOException;
    public void createBookToLibraryDao(Integer libraryId, List<GABookDto> bookList) throws IOException;
}
