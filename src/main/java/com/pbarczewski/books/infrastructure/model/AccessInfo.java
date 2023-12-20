package com.pbarczewski.books.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessInfo {

    private String country;

    private String viewability;

    private Boolean embeddable;

    private Boolean publicDomain;

    private String textToSpeechPermission;

    private Epub epub;

    private Pdf pdf;

    private String webReaderLink;

    private String accessViewStatus;

    private Boolean quoteSharingAllowed;


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private class Epub {
        private Boolean isAvailable;
        private String acsTokenLink;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private class Pdf {
        private Boolean isAvailable;
        private String acsTokenLink;
        private String downloadLink;
    }
}
