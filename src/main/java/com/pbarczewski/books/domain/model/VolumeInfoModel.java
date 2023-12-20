package com.pbarczewski.books.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VolumeInfoModel {

    private String isbn;

    private String title;

    private String subtitle;

    private String publisher;

    private String thumbnailUrl;

    private String language;

    private String previewLink;

    private String description;

    private Long publishedDate;

    private Integer pageCount;

    private Double averageRating;

    private List<String> authors;

    private List<String> categories;
}
