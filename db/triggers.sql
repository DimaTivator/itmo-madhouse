CREATE OR REPLACE FUNCTION log_treatment_history() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO cw_treatment_history (patient_id, doctor_id, artifact_id, creature_id, spell_id, treatment_date)
VALUES (NEW.patient_id, NEW.doctor_id, NEW.artifact_id, NEW.creature_id, NEW.spell_id, NEW.treatment_date);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER treatment_history_trigger AFTER INSERT ON Treatment
FOR EACH ROW
EXECUTE FUNCTION log_treatment_history();


CREATE OR REPLACE FUNCTION update_patient_count_in_doctor() RETURNS TRIGGER AS $$
BEGIN
    -- Увеличиваем количество пациентов при добавлении записи
    IF TG_OP = 'INSERT' THEN 
        UPDATE cw_doctor
        SET patient_count = patient_count + 1
        WHERE id = NEW.doctor_id; 
    END IF;
    -- Уменьшаем количество пациентов при удалении записи
    IF TG_OP = 'DELETE' THEN 
        UPDATE cw_doctor
        SET patient_count = patient_count - 1
        WHERE id = OLD.doctor_id; 
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER patient_count_update_trigger
AFTER INSERT OR DELETE ON cw_treatment
FOR EACH ROW
EXECUTE FUNCTION update_patient_count_in_doctor();

CREATE OR REPLACE FUNCTION update_timestamp() RETURNS TRIGGER AS $$
BEGIN
NEW.UpdatedAt := NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER update_timestamp_trigger BEFORE UPDATE ON cw_treatment
FOR EACH ROW
EXECUTE FUNCTION update_timestamp();