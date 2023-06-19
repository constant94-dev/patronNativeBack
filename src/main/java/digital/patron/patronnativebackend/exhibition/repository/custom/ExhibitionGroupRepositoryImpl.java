package digital.patron.patronnativebackend.exhibition.repository.custom;

import com.querydsl.jpa.impl.JPAQueryFactory;
import digital.patron.patronnativebackend.common.JpaQueryFactoryConfig;
import digital.patron.patronnativebackend.exhibition.domain.Exhibition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExhibitionGroupRepositoryImpl implements ExhibitionGroupRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public ExhibitionGroupRepositoryImpl(JpaQueryFactoryConfig jpaQueryFactoryConfig){
        this.jpaQueryFactory = jpaQueryFactoryConfig.JpaQueryFactoryConfig();
    }

    @Override
    public List<Exhibition> findExhibitionsByExhibitionGroupNameAndLocalization(String groupName, String localization) {
        return null;
    }
}
