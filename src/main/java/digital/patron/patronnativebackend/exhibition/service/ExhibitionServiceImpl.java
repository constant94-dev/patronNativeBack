package digital.patron.patronnativebackend.exhibition.service;

import digital.patron.patronnativebackend.exhibition.domain.Exhibition;
import digital.patron.patronnativebackend.exhibition.repository.ExhibitionGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExhibitionServiceImpl implements ExhibitionService {
    private final ExhibitionGroupRepository exhibitionGroupRepository;

    @Override
    public List<Exhibition> findExhibitionsByGroupName(String groupName, String localization, String language) {
        List<Exhibition> exhibitionList = exhibitionGroupRepository.findExhibitionsByExhibitionGroupNameAndLocalization(groupName, localization);
        if(!groupName.equals("전시그룹")){
            exhibitionListFilterByLocalization(exhibitionList, localization);
        }
        return exhibitionList;
    }

    private void exhibitionListFilterByLocalization(List<Exhibition> exhibitionList, String localization) {
        if (exhibitionList != null && exhibitionList.size() != 0){
            for (Exhibition exhibition : exhibitionList){
                exhibition.getArtworkExhibitions().removeIf(artworkExhibition -> !artworkExhibition.getArtwork().getLocalization().contains(localization));
            }
        }
    }
}
