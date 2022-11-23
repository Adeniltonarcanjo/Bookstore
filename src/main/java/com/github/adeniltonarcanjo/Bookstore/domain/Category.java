package com.github.adeniltonarcanjo.Bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Category implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "mandatory NAME field")
    @Length(min=3,max=100, message = "NAME must be between 3 and 100 characters")
    private String name;

    @NotEmpty(message = "mandatory DESCRIPTION field")
    @Length(min=3,max=200, message = "DESCRIPTION must be between 3 and 200 characters")
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();


    public Category() {}

    public Category(Integer id, String nome, String descricao) {
        this.id = id;
        this.name = nome;
        this.description = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category categoria = (Category) o;
        return getId().equals(categoria.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
