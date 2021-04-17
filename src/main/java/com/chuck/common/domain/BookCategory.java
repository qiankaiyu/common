package com.chuck.common.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.chuck.common.domain.Book;

import lombok.Data;

/**
 * 
 * @author Chuck
 * @since 2021年4月9日
 * @version 0.0.1
 *
 *
 */
// @Entity
@Table(name = "book_category")
@Data
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_category_id")
    private Set<Book> books;

    public BookCategory() {

    }

    public BookCategory(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Category[id=%d, name='%s']%n", id, name));
        if (books != null) {
            for (Book book : books) {
                sb.append(String.format("Book[id=%d, name='%s']%n", book.getId(), book.getName()));
            }
        }

        return sb.toString();
    }

}
