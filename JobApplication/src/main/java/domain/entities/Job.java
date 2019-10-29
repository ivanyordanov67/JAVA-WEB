package domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "jobs")
public class Job extends BaseEntity {

    private Sector sector;
    private String Profession;
    private BigDecimal salary;
    private String description;

    public Job() {
    }

    @Column(name = "sector", nullable = false)
    @Enumerated(EnumType.STRING)
    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getProfession() {
        return Profession;
    }

    @Column(name = "profession", nullable = false)
    public void setProfession(String profession) {
        Profession = profession;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Column(name = "salary", nullable = false)
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
