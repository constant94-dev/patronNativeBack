package digital.patron.patronnativebackend.exhibition.domain;

import digital.patron.patronnativebackend.integrate.domain.ArtistExhibition;
import digital.patron.patronnativebackend.integrate.domain.ArtworkExhibition;
import digital.patron.patronnativebackend.member.domain.MemberWaitingExhibition;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
public class Exhibition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String code;

    @Column(nullable = false, length = 100)
    private String localization;

    @Column(nullable = false, length = 10)
    private String type;

    @Column(nullable = false, length = 500)
    private String docent;

    @Column(nullable = false)
    private Integer numberOfLikes;

    @Column(nullable = false)
    private Integer numberOfViews;

    @Column(nullable = false)
    private Integer numberOfShares;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "exhibition")
    @OrderBy("exhibitionTag.id asc")
    private Set<ExhibitionExhibitionTag> exhibitionExhibitionTags = new HashSet<>();

    @OneToMany(mappedBy = "exhibition")
    private Set<ExhibitionExhibitionGroup> exhibitionExhibitionGroups = new HashSet<>();

    @OneToMany(mappedBy = "exhibition")
    @OrderBy("id asc")
    private Set<ArtistExhibition> artistExhibitions = new HashSet<>();

    @OneToMany(mappedBy = "exhibition")
    private Set<MemberWaitingExhibition> memberWaitingExhibitions = new HashSet<>();

    @OneToMany(mappedBy = "exhibition")
    @OrderBy("id asc")
    private Set<ArtworkExhibition> artworkExhibitions = new HashSet<>();

    @OneToMany(mappedBy = "exhibition")
    private Set<ExhibitionDetail> exhibitionDetails = new HashSet<>();

    protected Exhibition(){}
}