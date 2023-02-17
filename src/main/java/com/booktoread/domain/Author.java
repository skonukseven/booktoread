package com.booktoread.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4, max = 70, message = "Author Name is exceeded. Min 4 and max 70 char")
    @NotNull(message = "Please enter the Author name")
    @Column(length = 70, nullable = false)
    private String name;

    @OneToMany(mappedBy = "authors", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

    @Column(nullable = false)
    private boolean builtIn = false;

}