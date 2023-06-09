package digital.patron.patronnativebackend.member.domain;

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
public class MemberSeenArtwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artwork_id")
    private Artwork artwork;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "general_member_id")
    private GeneralMember generalMember;

    private LocalDate viewLastTime;

    public MemberSeenArtwork(LocalDate viewLastTime){this.viewLastTime = viewLastTime;}

    public void setArtwork(Artwork artwork){this.artwork = artwork;}

    public void setGeneralMember(GeneralMember generalMember){this.generalMember = generalMember;}

    protected MemberSeenArtwork(){}
}
