INSERT INTO cw_faculty (name) VALUES ('Faculty of Medicine');
INSERT INTO cw_faculty (name) VALUES ('Faculty of Engineering');
INSERT INTO cw_faculty (name) VALUES ('Faculty of Science');

INSERT INTO cw_role (name) VALUES ('Admin'), ('Doctor'), ('Patient');

INSERT INTO cw_user (login, password, role_id) VALUES ('admin_user', 'admin_pass', 1),
('dr_strange', 'magic123', 2),
('john_doe', 'password', 3);

INSERT INTO cw_user (login, password, role_id) VALUES ('aaaaaaaaa', 'aaaaaaaaa', 1),
('bbbbbbbbbb', 'bbbbbbbbbb', 2),
('ccccccccc', 'ccccccccc', 3);

INSERT INTO cw_disease (name, description) VALUES
('Flu', 'A viral infection affecting the respiratory system'),
('Magic Flu', 'A magical infection that affects the spellcasting ability'), ('Diabetes', 'A chronic condition that affects the way the body processes blood sugar (glucose)');


INSERT INTO cw_doctor (name, date_of_birth, specialisation, faculty_id, user_id) VALUES ('Dr. John Smith', '1975-07-15', 'General Medicine', 1, 4),
('Dr. Sarah Magic', '1982-04-22', 'Magic Healing', 2, 5),
('Dr. William Stone', '1988-01-05', 'Endocrinology', 3, 6);

INSERT INTO cw_patient_group (doctor_id, specialisation) VALUES (7, 'General Treatment'),
(5, 'Magic Therapy'),
(6, 'Endocrine Treatment');


INSERT INTO cw_patient (name, date_of_birth, doctor_id, disease_id, patient_group_id, user_id) VALUES
('John Doe', '1990-05-01', 5, 1, 10, 7);


INSERT INTO cw_artifact (name, effect) VALUES
('Magic Wand', 'Boosts spell accuracy'),
('Crystal Ball', 'Enhances vision for future events'), ('Medical Scanner', 'Analyzes patient health instantly');

INSERT INTO cw_spell (name, effect) VALUES ('Healing Spell', 'Restores health'), ('Freezing Spell', 'Freezes the target'), ('Fireball Spell', 'Burns the target');

INSERT INTO cw_creature (name) VALUES ('Dragon'), ('Phoenix'), ('Giant Spider');

INSERT INTO cw_group_therapy (patient_group_id, artifact_id, creature_id, spell_id, therapy_date) VALUES
(10, 3, NULL, NULL, '2024-05-01');


INSERT INTO Creature (Name) VALUES ('Dragon'),
('Phoenix'),
('Giant Spider');
