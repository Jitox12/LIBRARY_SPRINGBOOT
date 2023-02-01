package com.library.microlibrary.dao.libraryDao;

import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.dto.libraryDto.CreateLibraryDto;
import com.library.microlibrary.dto.libraryDto.EditLibraryDto;
import com.library.microlibrary.entities.EditorialEntity;
import com.library.microlibrary.entities.LibraryEntity;

import java.util.List;

public interface LibraryDao {

    public LibraryEntity findLibraryByIdDao(Integer libraryId);
    public List<LibraryEntity> findLibraryListDao();
    public void createLibraryDao(CreateLibraryDto libraryDto, GetCityDto cityDto);
    public void editLibraryDao(EditLibraryDto libraryDto, GetCityDto cityDto);
}
