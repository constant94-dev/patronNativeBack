package digital.patron.patronnativebackend.member.domain;

import digital.patron.patronnativebackend.artwork.domain.Artwork;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "kt_member_likes_artwork_relation")
public class MemberLikedArtwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artwork_id")
    private Artwork artwork;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "general_member_id")
    private GeneralMember generalMember;

    public void setArtwork(Artwork artwork){this.artwork = artwork;}

    public void setGeneralMember(GeneralMember generalMember){this.generalMember = generalMember;}

    protected MemberLikedArtwork(){}
}
