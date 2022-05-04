package repository.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "work_info")
public class WorkInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "do_you_have_work")
    private Boolean DoYouHaveWork;

    @Column(name = "why_you_dont_have_work")
    private Boolean WhyYouDontHaveWork;

    @Column(name = "location_of_work")
    private Integer LocationOfWork;

    @Column(name = "region_or_district_name")
    private String RegionOrDistrictName;

    @Column(name = "city_or_pgt_name")
    private String CityOrPGTName;

    @Column(name = "is_it_village")
    private Boolean IsItVillage;

    @Column(name = "name_of_country")
    private String NameOfCountry;

    @Column(name = "departure_frequency_to_work")
    private Integer DepartureFrequencyToWork;

    @Column(name = "unemployment_reason")
    private Integer UnemploymentReason;

    @Column(name = "type_of_workplace")
    private Integer TypeOfWorkplace;

    @Column(name = "type_of_work_position")
    private Integer TypeOfWorkPosition;

    @Column(name = "did_you_looked_for_a_job")
    private Boolean DidYouLookedForAJob;

    @Column(name = "can_you_star_working_in_two_weeks")
    private Boolean CanYouStarWorkingInTwoWeeks;

    @Column(name = "why_you_cant_work_or_stopped_search")
    private Integer WhyYouCantWorkOrStoppedSearch;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Person personInWorkInfo;
}
