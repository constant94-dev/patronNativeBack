package digital.patron.patronnativebackend.exhibition.repository.custom;

import digital.patron.patronnativebackend.exhibition.domain.Exhibition;

import java.util.List;

public interface ExhibitionGroupRepositoryCustom {
    List<Exhibition> findExhibitionsByExhibitionGroupNameAndLocalization(String groupName, String localization);
}
