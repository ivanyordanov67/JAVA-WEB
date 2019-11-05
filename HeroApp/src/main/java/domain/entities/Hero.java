package domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "heros")
public class Hero extends BaseEntity {

    private String heroName;
    private Clazz clazz;
    private Integer level;

    public Hero() {
    }

    @Column(name = "heroName", nullable = false)
    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    @Column(name = "class")
    @Enumerated(EnumType.STRING)
    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Column(name = "level", nullable = false)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
