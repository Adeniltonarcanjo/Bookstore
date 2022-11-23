package com.github.adeniltonarcanjo.Bookstore.dtos;

import com.github.adeniltonarcanjo.Bookstore.domain.Category;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "mandatory NAME field")
    @Length(min=3,max=100, message = "NAME must be between 3 and 100 characters")
    private String name;

    @NotEmpty(message = "mandatory DESCRIPTION field")
    @Length(min=3,max=200, message = "DESCRIPTION must be between 3 and 200 characters")
    private String description;

    public CategoryDTO() {
        super();
    }

    public CategoryDTO(Category obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
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
}
