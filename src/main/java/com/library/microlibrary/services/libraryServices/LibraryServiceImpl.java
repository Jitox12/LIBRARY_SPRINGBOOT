package com.library.microlibrary.services.libraryServices;

import com.library.microlibrary.dto.libraryDto.CreateLibraryDto;
import com.library.microlibrary.dto.libraryDto.EditLibraryDto;
import com.library.microlibrary.entities.LibraryEntity;

import java.util.List;

public class LibraryServiceImpl implements LibraryService{


    @Override
    public LibraryEntity findLibraryByIdService(Integer libraryId) {
        return null;
    }

    @Override
    public List<LibraryEntity> findLibraryListService() {
        return null;
    }

    @Override
    public void createLibraryService(CreateLibraryDto libraryDto) {

    }

    @Override
    public void editLibraryService(EditLibraryDto libraryDto, Integer libraryId) {

    }
}
