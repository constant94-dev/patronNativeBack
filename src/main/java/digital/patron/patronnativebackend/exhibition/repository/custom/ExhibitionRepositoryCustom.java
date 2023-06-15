package digital.patron.patronnativebackend.exhibition.repository.custom;

import digital.patron.patronnativebackend.exhibition.domain.Exhibition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExhibitionRepositoryCustom {
    Page<Exhibition> findExhibitionsByKeyword(String keyword, String localization, Pageable pageable);

    Page<Exhibition> getAllExhibitionsSortedByParameter(String sortBy, String localization, Pageable pageable);

    Exhibition findByLocalization(Long id, String localization);
}
