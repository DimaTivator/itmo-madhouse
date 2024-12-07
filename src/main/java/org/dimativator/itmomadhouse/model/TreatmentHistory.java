package org.dimativator.itmomadhouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "cw_treatment_history")
public class TreatmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artifact_id")
    private Artifact artifact;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creature_id")
    private Creature creature;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spell_id")
    private Spell spell;

    @Column(name = "treatment_date", nullable = false)
    private LocalDateTime treatmentDate;

    @Column(name = "logged_at", nullable = false, updatable = false, insertable = false)
    private LocalDateTime loggedAt;
}
