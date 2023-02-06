package com.library.microlibrary.dao.libraryDao;

import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.dto.libraryDto.CreateLibraryDto;
import com.library.microlibrary.dto.libraryDto.EditLibraryDto;
import com.library.microlibrary.entities.EditorialEntity;
import com.library.microlibrary.entities.LibraryEntity;

import java.io.IOException;
import java.util.List;

public interface LibraryDao {

    public LibraryEntity findLibraryByIdDao(Integer libraryId) throws IOException;
    public List<LibraryEntity> findLibraryListDao() throws IOException;
    public LibraryEntity createLibraryDao(CreateLibraryDto libraryDto, GetCityCountryDto cityDto) throws IOException;
    public LibraryEntity editLibraryDao(EditLibraryDto libraryDto, GetCityCountryDto cityDto) throws IOException;
}
