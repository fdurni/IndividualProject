package com.feliciadurni.tt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    /**
     * Instantiates a new Routine.
     */
    public Routine() {}

    /**
     * Instantiates a new Routine.
     *
     * @param routineName        the routine name
     * @param routineDescription the routine description
     * @param week               the week
     * @param day                the day
     */
    public Routine(String routineName, String routineDescription, Integer week, Integer day) {
        this.routineName = routineName;
        this.routineDescription = routineDescription;
        this.week = week;
        this.day = day;
    }

    /**
     * Gets routine id.
     *
     * @return the routine id
     */
    public Integer getRoutineId() {
        return routineId;
    }

    /**
     * Sets routine id.
     *
     * @param routineId the routine id
     */
    public void setRoutineId(Integer routineId) {
        this.routineId = routineId;
    }

    /**
     * Gets routine name.
     *
     * @return the routine name
     */
    public String getRoutineName() {
        return routineName;
    }

    /**
     * Sets routine name.
     *
     * @param routineName the routine name
     */
    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    /**
     * Gets routine description.
     *
     * @return the routine description
     */
    public String getRoutineDescription() {
        return routineDescription;
    }

    /**
     * Sets routine description.
     *
     * @param routineDescription the routine description
     */
    public void setRoutineDescription(String routineDescription) {
        this.routineDescription = routineDescription;
    }

    /**
     * Gets week.
     *
     * @return the week
     */
    public Integer getWeek() {
        return week;
    }

    /**
     * Sets week.
     *
     * @param week the week
     */
    public void setWeek(Integer week) {
        this.week = week;
    }

    /**
     * Gets day.
     *
     * @return the day
     */
    public Integer getDay() {
        return day;
    }

    /**
     * Sets day.
     *
     * @param day the day
     */
    public void setDay(Integer day) {
        this.day = day;
    }

    /**
     * Gets program.
     *
     * @return the program
     */
    @Transient
    @JsonIgnore
    public Program getProgram() {
        return program;
    }

    /**
     * Sets program.
     *
     * @param program the program
     */
    public void setProgram(Program program) {
        this.program = program;
    }

    /**
     * Gets routine exercises.
     *
     * @return the routine exercises
     */
    public Set<RoutineExercise> getRoutineExercises() {
        return routineExercises;
    }

    /**
     * Sets routine exercises.
     *
     * @param routineExercises the routine exercises
     */
    public void setRoutineExercises(Set<RoutineExercise> routineExercises) {
        this.routineExercises = routineExercises;
    }

    /**
     * Add routine exercise.
     *
     * @param routineExercise the routine exercise
     */
    public void addRoutineExercise(RoutineExercise routineExercise) {
        this.routineExercises.add(routineExercise);
    }
}
