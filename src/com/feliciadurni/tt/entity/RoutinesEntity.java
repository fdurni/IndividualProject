package com.feliciadurni.tt.entity;

import javax.persistence.*;

/**
 * Created by felic on 3/29/2016.
 */
@Entity
@Table(name = "routines", schema = "trainingtracker", catalog = "")
public class RoutinesEntity {
    private int routineId;
    private String routineName;
    private String routineDescription;
    private Integer week;
    private Integer day;
    private Integer programId;

    @Id
    @Column(name = "routineId", nullable = false)
    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
    }

    @Basic
    @Column(name = "routineName", nullable = true, length = 30)
    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    @Basic
    @Column(name = "routineDescription", nullable = false, length = 150)
    public String getRoutineDescription() {
        return routineDescription;
    }

    public void setRoutineDescription(String routineDescription) {
        this.routineDescription = routineDescription;
    }

    @Basic
    @Column(name = "week", nullable = true)
    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    @Basic
    @Column(name = "day", nullable = true)
    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Basic
    @Column(name = "programId", nullable = true)
    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutinesEntity that = (RoutinesEntity) o;

        if (routineId != that.routineId) return false;
        if (routineName != null ? !routineName.equals(that.routineName) : that.routineName != null) return false;
        if (routineDescription != null ? !routineDescription.equals(that.routineDescription) : that.routineDescription != null)
            return false;
        if (week != null ? !week.equals(that.week) : that.week != null) return false;
        if (day != null ? !day.equals(that.day) : that.day != null) return false;
        return programId != null ? programId.equals(that.programId) : that.programId == null;

    }

    @Override
    public int hashCode() {
        int result = routineId;
        result = 31 * result + (routineName != null ? routineName.hashCode() : 0);
        result = 31 * result + (routineDescription != null ? routineDescription.hashCode() : 0);
        result = 31 * result + (week != null ? week.hashCode() : 0);
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + (programId != null ? programId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RoutinesEntity{" +
                "routineId=" + routineId +
                ", routineName='" + routineName + '\'' +
                ", routineDescription='" + routineDescription + '\'' +
                ", week=" + week +
                ", day=" + day +
                ", programId=" + programId +
                '}';
    }
}
