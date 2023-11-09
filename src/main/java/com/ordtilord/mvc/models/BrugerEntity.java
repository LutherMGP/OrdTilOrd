package com.ordtilord.mvc.models;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Bruger")
public class BrugerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brugerId;
    private String navn;
    private String email;
    private String password; // Husk at kryptere passwords i produktion

    @OneToOne(mappedBy = "bruger", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private ProfilEntity profil;

    @OneToMany(mappedBy = "bruger", cascade = CascadeType.ALL)
    private List<HistorieEntity> historier;

    @OneToMany(mappedBy = "bruger", cascade = CascadeType.ALL)
    private List<FeedbackEntity> feedbacks;

    @OneToMany(mappedBy = "bruger", cascade = CascadeType.ALL)
    private List<InputDataEntity> inputData;

    @OneToMany(mappedBy = "bruger", cascade = CascadeType.ALL)
    private List<BrugerInteresseEntity> brugerInteresser;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "bruger_roles",
            joinColumns = @JoinColumn(name = "bruger_id", referencedColumnName = "brugerId"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId")
    )
    private List<RoleEntity> roles = new ArrayList<>();

    // Hjælpemetode til at tilføje en rolle til brugeren
    public void addRole(RoleEntity role) {
        this.roles.add(role);
    }
}

