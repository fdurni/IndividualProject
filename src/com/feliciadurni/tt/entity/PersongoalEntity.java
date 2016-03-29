package com.feliciadurni.tt.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by felic on 3/29/2016.
 */
@Entity
@Table(name = "persongoal", schema = "trainingtracker", catalog = "")
public class PersongoalEntity {
    private int personGoalId;
    private int goalWeight;
    private Date goalDate;
    private int personId;
    private int exerciseId;

    @Id
    @Column(name = "personGoalId")
    public int getPersonGoalId() {
        return personGoalId;
    }

    public void setPersonGoalId(int personGoalId) {
        this.personGoalId = personGoalId;
    }

    @Basic
    @Column(name = "goalWeight")
    public int getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(int goalWeight) {
        this.goalWeight = goalWeight;
    }

    @Basic
    @Column(name = "goalDate")
    public Date getGoalDate() {
        return goalDate;
    }

    public void setGoalDate(Date goalDate) {
        this.goalDate = goalDate;
    }

    @Basic
    @Column(name = "personId")
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "exerciseId")
    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersongoalEntity that = (PersongoalEntity) o;

        if (personGoalId != that.personGoalId) return false;
        if (goalWeight != that.goalWeight) return false;
        if (personId != that.personId) return false;
        if (exerciseId != that.exerciseId) return false;
        return goalDate != null ? goalDate.equals(that.goalDate) : that.goalDate == null;

    }

    @Override
    public int hashCode() {
        int result = personGoalId;
        result = 31 * result + goalWeight;
        result = 31 * result + (goalDate != null ? goalDate.hashCode() : 0);
        result = 31 * result + personId;
        result = 31 * result + exerciseId;
        return result;
    }

    @Override
    public String toString() {
        return "PersongoalEntity{" +
                "personGoalId=" + personGoalId +
                ", goalWeight=" + goalWeight +
                ", goalDate=" + goalDate +
                ", personId=" + personId +
                ", exerciseId=" + exerciseId +
                '}';
    }
}
