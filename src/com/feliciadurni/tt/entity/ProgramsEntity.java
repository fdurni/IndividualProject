package com.feliciadurni.tt.entity;

import javax.persistence.*;

/**
 * Created by felic on 3/5/2016.
 */
@Entity
@Table(name = "programs", schema = "trainingtracker")
public class ProgramsEntity {
    private int programId;
    private String programName;
    private String programType;
    private String programDescription;

    @Id
    @Column(name = "programId")
    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    @Basic
    @Column(name = "programName")
    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @Basic
    @Column(name = "programType")
    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    @Basic
    @Column(name = "programDescription")
    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgramsEntity that = (ProgramsEntity) o;

        if (programId != that.programId) return false;
        if (programName != null ? !programName.equals(that.programName) : that.programName != null) return false;
        if (programType != null ? !programType.equals(that.programType) : that.programType != null) return false;
        if (programDescription != null ? !programDescription.equals(that.programDescription) : that.programDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = programId;
        result = 31 * result + (programName != null ? programName.hashCode() : 0);
        result = 31 * result + (programType != null ? programType.hashCode() : 0);
        result = 31 * result + (programDescription != null ? programDescription.hashCode() : 0);
        return result;
    }

}
