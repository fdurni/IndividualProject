package com.feliciadurni.tt.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by felic on 3/5/2016.
 */
@Entity
@Table(name = "persongoal", schema = "trainingtracker")
public class PersonGoalEntity {
    private int personGoalId;
    private Integer goalWeight;
    private Date goalDate;

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
    public Integer getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(Integer goalWeight) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonGoalEntity that = (PersonGoalEntity) o;

        if (personGoalId != that.personGoalId) return false;
        if (goalWeight != null ? !goalWeight.equals(that.goalWeight) : that.goalWeight != null) return false;
        if (goalDate != null ? !goalDate.equals(that.goalDate) : that.goalDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personGoalId;
        result = 31 * result + (goalWeight != null ? goalWeight.hashCode() : 0);
        result = 31 * result + (goalDate != null ? goalDate.hashCode() : 0);
        return result;
    }
}
