package com.nit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("book")
public class BookDao {

    private static final String QUERY_FOR_BOOK_COUNT =
            "select count(1) from BOOK";

    private static final String QUERY_FOR_BOOKNAME_BYID =
            "select BOOKNAME from BOOK where BOOKID=?";

    private static final String QUERY_FOR_ALLDETAIL_BYID =
            "select BOOKID, BOOKNAME, AUTHOR, PRICE " +
            "from BOOK where BOOKID=?";

    private JdbcTemplate template;

    @Autowired
    public BookDao(JdbcTemplate template) {
        super();
        this.template = template;
    }

    // Operation 1
    // Find total number of books

    public int getNumberOfBooks() {

        return template.queryForObject(
                QUERY_FOR_BOOK_COUNT,
                Integer.class);
    }

    // Operation 2
    // Find book name using book ID

    public String getBookNameById(int bookId) {

        return template.queryForObject(
                QUERY_FOR_BOOKNAME_BYID,
                String.class,
                new Object[] { bookId });
    }

    // Operation 3
    // Find complete book details

    public BookBO getAllBookById(int bookId) {

        return template.queryForObject(
                QUERY_FOR_ALLDETAIL_BYID,
                new Object[] { bookId },
                new BookMapper());
    }
}