package digital.patron.patronnativebackend.member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
public class SearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "general_member_id")
    private GeneralMember generalMember;

    @Column(nullable = true, length = 50)
    private String keyword;

    public SearchHistory(String keyword){this.keyword = keyword;}

    public void setGeneralMember(GeneralMember generalMember){this.generalMember = generalMember;}
    protected SearchHistory(){}
}
