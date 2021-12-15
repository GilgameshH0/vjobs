package com.miracle.vjobs.Dto;

import java.util.Objects;

public class StudentFormDto {
    private String name;
    private String speciality;
    private String position;
    private String education;
    private String about;

    public StudentFormDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentFormDto that = (StudentFormDto) o;
        return Objects.equals(name, that.name) && Objects.equals(speciality, that.speciality) && Objects.equals(position, that.position) && Objects.equals(education, that.education) && Objects.equals(about, that.about);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, speciality, position, education, about);
    }
}
