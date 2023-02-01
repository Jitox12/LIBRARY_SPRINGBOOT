package com.library.microlibrary.dao.libraryDao;

import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.libraryDto.CreateLibraryDto;
import com.library.microlibrary.dto.libraryDto.EditLibraryDto;
import com.library.microlibrary.entities.LibraryEntity;
import com.library.microlibrary.repositories.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class LibraryDaoImpl implements LibraryDao{

    private final LibraryRepository libraryRepository;

    @Override
    public LibraryEntity findLibraryByIdDao(Integer libraryId) {
        return null;
    }

    @Override
    public List<LibraryEntity> findLibraryListDao() {
        return null;
    }

    @Override
    public void createLibraryDao(CreateLibraryDto libraryDto, GetCityDto cityDto) {

    }

    @Override
    public void editLibraryDao(EditLibraryDto libraryDto, GetCityDto cityDto) {

    }
}
