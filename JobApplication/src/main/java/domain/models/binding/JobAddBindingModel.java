package domain.models.binding;

import domain.entities.Sector;

import java.math.BigDecimal;

public class JobAddBindingModel {

    private String sector;
    private String Profession;
    private BigDecimal salary;
    private String description;

    public JobAddBindingModel() {
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
