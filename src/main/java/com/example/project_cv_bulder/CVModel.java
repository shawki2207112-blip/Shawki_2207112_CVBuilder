package com.example.project_cv_bulder;

public class CVModel {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String education;
    private String skills;
    private String workExp;
    private String projects;

    public CVModel(int id, String name, String email, String phone,
                   String address, String education, String skills,
                   String workExp, String projects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.education = education;
        this.skills = skills;
        this.workExp = workExp;
        this.projects = projects;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getEducation() { return education; }
    public String getSkills() { return skills; }
    public String getWorkExp() { return workExp; }
    public String getProjects() { return projects; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
    public void setEducation(String education) { this.education = education; }
    public void setSkills(String skills) { this.skills = skills; }
    public void setWorkExp(String workExp) { this.workExp = workExp; }
    public void setProjects(String projects) { this.projects = projects; }

    @Override
    public String toString() {
        return id + " — " + name + " (" + email + ")";
    }
}
