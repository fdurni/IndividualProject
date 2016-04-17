package com.feliciadurni.tt.entity;

import javax.persistence.Transient;
import java.util.Set;

/**
 * Created by felic on 3/29/2016.
 */
public class Program {
    private Integer programId;
    private String programName;
    private String programType;
    private String programDescription;
    private Set<Routine> routines;
    private Person person;

    public Program() {}

    public Program(Integer programId, String programName, String programDescription, String programType) {
        this.programId = programId;
        this.programName = programName;
        this.programDescription = programDescription;
        this.programType = programType;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public Set<Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(Set<Routine> routines) {
        this.routines = routines;
    }

    public void addRoutine(Routine routine) {
        this.routines.add(routine);
    }

    @Transient
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Program{" +
                "programId=" + programId +
                ", programName='" + programName + '\'' +
                ", programType='" + programType + '\'' +
                ", programDescription='" + programDescription + '\'' +
                '}';
    }
}
