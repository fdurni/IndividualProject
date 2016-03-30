package com.feliciadurni.tt.entity;

import javax.persistence.*;

/**
 * Created by felic on 3/29/2016.
 */
@Entity
@Table(name = "routineexercises", schema = "trainingtracker", catalog = "")
public class RoutineexercisesEntity {
    private int routineExercisesId;
    private Integer expectedSets;
    private String expectedReps;
    private Integer expectedWeight;
    private Integer actualSets;
    private Integer actualReps;
    private Integer actualWeight;
    private Integer exerciseId;
    private Integer routineId;

    @Id
    @Column(name = "routineExercisesId", nullable = false)
    public int getRoutineExercisesId() {
        return routineExercisesId;
    }

    public void setRoutineExercisesId(int routineExercisesId) {
        this.routineExercisesId = routineExercisesId;
    }

    @Basic
    @Column(name = "expectedSets", nullable = true)
    public Integer getExpectedSets() {
        return expectedSets;
    }

    public void setExpectedSets(Integer expectedSets) {
        this.expectedSets = expectedSets;
    }

    @Basic
    @Column(name = "expectedReps", nullable = true, length = 30)
    public String getExpectedReps() {
        return expectedReps;
    }

    public void setExpectedReps(String expectedReps) {
        this.expectedReps = expectedReps;
    }

    @Basic
    @Column(name = "expectedWeight", nullable = true)
    public Integer getExpectedWeight() {
        return expectedWeight;
    }

    public void setExpectedWeight(Integer expectedWeight) {
        this.expectedWeight = expectedWeight;
    }

    @Basic
    @Column(name = "actualSets", nullable = true)
    public Integer getActualSets() {
        return actualSets;
    }

    public void setActualSets(Integer actualSets) {
        this.actualSets = actualSets;
    }

    @Basic
    @Column(name = "actualReps", nullable = true)
    public Integer getActualReps() {
        return actualReps;
    }

    public void setActualReps(Integer actualReps) {
        this.actualReps = actualReps;
    }

    @Basic
    @Column(name = "actualWeight", nullable = true)
    public Integer getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(Integer actualWeight) {
        this.actualWeight = actualWeight;
    }

    @Basic
    @Column(name = "exerciseId", nullable = true)
    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    @Basic
    @Column(name = "routineId", nullable = true)
    public Integer getRoutineId() {
        return routineId;
    }

    public void setRoutineId(Integer routineId) {
        this.routineId = routineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutineexercisesEntity that = (RoutineexercisesEntity) o;

        if (routineExercisesId != that.routineExercisesId) return false;
        if (expectedSets != null ? !expectedSets.equals(that.expectedSets) : that.expectedSets != null) return false;
        if (expectedReps != null ? !expectedReps.equals(that.expectedReps) : that.expectedReps != null) return false;
        if (expectedWeight != null ? !expectedWeight.equals(that.expectedWeight) : that.expectedWeight != null)
            return false;
        if (actualSets != null ? !actualSets.equals(that.actualSets) : that.actualSets != null) return false;
        if (actualReps != null ? !actualReps.equals(that.actualReps) : that.actualReps != null) return false;
        if (actualWeight != null ? !actualWeight.equals(that.actualWeight) : that.actualWeight != null) return false;
        if (exerciseId != null ? !exerciseId.equals(that.exerciseId) : that.exerciseId != null) return false;
        return routineId != null ? routineId.equals(that.routineId) : that.routineId == null;

    }

    @Override
    public int hashCode() {
        int result = routineExercisesId;
        result = 31 * result + (expectedSets != null ? expectedSets.hashCode() : 0);
        result = 31 * result + (expectedReps != null ? expectedReps.hashCode() : 0);
        result = 31 * result + (expectedWeight != null ? expectedWeight.hashCode() : 0);
        result = 31 * result + (actualSets != null ? actualSets.hashCode() : 0);
        result = 31 * result + (actualReps != null ? actualReps.hashCode() : 0);
        result = 31 * result + (actualWeight != null ? actualWeight.hashCode() : 0);
        result = 31 * result + (exerciseId != null ? exerciseId.hashCode() : 0);
        result = 31 * result + (routineId != null ? routineId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RoutineexercisesEntity{" +
                "routineExercisesId=" + routineExercisesId +
                ", expectedSets=" + expectedSets +
                ", expectedReps='" + expectedReps + '\'' +
                ", expectedWeight=" + expectedWeight +
                ", actualSets=" + actualSets +
                ", actualReps=" + actualReps +
                ", actualWeight=" + actualWeight +
                ", exerciseId=" + exerciseId +
                ", routineId=" + routineId +
                '}';
    }
}
