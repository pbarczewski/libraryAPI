package com.pbarczewski.books.infrastructure.model;

import lombok.Data;

@Data
public class ItemEntity {

    private String kind;

    private String id;

    private String etag;

    private String selfLink;

    private VolumeInfo volumeInfo;

    private SaleInfo saleInfo;

    private AccessInfo accessInfo;

    private SearchInfo searchInfo;

}
