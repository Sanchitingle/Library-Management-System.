package com.nit;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<BookBO> {

    @Override
    public BookBO mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        BookBO book = new BookBO();

        book.setBookId(rs.getInt(1));
        book.setBookName(rs.getString(2));
        book.setAuthor(rs.getString(3));
        book.setPrice(rs.getDouble(4));

        return book;
    }
}