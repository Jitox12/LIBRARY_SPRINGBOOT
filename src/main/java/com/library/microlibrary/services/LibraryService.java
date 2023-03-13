package com.library.microlibrary.services;

import com.library.microlibrary.dto.bookDto.GABookDto;
import com.library.microlibrary.dto.libraryDto.CreateLibraryDto;
import com.library.microlibrary.dto.libraryDto.EditLibraryDto;
import com.library.microlibrary.dto.libraryDto.GetLibraryDto;

import java.util.List;

public interface LibraryService {

    public GetLibraryDto findLibraryByIdService(Integer libraryId);

    public List<GetLibraryDto> findLibraryListService();

    public void createLibraryService(CreateLibraryDto libraryDto);

    public void editLibraryService(EditLibraryDto libraryDto, Integer libraryId);

    public void createBookToLibraryService(Integer libraryId, List<GABookDto> bookList);
}
