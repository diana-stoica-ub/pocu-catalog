package com.proiect.catalog.web.dto;

import java.time.LocalDate;

//used when we need to send all the Teacher related information (e.g.: if we need to display them from Teacher's user profile page
public class TeacherDto extends TeacherBasicInfoDto {

    private LocalDate birthDate;
    private LocalDate employmentDate;
    private String cnp;
    private Long salary;

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TeacherDto{");
        sb.append("birthDate=").append(birthDate);
        sb.append(", employmentDate=").append(employmentDate);
        sb.append(", cnp='").append(cnp).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}
