package com.proiect.catalog.model;  //package containing all the entities (classes that are mapped to the db tables)
                                    // for each model (table) you usually have: 1 model, 1 repository, 1 service, 1 controller, 1 dto
import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "credit_points")
    private Integer creditPoints;

    @Column(name = "is_optional")
    private Boolean isOptional;

    @Column(name = "course_percent")
    private Integer coursePercent;

    @Column(name = "seminary_percent")
    private Integer seminaryPercent;

    //getters and setters & toString() - Alt + Insert for IntelliJ auto-generation
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(Integer creditPoints) {
        this.creditPoints = creditPoints;
    }

    public Boolean getOptional() {
        return isOptional;
    }

    public void setOptional(Boolean optional) {
        isOptional = optional;
    }

    public Integer getCoursePercent() {
        return coursePercent;
    }

    public void setCoursePercent(Integer coursePercent) {
        this.coursePercent = coursePercent;
    }

    public Integer getSeminaryPercent() {
        return seminaryPercent;
    }

    public void setSeminaryPercent(Integer seminaryPercent) {
        this.seminaryPercent = seminaryPercent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Subject{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", creditPoints=").append(creditPoints);
        sb.append(", isOptional=").append(isOptional);
        sb.append(", coursePercent=").append(coursePercent);
        sb.append(", seminaryPercent=").append(seminaryPercent);
        sb.append('}');
        return sb.toString();
    }
}
