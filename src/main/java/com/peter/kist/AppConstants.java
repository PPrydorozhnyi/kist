package com.peter.kist;

import com.peter.kist.model.dto.*;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class AppConstants {

    public static final Type LESSON_LIST_TYPE = (new TypeToken<List<LessonDTO>>() {
    }).getType();

    public static final Type PERSON_LIST_TYPE = (new TypeToken<List<PersonDTO>>() {
    }).getType();

    public static final Type PERSON_SHORT_LIST_TYPE = (new TypeToken<List<PersonShortDTO>>() {
    }).getType();

    public static final Type LESSON_KIND_LIST_TYPE = (new TypeToken<List<LessonKindDTO>>() {
    }).getType();

    public static final Type CAFEDRA_LIST_TYPE = (new TypeToken<List<CafedraDTO>>() {
    }).getType();

    public static final Type MARK_LIST_TYPE = (new TypeToken<List<MarkDTO>>() {
    }).getType();

    public static final Type ORDER_KIND_LIST_TYPE = (new TypeToken<List<OrderKindDTO>>() {
    }).getType();

    public static final Type PRIVILEGE_LIST_TYPE = (new TypeToken<List<PrivilegeDTO>>() {
    }).getType();

    public static final Type PUNISH_KIND_DTO_LIST_TYPE = (new TypeToken<List<PunishKindDTO>>() {
    }).getType();

    public static final Type SEMESTER_LIST_TYPE = (new TypeToken<List<SemesterDTO>>() {
    }).getType();

    public static final Type STUDENT_LIST_TYPE = (new TypeToken<List<StudentDTO>>() {
    }).getType();

    public static final Type GROUP_LIST_TYPE = (new TypeToken<List<GroupDTO>>() {
    }).getType();

    public static final Type SUBJECT_LIST_TYPE = (new TypeToken<List<SubjectDTO>>() {
    }).getType();

    public static final Type TEST_KIND_LIST_TYPE = (new TypeToken<List<TestKindDTO>>() {
    }).getType();

    public static final Type VIOLATION_KIND_LIST_TYPE = (new TypeToken<List<ViolationKindDTO>>() {
    }).getType();

    public static final Type ORDER_LIST_TYPE = (new TypeToken<List<OrderDTO>>(){
    }).getType();

    public static final Type SPECIALITY_LIST_TYPE = (new TypeToken<List<SpecialityDTO>>(){
    }).getType();

    public static final Type VIOLATION_LIST_TYPE = (new TypeToken<List<ViolationDTO>>() {
    }).getType();

    public static final Type TEACHER_PLAN_LIST_TYPE = (new TypeToken<List<TeacherPlanDTO>>() {
    }).getType();

    public static final Type PERSON_PRIVILEGE_LIST_TYPE = (new TypeToken<List<PersonPrivilegeDTO>>() {
    }).getType();

    private AppConstants() {
    }
}
