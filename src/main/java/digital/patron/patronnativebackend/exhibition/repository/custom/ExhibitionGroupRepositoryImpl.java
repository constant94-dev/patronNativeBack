package digital.patron.patronnativebackend.exhibition.repository.custom;

import digital.patron.patronnativebackend.exhibition.domain.Exhibition;

import java.util.List;

public class ExhibitionGroupRepositoryImpl implements ExhibitionGroupRepositoryCustom{

    @Override
    public List<Exhibition> findExhibitionsByExhibitionGroupNameAndLocalization(String groupName, String localization) {
        return null;
    }
}
