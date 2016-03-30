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
    private Integer weight;
    private Date date;
    private Integer exerciseId;
    private Integer personId;

    @Id
    @Column(name = "personalRecordId", nullable = false)
    public int getPersonalRecordId() {
        return personalRecordId;
    }

    public void setPersonalRecordId(int personalRecordId) {
        this.personalRecordId = personalRecordId;
    }

    @Basic
    @Column(name = "weight", nullable = true)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
    @Column(name = "personId", nullable = true)
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalrecordEntity that = (PersonalrecordEntity) o;

        if (personalRecordId != that.personalRecordId) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (exerciseId != null ? !exerciseId.equals(that.exerciseId) : that.exerciseId != null) return false;
        return personId != null ? personId.equals(that.personId) : that.personId == null;

    }

    @Override
    public int hashCode() {
        int result = personalRecordId;
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (exerciseId != null ? exerciseId.hashCode() : 0);
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonalrecordEntity{" +
                "personalRecordId=" + personalRecordId +
                ", weight=" + weight +
                ", date=" + date +
                ", exerciseId=" + exerciseId +
                ", personId=" + personId +
                '}';
    }
}
