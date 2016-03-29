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

    @Id
    @Column(name = "routineId")
    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
    }

    @Basic
    @Column(name = "routineName")
    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    @Basic
    @Column(name = "routineDescription")
    public String getRoutineDescription() {
        return routineDescription;
    }

    public void setRoutineDescription(String routineDescription) {
        this.routineDescription = routineDescription;
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = routineId;
        result = 31 * result + (routineName != null ? routineName.hashCode() : 0);
        result = 31 * result + (routineDescription != null ? routineDescription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RoutinesEntity{" +
                "routineId=" + routineId +
                ", routineName='" + routineName + '\'' +
                ", routineDescription='" + routineDescription + '\'' +
                '}';
    }
}
