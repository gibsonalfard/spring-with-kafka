package xyz.ilhamgibran.spring.springkafka;

public class User {
    private String nim;
    private String name;
    private int sksTake;

    public User(){
        super();
    }

    public User(String nim, String name, int sks){
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
}
