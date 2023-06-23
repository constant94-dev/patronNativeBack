package digital.patron.patronnativebackend.artwork.repository.custom;

import com.querydsl.jpa.impl.JPAQueryFactory;
import digital.patron.patronnativebackend.artwork.domain.Artwork;

import java.util.List;

import static digital.patron.patronnativebackend.artwork.domain.QArtwork.artwork;
import static digital.patron.patronnativebackend.artwork.domain.QArtworkArtworkGroup.artworkArtworkGroup;
import static digital.patron.patronnativebackend.artwork.domain.QArtworkGroup.artworkGroup;
import static digital.patron.patronnativebackend.artwork.domain.QSound.sound;
import static digital.patron.patronnativebackend.artwork.domain.QSoundSoundTag.soundSoundTag;
import static digital.patron.patronnativebackend.artwork.domain.QSoundTag.soundTag;
import static digital.patron.patronnativebackend.artwork.domain.QContents4k.contents4k;
import static digital.patron.patronnativebackend.artwork.domain.QContentsHd.contentsHd;
import static digital.patron.patronnativebackend.artwork.domain.QContentsThumbnail.contentsThumbnail;


public class ArtworkRepositoryImpl implements ArtworkRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public ArtworkRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Artwork> findArtworksByIsApproveAndIsShowingOrderByRegisteredAtDesc(String localization) {
        return jpaQueryFactory
                .select(artworkArtworkGroup.artwork)
                .from(artworkArtworkGroup)
                .where(artworkArtworkGroup.artwork.approve.eq(true)
                        .and(artworkArtworkGroup.artwork.localization.contains(localization))
                        .and(artworkArtworkGroup.artwork.artist.localization.contains(localization))
                        .and(artworkArtworkGroup.artworkGroup.name.eq("작품그룹"))
                        .and(artworkArtworkGroup.artworkGroup.localization.eq(localization))
                )
                .orderBy(artworkArtworkGroup.id.asc())
                .fetch();
    }
}
