package digital.patron.patronnativebackend.member.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class GeneralMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 10)
    private String status;

    @Column(nullable = false, length = 300)
    private String publicWallet;

    @Column(nullable = false, length = 20)
    private String nationality;

    @Column(nullable = false, length = 10)
    private String gender;

    @Column(nullable = false, length = 300)
    private String password;

    @Column(nullable = false, length = 20)
    @ColumnDefault("")
    private String mailAuthKey;

    @Column(nullable = false, length = 10)
    @ColumnDefault("Y")
    private String isMailCertified;

    @Column(nullable = false, length = 10)
    private String provider;

    @Column(nullable = false, length = 50)
    private String preferredLanguage;

    @Column(nullable = false, length = 1)
    private Boolean tutorialCheck;

    @Column(nullable = false, length = 1)
    private Boolean marketing;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false)
    private LocalDateTime lastLogin;

    @OneToMany(mappedBy = "generalMember")
    private Set<Collection> collections = new HashSet<>();
    @OneToMany(mappedBy = "generalMember")
    private Set<MemberSeenArtwork> memberSeenArtworks = new HashSet<>();
    @OneToMany(mappedBy = "generalMember")
    private Set<MemberLikedArtwork> memberLikedArtworks = new HashSet<>();
    @OneToMany(mappedBy = "generalMember")
    private Set<MemberLikedArtist> memberLikedArtists = new HashSet<>();
    @OneToMany(mappedBy = "generalMember")
    private Set<MemberWaitingExhibition> memberWaitingExhibitions = new HashSet<>();
    @OneToMany(mappedBy = "generalMember")
    private Set<SearchHistory> searchHistories = new HashSet<>();

    public GeneralMember(String email, String name, String status,
                         String public_wallet, LocalDate birth, String nationality,
                         String preferredLanguage, String gender, String provider,
                         boolean marketing, boolean tutorial_check, String password,
                         LocalDateTime last_login) {
        this.email = email;
        this.name = name;
        this.status = status;
        this.publicWallet = public_wallet;
        this.birth = birth;
        this.nationality = nationality;
        this.preferredLanguage = preferredLanguage;
        this.gender = gender;
        this.provider = provider;
        this.marketing = marketing;
        this.tutorialCheck = tutorial_check;
        this.password = password;
        this.lastLogin = last_login;
    }
}
