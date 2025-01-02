-- Assign Magical Therapy to Patient
CREATE OR REPLACE PROCEDURE assign_therapy(
    p_patient_id BIGINT,
    p_doctor_id BIGINT,
    p_artifact_id BIGINT,
    p_spell_id BIGINT,
    p_creature_id BIGINT,
    p_treatment_date DATE
) AS $$
BEGIN
    INSERT INTO cw_treatment (patient_id, doctor_id, artifact_id, spell_id, creature_id, treatment_date, updated_at)
    VALUES (p_patient_id, p_doctor_id, p_artifact_id, p_spell_id, p_creature_id, p_treatment_date, NOW());
    -- RAISE NOTICE 'Therapy assigned to patient %', p_patient_id;
END;
$$ LANGUAGE plpgsql;


CALL assign_therapy(12, 5, 1, 1, 1, '2024-01-01');


-- Discharge Patient
CREATE OR REPLACE PROCEDURE discharge_patient(
    p_patient_id INT,
    p_doctor_id INT,
    p_recovery_report TEXT
) AS $$
BEGIN
    -- Update patient status to discharged
    -- UPDATE cw_patient
    -- SET status = 'Discharged' WHERE id = p_patient_id;
    -- Save recovery report
    INSERT INTO cw_discharge_report (patient_id, doctor_id, report) VALUES (p_patient_id, p_doctor_id, p_recovery_report);
    -- RAISE NOTICE 'Patient % has been discharged', p_patient_id; 
END;
$$ LANGUAGE plpgsql;


CALL discharge_patient(12, 5, 'Recovery report');