package com.library.microlibrary.services.libraryServices;

import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.libraryDto.CreateLibraryDto;
import com.library.microlibrary.dto.libraryDto.EditLibraryDto;
import com.library.microlibrary.dto.libraryDto.GetLibraryDto;
import com.library.microlibrary.entities.LibraryEntity;

import java.util.List;

public interface LibraryService {

    public GetLibraryDto findLibraryByIdService(Integer libraryId);
    public List<GetLibraryDto> findLibraryListService();
    public void createLibraryService(CreateLibraryDto libraryDto);
    public void editLibraryService(EditLibraryDto libraryDto, Integer libraryId);
}
