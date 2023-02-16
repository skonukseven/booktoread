package com.booktoread.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="tbl_categories")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable= false)
    private String name;

    @Column(nullable= false)
    private Boolean builtIn=false;

    @Column(nullable= false)
    private Integer sequence;

   // @OneToMany (mappedBy = "categoryId")
    private List<Book> books;

}
