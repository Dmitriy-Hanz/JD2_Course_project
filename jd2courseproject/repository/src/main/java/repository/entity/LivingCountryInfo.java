package repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "living_country_info")
public class LivingCountryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "did_you_live_in_other_country")
    private Boolean DidYouLiveInOtherCountry;

    @Column(name = "name_of_country_you_came_from")
    private String NameOfCountryYouCameFrom;

    @Column(name = "arrival_period")
    private Date ArrivalPeriod;

    @Column(name = "reason_for_arrival_at_rb")
    private Integer ReasonForArrivalAtRB;

    @Column(name = "do_you_want_to_leave_belarus")
    private Integer DoYouWantToLeaveBelarus;

    @Column(name = "reason_for_leave_belarus")
    private Integer ReasonForLeaveBelarus;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Person personInLivingCountryInfo;
}
