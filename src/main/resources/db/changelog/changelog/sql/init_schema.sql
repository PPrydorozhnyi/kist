CREATE TYPE pr_sex as ENUM (
    'MALE', 'FEMALE'
);

CREATE TABLE pr_user (
  user_id SERIAL PRIMARY KEY,
  username VARCHAR(100),
  password VARCHAR(100)
);

CREATE TABLE pr_role (
  role_id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE pr_user_role (
  user_id INTEGER,
  role_id INTEGER
);

CREATE TABLE pr_person (
  person_id SERIAL PRIMARY KEY,
  name VARCHAR(50),
  surname VARCHAR(100),
  sex pr_sex,
  birth_date TIMESTAMP,
  birth_place VARCHAR(255),
  address VARCHAR(255),
  telephone_number VARCHAR(13)
);

CREATE TABLE pr_student(
  student_id SERIAL PRIMARY KEY,
  person_id INTEGER,
  book_number VARCHAR(20),
  note VARCHAR(150),
  group_putting_date TIMESTAMP
);

CREATE TABLE pr_student_group(
  group_id INTEGER,
  student_id INTEGER
);

CREATE TABLE pr_groups(
  group_id SERIAL PRIMARY KEY,
  group_code VARCHAR(10),
  group_create_date TIMESTAMP
);

CREATE TABLE pr_student_marks(
  student_id INTEGER,
  teacher_plan_id INTEGER,
  mark_id INTEGER
);

CREATE TABLE pr_mark(
  mark_id SERIAL PRIMARY KEY,
  mark_name VARCHAR(1)
);

CREATE TABLE pr_teacher_plan(
  teacher_plan_id SERIAL PRIMARY KEY,
  semester_id INTEGER,
  group_id INTEGER,
  subject_id INTEGER,
  tester_id INTEGER,
  test_kind_id INTEGER,
  test_date TIMESTAMP,
  obligatory BOOLEAN
);

CREATE TABLE pr_lesson(
  lesson_id SERIAL PRIMARY KEY,
  lesson_kind_id INTEGER NOT NULL,
  teacher_id INTEGER NOT NULL ,
  hours INTEGER
);

CREATE TABLE pr_lesson_kind(
  lesson_kind_id SERIAL PRIMARY KEY,
  lesson_kind_name VARCHAR(100)
);

CREATE TABLE pr_test_kind(
  test_kind_id SERIAL PRIMARY KEY,
  test_name VARCHAR(100)
);

CREATE TABLE pr_subject(
  subject_id SERIAL PRIMARY KEY,
  subject_name VARCHAR(50) NOT NULL,
  subject_shifr VARCHAR(20) NOT NULL
);

CREATE TABLE pr_semester(
  semester_id SERIAL PRIMARY KEY,
  teach_begin_date TIMESTAMP NOT NULL,
  teach_end_date TIMESTAMP NOT NULL,
  session_begin_date TIMESTAMP,
  session_end_date TIMESTAMP,
  attest1_date TIMESTAMP,
  attest2_date TIMESTAMP
);

ALTER TABLE ONLY pr_student ADD CONSTRAINT fk_student_person_id FOREIGN KEY (person_id) REFERENCES pr_person(person_id);

ALTER TABLE ONLY pr_student_group ADD CONSTRAINT fk_student_group_id FOREIGN KEY (student_id) REFERENCES pr_student(student_id);
ALTER TABLE ONLY pr_student_group ADD CONSTRAINT fk_group_student_id FOREIGN KEY (group_id) REFERENCES pr_groups(group_id);

ALTER TABLE ONLY pr_student_marks ADD CONSTRAINT fk_marks_student_id FOREIGN KEY (mark_id) REFERENCES pr_mark(mark_id);
ALTER TABLE ONLY pr_student_marks ADD CONSTRAINT fk_student_marks_id FOREIGN KEY (student_id) REFERENCES pr_student(student_id);
ALTER TABLE ONLY pr_student_marks ADD CONSTRAINT fk_marks_teacher_plan_id FOREIGN KEY (teacher_plan_id) REFERENCES pr_teacher_plan(teacher_plan_id);

ALTER TABLE ONLY pr_teacher_plan ADD CONSTRAINT fk_teacher_plan_semestr_id FOREIGN KEY (semester_id) REFERENCES pr_semester(semester_id);
ALTER TABLE ONLY pr_teacher_plan ADD CONSTRAINT fk_teacher_plan_group_id FOREIGN KEY (group_id) REFERENCES pr_groups(group_id);
ALTER TABLE ONLY pr_teacher_plan ADD CONSTRAINT fk_teacher_subject_id FOREIGN KEY (subject_id) REFERENCES pr_subject(subject_id);
ALTER TABLE ONLY pr_teacher_plan ADD CONSTRAINT fk_teacher_tester_id FOREIGN KEY (tester_id) REFERENCES pr_person(person_id);
ALTER TABLE ONLY pr_teacher_plan ADD CONSTRAINT fk_teacher_test_kind_id FOREIGN KEY (test_kind_id) REFERENCES pr_test_kind(test_kind_id);

ALTER TABLE ONLY pr_lesson ADD CONSTRAINT fk_lesson_lesson_kind_id FOREIGN KEY (lesson_kind_id) REFERENCES pr_lesson_kind(lesson_kind_id);

ALTER TABLE ONLY pr_user_role ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES pr_user(user_id);
ALTER TABLE ONLY pr_user_role ADD CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES pr_role(role_id);

INSERT INTO pr_role (name) VALUES ('guest');
INSERT INTO pr_role (name) VALUES ('admin');

INSERT INTO pr_mark (mark_name) VALUES ('A');
INSERT INTO pr_mark (mark_name) VALUES ('B');
INSERT INTO pr_mark (mark_name) VALUES ('C');
INSERT INTO pr_mark (mark_name) VALUES ('D');
INSERT INTO pr_mark (mark_name) VALUES ('E');
INSERT INTO pr_mark (mark_name) VALUES ('F');

INSERT INTO pr_lesson_kind (lesson_kind_name) VALUES ('Lecture');
INSERT INTO pr_lesson_kind (lesson_kind_name) VALUES ('Practice');

INSERT INTO pr_test_kind (test_name) VALUES ('Exam');
INSERT INTO pr_test_kind (test_name) VALUES ('Credit');
