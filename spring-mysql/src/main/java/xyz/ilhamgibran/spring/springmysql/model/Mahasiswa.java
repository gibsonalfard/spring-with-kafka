package xyz.ilhamgibran.spring.springmysql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mahasiswa {
    @Id
    private String nim;
    private String name;
    private int sksTake;

    public Mahasiswa(){super();}
    public Mahasiswa(String nim, String name, int sks){
        this.setNim(nim);
        this.setName(name);
        this.setSksTake(sks);
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSksTake() {
        return sksTake;
    }

    public void setSksTake(int sksTake) {
        this.sksTake = sksTake;
    }

    @Override
    public String toString() {
        return String.format(
                "Mahasiswa[nim=%s, name='%s', gpa='%d']",
                this.getNim(), this.getName(), this.getSksTake());
    }
}
