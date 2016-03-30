package com.feliciadurni.tt.entity;

import javax.persistence.*;

/**
 * Created by felic on 3/29/2016.
 */
@Entity
@Table(name = "goals", schema = "trainingtracker", catalog = "")
public class GoalsEntity {
    private int goalId;
    private Integer goalWeight;
    private Integer personId;
    private Integer exerciseId;

    @Id
    @Column(name = "goalId", nullable = false)
    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    @Basic
    @Column(name = "goalWeight", nullable = true)
    public Integer getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(Integer goalWeight) {
        this.goalWeight = goalWeight;
    }

    @Basic
    @Column(name = "personId", nullable = true)
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "exerciseId", nullable = true)
    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoalsEntity that = (GoalsEntity) o;

        if (goalId != that.goalId) return false;
        if (goalWeight != null ? !goalWeight.equals(that.goalWeight) : that.goalWeight != null) return false;
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;
        return exerciseId != null ? exerciseId.equals(that.exerciseId) : that.exerciseId == null;

    }

    @Override
    public int hashCode() {
        int result = goalId;
        result = 31 * result + (goalWeight != null ? goalWeight.hashCode() : 0);
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (exerciseId != null ? exerciseId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GoalsEntity{" +
                "goalId=" + goalId +
                ", goalWeight=" + goalWeight +
                ", personId=" + personId +
                ", exerciseId=" + exerciseId +
                '}';
    }
}
