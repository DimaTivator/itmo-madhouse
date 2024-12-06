package org.dimativator.itmomadhouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "cw_treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id", nullable = false)
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

    @Column(name = "date", nullable = false)
    private java.time.LocalDate date;
}
