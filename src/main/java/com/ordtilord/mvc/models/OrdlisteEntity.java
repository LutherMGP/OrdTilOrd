package com.ordtilord.mvc.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Ordliste")
public class OrdlisteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordliste_id")
    private Long ordlisteId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profil_id", nullable = false)
    private ProfilEntity profil;

    @OneToMany(mappedBy = "ordliste", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrdEntity> ord;
}
