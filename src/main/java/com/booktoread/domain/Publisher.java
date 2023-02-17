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
@Table(name = "publishers")
public class Publisher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=2,max = 50,message = "Publisher Name is exceeded. Min 2 and max 50 char")
    @NotNull(message = "Please enter the Publisher name")
    @Column(length = 50,nullable = false)
    private String name;

    @OneToMany(mappedBy = "publishers",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

    @Column(nullable = false)
    private boolean builtIn=false;

}