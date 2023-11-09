package com.ordtilord.mvc.models;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Feedback")
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bruger_id")
    private BrugerEntity bruger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "historie_id")
    private HistorieEntity historie;

    private String kommentar;
    private int rating;
}
