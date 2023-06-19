package digital.patron.patronnativebackend.member.domain;

import digital.patron.patronnativebackend.exhibition.domain.Exhibition;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
public class Collection {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer sortNumber;

    @Column(nullable = false, length = 100)
    private String name;

    private LocalDateTime updateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "general_member_id")
    private GeneralMember generalMember;

    @OneToMany(mappedBy = "collection")
    private Set<CollectionArtwork> collectionArtworks = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exhibition_id")
    private Exhibition exhibition;

    public Collection(Integer sortNumber, String collectionName, LocalDateTime updateTime) {
        this.sortNumber = sortNumber;
        this.name = collectionName;
        this.updateTime = updateTime;
    }

    protected Collection(){}

}
