package digital.patron.patronnativebackend.exhibition.service;

import digital.patron.patronnativebackend.exhibition.domain.Exhibition;

import java.util.List;

public interface ExhibitionService {
    List<Exhibition> findExhibitionsByGroupName(String groupName, String localization, String language);
    Exhibition findExhibitionByGroupName(String groupName, String localization, String language);
}
