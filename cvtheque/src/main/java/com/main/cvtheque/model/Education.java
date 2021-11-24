package com.main.cvtheque.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "educations")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String schoolName;

    @NotNull
    private String degreeName;

    @NotNull
    private Date begningDate;

    @NotNull
    private Date endingDate;

    //CV
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cv_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private CV cv;

    public Education(Long id, String schoolName, String degreeName, Date begningDate, Date endingDate) {
        this.id = id;
        this.schoolName = schoolName;
        this.degreeName = degreeName;
        this.begningDate = begningDate;
        this.endingDate = endingDate;
    }

    public Long getId() {
        return id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public Date getBegningDate() {
        return begningDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public void setBegningDate(Date begningDate) {
        this.begningDate = begningDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }
}
