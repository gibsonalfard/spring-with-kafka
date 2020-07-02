package xyz.ilhamgibran.spring.springmongo;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Mahasiswa {
    @Id
    private String id;

    private String nim;
    private String name;
    private int sksTake;

    public Mahasiswa(){

    }

    public Mahasiswa(String nim, String name, int sks){
        this.nim = nim;
        this.name = name;
        this.sksTake = sks;
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
