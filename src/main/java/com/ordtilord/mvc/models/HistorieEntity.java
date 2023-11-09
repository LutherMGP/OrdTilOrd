package com.ordtilord.mvc.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Historie")
public class HistorieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historieId;
    private String tekst;
    private String kategori; // Lille, Mellem, Stor
    private Date oprettelsesdato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bruger_id")
    private BrugerEntity bruger;

    @OneToMany(mappedBy = "historie", cascade = CascadeType.ALL)
    private List<InputDataEntity> inputData;

    @OneToMany(mappedBy = "historie", cascade = CascadeType.ALL)
    private List<FeedbackEntity> feedbacks;
}

