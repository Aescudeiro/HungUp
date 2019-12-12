package org.academiadecodigo.thunderstructs.dto;

import java.util.List;

public class CompanyDTO {

    private Integer id;
    private String name;
    private List<ReviewDTO> reviews;

    public void setReviews(List<ReviewDTO> reviews) {
        this.reviews = reviews;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
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
}
