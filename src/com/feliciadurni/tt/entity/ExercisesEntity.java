package com.feliciadurni.tt.entity;

import javax.persistence.*;

/**
 * Created by felic on 3/29/2016.
 */
@Entity
@Table(name = "exercises", schema = "trainingtracker", catalog = "")
public class ExercisesEntity {
    private int exerciseId;
    private String exerciseName;
    private String exerciseType;
    private String exerciseDescription;

    @Id
    @Column(name = "exerciseId")
    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    @Basic
    @Column(name = "exerciseName")
    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    @Basic
    @Column(name = "exerciseType")
    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    @Basic
    @Column(name = "exerciseDescription")
    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExercisesEntity that = (ExercisesEntity) o;

        if (exerciseId != that.exerciseId) return false;
        if (exerciseName != null ? !exerciseName.equals(that.exerciseName) : that.exerciseName != null) return false;
        if (exerciseType != null ? !exerciseType.equals(that.exerciseType) : that.exerciseType != null) return false;
        if (exerciseDescription != null ? !exerciseDescription.equals(that.exerciseDescription) : that.exerciseDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exerciseId;
        result = 31 * result + (exerciseName != null ? exerciseName.hashCode() : 0);
        result = 31 * result + (exerciseType != null ? exerciseType.hashCode() : 0);
        result = 31 * result + (exerciseDescription != null ? exerciseDescription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExercisesEntity{" +
                "exerciseId=" + exerciseId +
                ", exerciseName='" + exerciseName + '\'' +
                ", exerciseType='" + exerciseType + '\'' +
                ", exerciseDescription='" + exerciseDescription + '\'' +
                '}';
    }
}
