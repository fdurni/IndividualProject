package com.feliciadurni.tt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by felic on 3/29/2016.
 */
@Entity
@Table(name = "routineexercises", schema = "trainingtracker", catalog = "")
public class RoutineexercisesEntity {
    private int routineExercisesId;
    private int exerciseId;
    private int routineId;

    @Id
    @Column(name = "routineExercisesId")
    public int getRoutineExercisesId() {
        return routineExercisesId;
    }

    public void setRoutineExercisesId(int routineExercisesId) {
        this.routineExercisesId = routineExercisesId;
    }

    @Id
    @Column(name = "exerciseId")
    public int getExercisesId() {
        return exerciseId;
    }

    public void setExercisesId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    @Id
    @Column(name = "routineId")
    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutineexercisesEntity that = (RoutineexercisesEntity) o;

        if (routineExercisesId != that.routineExercisesId) return false;
        if (exerciseId != that.exerciseId) return false;
        return routineId == that.routineId;

    }

    @Override
    public int hashCode() {
        int result = routineExercisesId;
        result = 31 * result + exerciseId;
        result = 31 * result + routineId;
        return result;
    }

    @Override
    public String toString() {
        return "RoutineexercisesEntity{" +
                "routineExercisesId=" + routineExercisesId +
                ", exerciseId=" + exerciseId +
                ", routineId=" + routineId +
                '}';
    }
}
