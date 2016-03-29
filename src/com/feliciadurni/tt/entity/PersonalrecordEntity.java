package com.feliciadurni.tt.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by felic on 3/29/2016.
 */
@Entity
@Table(name = "personalrecord", schema = "trainingtracker", catalog = "")
public class PersonalrecordEntity {
    private int personalRecordId;
    private int personalRecordWeight;
    private Date personalRecordDate;
    private int exerciseId;

    @Id
    @Column(name = "personalRecordId")
    public int getPersonalRecordId() {
        return personalRecordId;
    }

    public void setPersonalRecordId(int personalRecordId) {
        this.personalRecordId = personalRecordId;
    }

    @Basic
    @Column(name = "personalRecordWeight")
    public int getPersonalRecordWeight() {
        return personalRecordWeight;
    }

    public void setPersonalRecordWeight(int personalRecordWeight) {
        this.personalRecordWeight = personalRecordWeight;
    }

    @Basic
    @Column(name = "personalRecordDate")
    public Date getPersonalRecordDate() {
        return personalRecordDate;
    }

    public void setPersonalRecordDate(Date personalRecordDate) {
        this.personalRecordDate = personalRecordDate;
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

        PersonalrecordEntity that = (PersonalrecordEntity) o;

        if (personalRecordId != that.personalRecordId) return false;
        if (personalRecordWeight != that.personalRecordWeight) return false;
        if (exerciseId != that.exerciseId) return false;
        return personalRecordDate != null ? personalRecordDate.equals(that.personalRecordDate) : that.personalRecordDate == null;

    }

    @Override
    public int hashCode() {
        int result = personalRecordId;
        result = 31 * result + personalRecordWeight;
        result = 31 * result + (personalRecordDate != null ? personalRecordDate.hashCode() : 0);
        result = 31 * result + exerciseId;
        return result;
    }

    @Override
    public String toString() {
        return "PersonalrecordEntity{" +
                "personalRecordId=" + personalRecordId +
                ", personalRecordWeight=" + personalRecordWeight +
                ", personalRecordDate=" + personalRecordDate +
                ", exerciseId=" + exerciseId +
                '}';
    }
}
