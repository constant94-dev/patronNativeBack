package digital.patron.patronnativebackend.artist.repository.custom;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import digital.patron.patronnativebackend.artist.domain.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static digital.patron.patronnativebackend.artist.domain.QArtist.artist;
import static digital.patron.patronnativebackend.artist.domain.QArtistArtistGroup.artistArtistGroup;
import static digital.patron.patronnativebackend.artist.domain.QArtistGroup.artistGroup;
import static digital.patron.patronnativebackend.artist.domain.QArtistArtistTag.artistArtistTag;
import static digital.patron.patronnativebackend.artist.domain.QArtistTag.artistTag;
import static digital.patron.patronnativebackend.artist.domain.QArtistDetail.artistDetail;

public class ArtistGroupRepositoryImpl implements ArtistGroupRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    public ArtistGroupRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Page<Artist> findArtistsByArtistGroupNameOrderByArtistArtistGroupIdAsc(String localization, Pageable pageable) {
        QueryResults<Artist> result = jpaQueryFactory
                .select(artist)
                .from(artistGroup)
                .join(artistGroup.artistArtistGroups, artistArtistGroup)
                .join(artistArtistGroup.artist, artist)
                .where(artistGroup.localization.contains(localization)
                        .and(artist.localization.contains(localization)))
                .orderBy(artistArtistGroup.id.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(result.getResults(),pageable,result.getTotal());
    }
}
