package com.feliciadurni.tt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by felic on 3/5/2016.
 */
@Entity
@Table(name = "routineexercises", schema = "trainingtracker")
public class RoutineExercisesEntity {
    private int routineExercisesId;

    @Id
    @Column(name = "routineExercisesId")
    public int getRoutineExercisesId() {
        return routineExercisesId;
    }

    public void setRoutineExercisesId(int routineExercisesId) {
        this.routineExercisesId = routineExercisesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutineExercisesEntity that = (RoutineExercisesEntity) o;

        if (routineExercisesId != that.routineExercisesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return routineExercisesId;
    }
}
