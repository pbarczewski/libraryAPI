package com.pbarczewski.books.infrastructure.mapper;

import com.pbarczewski.books.domain.model.VolumeInfoModel;
import com.pbarczewski.books.infrastructure.model.ItemEntity;
import com.pbarczewski.books.infrastructure.model.VolumeInfo;
import lombok.experimental.UtilityClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class BookMapper {

    public static VolumeInfoModel convertToVolumeInfoModel(ItemEntity itemEntity, String category) {
        VolumeInfo volumeInfo = itemEntity.getVolumeInfo();
        if(category == null || (volumeInfo.getCategories() != null && volumeInfo.getCategories().contains(category))) {
            return VolumeInfoModel.builder()
                .isbn(getIsbn(itemEntity))
                .title(volumeInfo.getTitle())
                .subtitle(volumeInfo.getSubtitle())
                .publisher(volumeInfo.getPublisher())
                .thumbnailUrl(volumeInfo.getThumbnailUrl())
                .language(volumeInfo.getLanguage())
                .previewLink(volumeInfo.getPreviewLink())
                .description(volumeInfo.getDescription())
                .publishedDate(volumeInfo.getPublishedDate() != null ? parseDateToLong(volumeInfo.getPublishedDate()) : null)
                .pageCount(volumeInfo.getPageCount())
                .averageRating(volumeInfo.getAverageRating())
                .authors(volumeInfo.getAuthors())
                .categories(volumeInfo.getCategories())
                .build();
        }
        return null;
    }

    private Long parseDateToLong(String publishedDate) {
        List<String> dateFormatList = Arrays.asList("yyyy", "yyyy-mm", "yyyy-mm-dd");
        for (String dateFormat : dateFormatList) {
            try {
                LocalDate localDate = LocalDate.parse(publishedDate, DateTimeFormatter.ofPattern(dateFormat));
                return localDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private String getIsbn(ItemEntity itemEntity) {
        String isbn  = itemEntity.getId();

        if(!itemEntity.getVolumeInfo().getIndustryIdentifiers().isEmpty()) {
            isbn = itemEntity.getVolumeInfo().getIndustryIdentifiers()
                .stream()
                .filter(x -> "ISBN_13".equals(x.getType()))
                .map(VolumeInfo.IndustryIdentifiers::getIdentifier)
                .findFirst().orElse(isbn);
        }
        return isbn;
    }

}
