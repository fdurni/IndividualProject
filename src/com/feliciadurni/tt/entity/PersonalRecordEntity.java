package com.feliciadurni.tt.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by felic on 3/5/2016.
 */
@Entity
@Table(name = "personalrecord", schema = "trainingtracker")
public class PersonalRecordEntity {
    private int personalRecordId;
    private Integer personalRecordWeight;
    private Date personalRecordDate;

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
    public Integer getPersonalRecordWeight() {
        return personalRecordWeight;
    }

    public void setPersonalRecordWeight(Integer personalRecordWeight) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalRecordEntity that = (PersonalRecordEntity) o;

        if (personalRecordId != that.personalRecordId) return false;
        if (personalRecordWeight != null ? !personalRecordWeight.equals(that.personalRecordWeight) : that.personalRecordWeight != null)
            return false;
        if (personalRecordDate != null ? !personalRecordDate.equals(that.personalRecordDate) : that.personalRecordDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personalRecordId;
        result = 31 * result + (personalRecordWeight != null ? personalRecordWeight.hashCode() : 0);
        result = 31 * result + (personalRecordDate != null ? personalRecordDate.hashCode() : 0);
        return result;
    }
}
