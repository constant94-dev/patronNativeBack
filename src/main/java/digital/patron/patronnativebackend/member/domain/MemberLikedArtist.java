package digital.patron.patronnativebackend.member.domain;

import digital.patron.patronnativebackend.artist.domain.Artist;
import digital.patron.patronnativebackend.artwork.domain.Artwork;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "kt_member_views_artwork_relation")
public class MemberLikedArtist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "general_member_id")
    private GeneralMember generalMember;

    public void setArtist(Artist artist){this.artist = artist;}

    public void setGeneralMember(GeneralMember generalMember){this.generalMember = generalMember;}

    protected MemberLikedArtist(){}
}
