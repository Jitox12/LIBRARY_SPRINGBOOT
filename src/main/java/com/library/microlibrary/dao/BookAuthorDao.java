package com.library.microlibrary.dao;



import java.io.IOException;
import java.util.List;

public interface BookAuthorDao {
    public  void createBookAuthorDao(Integer bookIdDto, List<Integer> authorIdDto) throws IOException;
}
