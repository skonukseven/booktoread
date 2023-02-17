package com.booktoread.domain;


import com.backend.library.dto.BookDtoForNewRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonIgnore
    private Category category;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @JsonIgnore
    private Author authors;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    @JsonIgnore
    private Publisher publishers;

    @Size(min = 2, max = 100, message = "Size is exceeded. Min 2 and Max 100 char")
    @NotNull(message = "Please enter the book name")
    @Column(length = 100, nullable = false)
    private String name;

    @Size(max = 17, message = "Serial Number is exceeded . Max 100 char")
    @NotNull(message = "Please enter the Serial Number of the book")
    @Column(length = 17, nullable = false)
    private String isbn;

    @NotNull(message = "Please enter the total page number of the book ")
    @Column(nullable = false)
    private Integer pageCount;


    @NotNull(message = "Please enter the Published Date of the book. ex: 1950, only year")
    @Column(nullable = false)
    private Integer publishDate;

    @Column(length = 64)
    private String image;

    private Boolean loanable = true;

    @Size(max = 6, message = "Serial Number is exceeded . Max 6 char")
    @NotNull(message = "Please enter the Serial Number of the book")
    @Column(length = 6, nullable = false)
    private String shelfCode;

    private Boolean active = true;

    private Boolean featured = false;

    private LocalDateTime createdDate = LocalDateTime.now();

    private Boolean builtIn = false;


    public Book(Category category, Author authors, Publisher publishers, String name, String isbn,
                Integer pageCount, Integer publishDate, String image, Boolean loanable,
                String shelfCode, Boolean active, Boolean featured, LocalDateTime createdDate, Boolean builtIn) {
        this.category = category;
        this.authors = authors;
        this.publishers = publishers;
        this.name = name;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.publishDate = publishDate;
        this.image = image;
        this.loanable = loanable;
        this.shelfCode = shelfCode;
        this.active = active;
        this.featured = featured;
        this.createdDate = createdDate;
        this.builtIn = builtIn;
    }

    public Category getCategory() {
        return category;
    }


    public Book(Category category,
                Author author,
                Publisher publisher,
                BookDtoForNewRecord bookDtoForNewRecord,
                String fileName) {
        this.category = category;
        this.authors = author;
        this.publishers = publisher;
        this.name = bookDtoForNewRecord.getName();
        this.isbn = bookDtoForNewRecord.getIsbn();
        this.pageCount = bookDtoForNewRecord.getPageCount();
        this.publishDate = bookDtoForNewRecord.getPublishDate();
        this.image = fileName;
        this.loanable = bookDtoForNewRecord.getLoanable();
        this.shelfCode = bookDtoForNewRecord.getShelfCode();
        this.active = bookDtoForNewRecord.getActive();
        this.featured = bookDtoForNewRecord.getFeatured();
        this.createdDate = LocalDateTime.now();
        this.builtIn = bookDtoForNewRecord.getBuiltIn();
    }
}
