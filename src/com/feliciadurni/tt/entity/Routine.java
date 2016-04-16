package com.feliciadurni.tt.entity;

import javax.persistence.Transient;
import java.util.Set;

/**
 * Created by felic on 3/29/2016.
 */
public class Routine {
    private Integer routineId;
    private String routineName;
    private String routineDescription;
    private Integer week;
    private Integer day;
    private Program program;
    private Set<RoutineExercise> routineExercises;

    public Routine() {}

    public Routine(String routineName, String routineDescription, Integer week, Integer day) {
        this.routineName = routineName;
        this.routineDescription = routineDescription;
        this.week = week;
        this.day = day;
    }

    public Integer getRoutineId() {
        return routineId;
    }

    public void setRoutineId(Integer routineId) {
        this.routineId = routineId;
    }

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    public String getRoutineDescription() {
        return routineDescription;
    }

    public void setRoutineDescription(String routineDescription) {
        this.routineDescription = routineDescription;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Transient
    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Set<RoutineExercise> getRoutineExercises() {
        return routineExercises;
    }

    public void setRoutineExercises(Set<RoutineExercise> routineExercises) {
        this.routineExercises = routineExercises;
    }

    public void addRoutineExercise(RoutineExercise routineExercise) {
        this.routineExercises.add(routineExercise);
    }
}
