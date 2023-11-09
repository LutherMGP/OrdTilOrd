package com.ordtilord.mvc.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "InputData")
public class InputDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inputId;
    private String tekst;
    private Date datoForInput;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bruger_id")
    private BrugerEntity bruger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "historie_id")
    private HistorieEntity historie;
}
