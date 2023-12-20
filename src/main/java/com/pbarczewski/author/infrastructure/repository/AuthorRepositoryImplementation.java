package com.pbarczewski.author.infrastructure.repository;

import com.pbarczewski.author.domain.AuthorRepositoryInterface;
import com.pbarczewski.author.domain.model.AuthorModel;
import com.pbarczewski.books.infrastructure.model.ItemEntity;
import com.pbarczewski.data.JsonDataMapper;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Repository
public class AuthorRepositoryImplementation implements AuthorRepositoryInterface {

    private List<ItemEntity> itemEntities = JsonDataMapper.INSTANCE.readData();

    @Override
    public List<AuthorModel> getAuthorModelList() {
       List<AuthorModel> authorModelList = null;
        try {
            Map<String, Double> averageRatingByAuthor = itemEntities.stream()
                .filter(x -> x.getVolumeInfo().getAuthors() != null)
                .flatMap(x -> x.getVolumeInfo().getAuthors().stream()
                    .map(author -> Map.entry(author, x.getVolumeInfo().getAverageRating())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                    Collectors.averagingDouble(Map.Entry::getValue)));
             authorModelList = averageRatingByAuthor.entrySet().stream().map(entry -> AuthorModel
                .builder()
                .name(entry.getKey())
                .averageRating(entry.getValue()).build()).collect(Collectors.toList()).stream().sorted(Comparator.comparing(AuthorModel::getAverageRating).reversed()).collect(Collectors.toList());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return authorModelList;
    }


}
