package com.pbarczewski.books.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageLinks {
    private String smallThumbnail;
    private String thumbnail;
}
