CREATE TYPE pr_sex as ENUM (
    'MALE', 'FEMALE'
    );

CREATE TABLE pr_user
(
    user_id  SERIAL PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE pr_role
(
    role_id SERIAL PRIMARY KEY,
    name    VARCHAR(100)
);

CREATE TABLE pr_user_role
(
    user_id INTEGER,
    role_id INTEGER
);

CREATE TABLE pr_person
(
    person_id        SERIAL PRIMARY KEY,
    name             VARCHAR(50),
    surname          VARCHAR(100),
    sex              pr_sex,
    birth_date       TIMESTAMP,
    birth_place      VARCHAR(255),
    address          VARCHAR(255),
    telephone_number VARCHAR(13)
);

CREATE TABLE pr_student
(
    student_id         INTEGER PRIMARY KEY,
    book_number        VARCHAR(20),
    note               VARCHAR(150)
);

CREATE TABLE pr_student_group
(
    student_group_id SERIAL PRIMARY KEY,
    group_id   INTEGER,
    student_id INTEGER,
    putting_date TIMESTAMP
);

CREATE TABLE pr_groups
(
    group_id          SERIAL PRIMARY KEY,
    group_code        VARCHAR(10),
--   Yarik
    speciality_id     INTEGER,
    group_create_date TIMESTAMP
);

CREATE TABLE pr_student_marks
(
    student_mark_id SERIAL PRIMARY KEY,
    student_id      INTEGER,
    teacher_plan_id INTEGER,
    mark_id         INTEGER
);

CREATE TABLE pr_mark
(
    mark_id    SERIAL PRIMARY KEY,
    mark_value INTEGER
);

CREATE TABLE pr_teacher_plan
(
    teacher_plan_id SERIAL PRIMARY KEY,
    semester_id     INTEGER,
    group_id        INTEGER,
    subject_id      INTEGER,
    tester_id       INTEGER NOT NULL,
    test_kind_id    INTEGER NOT NULL,
    test_date       TIMESTAMP,
    obligatory      BOOLEAN
);

CREATE TABLE pr_lesson
(
    lesson_id      SERIAL PRIMARY KEY,
    lesson_kind_id INTEGER NOT NULL,
    teacher_plan_id INTEGER NOT NULL,
    teacher_id     INTEGER NOT NULL NOT NULL,
    hours          INTEGER
);

CREATE TABLE pr_lesson_kind
(
    lesson_kind_id   SERIAL PRIMARY KEY,
    lesson_kind_name VARCHAR(100)
);

CREATE TABLE pr_test_kind
(
    test_kind_id SERIAL PRIMARY KEY,
    test_name    VARCHAR(100)
);

CREATE TABLE pr_subject
(
    subject_id    SERIAL PRIMARY KEY,
    subject_name  VARCHAR(50) NOT NULL,
    subject_shifr VARCHAR(20) NOT NULL
);

CREATE TABLE pr_semester
(
    semester_id        SERIAL PRIMARY KEY,
    teach_begin_date   TIMESTAMP NOT NULL,
    teach_end_date     TIMESTAMP NOT NULL,
    session_begin_date TIMESTAMP,
    session_end_date   TIMESTAMP,
    attest1_date       TIMESTAMP,
    attest2_date       TIMESTAMP
);

CREATE TABLE pr_violation
(
    violation_id      SERIAL PRIMARY KEY,
    violation_kind_id INTEGER,
    punish_kind_id    INTEGER,
    violation_date    TIMESTAMP,
    person_id         INTEGER,
    order_id          INTEGER
);

CREATE TABLE pr_violation_kind
(
    violation_kind_id   SERIAL PRIMARY KEY,
    violation_kind_name VARCHAR(50)
);

CREATE TABLE pr_punish_kind
(
    punish_kind_id   SERIAL PRIMARY KEY,
    punish_kind_name VARCHAR(50)
);

CREATE TABLE pr_order
(
    order_id      SERIAL PRIMARY KEY,
    order_kind_id INTEGER,
    order_date    TIMESTAMP,
    order_no      INTEGER,
    order_text    VARCHAR(250)
);

CREATE TABLE pr_order_kind
(
    order_kind_id   SERIAL PRIMARY KEY,
    order_kind_name VARCHAR(50)
);

CREATE TABLE pr_privilege
(
    privilege_id   SERIAL PRIMARY KEY,
    privilege_name VARCHAR(50)
);

CREATE TABLE pr_person_privilege
(
    person_privilege_id SERIAL PRIMARY KEY,
    privilege_id    INTEGER,
    person_id       INTEGER,
    priv_begin_date TIMESTAMP,
    priv_end_date   TIMESTAMP,
    ground          VARCHAR(200)
);

CREATE TABLE pr_speciality
(
    speciality_id    SERIAL PRIMARY KEY,
    speciality_name  VARCHAR(50),
    cafedra_id       INTEGER,
    speciality_shifr VARCHAR(20) NOT NULL
);

CREATE TABLE pr_cafedra
(
    cafedra_id    SERIAL PRIMARY KEY,
    cafedra_name  VARCHAR(50),
    cafedra_shifr VARCHAR(20) NOT NULL
);

ALTER TABLE ONLY pr_person_privilege
    ADD CONSTRAINT fk_pr_person_privilege FOREIGN KEY (person_id) REFERENCES pr_person (person_id);
ALTER TABLE ONLY pr_person_privilege
    ADD CONSTRAINT fk_pr_privilege_person FOREIGN KEY (privilege_id) REFERENCES pr_privilege (privilege_id);

ALTER TABLE ONLY pr_groups
    ADD CONSTRAINT fk_pr_groups_speciality FOREIGN KEY (speciality_id) REFERENCES pr_speciality (speciality_id);
ALTER TABLE ONLY pr_speciality
    ADD CONSTRAINT fk_pr_speciality_cafedra FOREIGN KEY (cafedra_id) REFERENCES pr_cafedra (cafedra_id);

ALTER TABLE ONLY pr_violation
    ADD CONSTRAINT fk_violation_kind FOREIGN KEY (violation_kind_id) REFERENCES pr_violation_kind (violation_kind_id);
ALTER TABLE ONLY pr_violation
    ADD CONSTRAINT fk_punish_kind FOREIGN KEY (punish_kind_id) REFERENCES pr_punish_kind (punish_kind_id);
ALTER TABLE ONLY pr_violation
    ADD CONSTRAINT fk_violation_person_id FOREIGN KEY (person_id) REFERENCES pr_person (person_id);
ALTER TABLE ONLY pr_violation
    ADD CONSTRAINT fk_violation_order_id FOREIGN KEY (order_id) REFERENCES pr_order (order_id);

ALTER TABLE ONLY pr_order
    ADD CONSTRAINT fk_order_kind_id FOREIGN KEY (order_kind_id) REFERENCES pr_order_kind (order_kind_id);

ALTER TABLE ONLY pr_student
    ADD CONSTRAINT fk_student_person_id FOREIGN KEY (student_id) REFERENCES pr_person (person_id);

ALTER TABLE ONLY pr_student_group
    ADD CONSTRAINT fk_student_group_id FOREIGN KEY (student_id) REFERENCES pr_student (student_id);
ALTER TABLE ONLY pr_student_group
    ADD CONSTRAINT fk_group_student_id FOREIGN KEY (group_id) REFERENCES pr_groups (group_id);

ALTER TABLE ONLY pr_student_marks
    ADD CONSTRAINT fk_marks_student_id FOREIGN KEY (mark_id) REFERENCES pr_mark (mark_id);
ALTER TABLE ONLY pr_student_marks
    ADD CONSTRAINT fk_student_marks_id FOREIGN KEY (student_id) REFERENCES pr_student (student_id);
ALTER TABLE ONLY pr_student_marks
    ADD CONSTRAINT fk_marks_teacher_plan_id FOREIGN KEY (teacher_plan_id) REFERENCES pr_teacher_plan (teacher_plan_id);

ALTER TABLE ONLY pr_teacher_plan
    ADD CONSTRAINT fk_teacher_plan_semestr_id FOREIGN KEY (semester_id) REFERENCES pr_semester (semester_id);
ALTER TABLE ONLY pr_teacher_plan
    ADD CONSTRAINT fk_teacher_plan_group_id FOREIGN KEY (group_id) REFERENCES pr_groups (group_id);
ALTER TABLE ONLY pr_teacher_plan
    ADD CONSTRAINT fk_teacher_subject_id FOREIGN KEY (subject_id) REFERENCES pr_subject (subject_id);
ALTER TABLE ONLY pr_teacher_plan
    ADD CONSTRAINT fk_teacher_tester_id FOREIGN KEY (tester_id) REFERENCES pr_person (person_id);
ALTER TABLE ONLY pr_teacher_plan
    ADD CONSTRAINT fk_teacher_test_kind_id FOREIGN KEY (test_kind_id) REFERENCES pr_test_kind (test_kind_id);

ALTER TABLE ONLY pr_lesson
    ADD CONSTRAINT fk_lesson_lesson_kind_id FOREIGN KEY (lesson_kind_id) REFERENCES pr_lesson_kind (lesson_kind_id);
ALTER TABLE ONLY pr_lesson
    ADD CONSTRAINT fk_lesson_teacher_plan_id FOREIGN KEY (teacher_plan_id) REFERENCES pr_teacher_plan (teacher_plan_id);

ALTER TABLE ONLY pr_user_role
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES pr_user (user_id);
ALTER TABLE ONLY pr_user_role
    ADD CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES pr_role (role_id);

INSERT INTO pr_role (name)
VALUES ('guest');
INSERT INTO pr_role (name)
VALUES ('admin');

DO '
    BEGIN
        FOR counter IN 60..100 LOOP
                INSERT INTO pr_mark(mark_value) VALUES (counter);
            END LOOP;
    END;
'
LANGUAGE plpgsql;

INSERT INTO pr_lesson_kind (lesson_kind_name)
VALUES ('Lecture');
INSERT INTO pr_lesson_kind (lesson_kind_name)
VALUES ('Practice');

INSERT INTO pr_test_kind (test_name)
VALUES ('Exam');
INSERT INTO pr_test_kind (test_name)
VALUES ('Credit');
