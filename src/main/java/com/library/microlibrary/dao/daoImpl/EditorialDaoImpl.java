package com.library.microlibrary.dao.daoImpl;

import com.library.microlibrary.dao.EditorialDao;
import com.library.microlibrary.dto.bookDto.GABookDto;
import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.editorialDto.CreateEditorialDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.entities.BookEditorialEntity;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.EditorialEntity;
import com.library.microlibrary.repositories.BookEditorialRepository;
import com.library.microlibrary.repositories.EditorialRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EditorialDaoImpl implements EditorialDao {

    private final EditorialRepository editorialRepository;
    private final BookEditorialRepository bookEditorialRepository;

    public EditorialDaoImpl(EditorialRepository editorialRepository, BookEditorialRepository bookEditorialRepository) {
        this.editorialRepository = editorialRepository;
        this.bookEditorialRepository = bookEditorialRepository;
    }

    @Override
    public EditorialEntity findEditorialNameByIdDao(Integer editorialId) throws IOException {
        EditorialEntity editorial = null;
        editorial = editorialRepository.findEditorialNameByEditorialId(editorialId);
        return editorial;
    }
    @Override
    public EditorialEntity findEditorialByIdDao(Integer editorialId) throws IOException{
        EditorialEntity editorial = null;
        editorial = editorialRepository.findEditorialNameByEditorialId(editorialId);
        return editorial;
    }

    @Override
    public List<EditorialEntity> findEditorialListDao() throws IOException{
        List<EditorialEntity> editorialList = null;
        editorialList = editorialRepository.findAll();
        return editorialList;
    }

    @Override
    public void createEditorialDao(CreateEditorialDto editorialDto,
                                              GetCityCountryDto cityDto) throws IOException{
        EditorialEntity editorial = null;
        CityEntity city = null;

        city = CityEntity.builder()
                .cityName(cityDto.getCityNameDto())
                .cityId(cityDto.getCityIdDto())
                .country(cityDto.getCountryDto())
                .build();

        editorial = EditorialEntity.builder()
                .editorialName(editorialDto.getEditorialNameDto())
                .city(city)
                .build();

         editorialRepository.save(editorial);

    }

    @Override
    public void editEditorialDao(EditEditorialDto editorialDto,
                                            GetCityCountryDto cityDto) throws IOException{
        EditorialEntity editorial = null;
        CityEntity city = null;

        city = CityEntity.builder()
                .cityName(cityDto.getCityNameDto())
                .cityId(cityDto.getCityIdDto())
                .country(cityDto.getCountryDto())
                .build();

        editorial = EditorialEntity.builder()
                .editorialId(editorialDto.getEditorialIdDto())
                .editorialName(editorialDto.getEditorialNameDto())
                .city(city)
                .build();

        editorialRepository.save(editorial);
    }

    @Override
    public void createBookToEditorialDao(Integer editorialId , List<GABookDto> bookList) {
        List<BookEditorialEntity> bookEditorialList = new ArrayList<>();

        bookList.forEach((GABookDto book) -> {
            bookEditorialList.add(BookEditorialEntity.builder()
                    .bookId(book.getBookIdDto())
                    .editorialId(editorialId)
                    .build());
        });

        bookEditorialRepository.saveAll(bookEditorialList);
    }
}