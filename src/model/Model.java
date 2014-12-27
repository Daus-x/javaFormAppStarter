package model;

/**
 * Created by suad on 12/27/2014.
 */
public class Model {
    private String name;
    private String surname;

    public Model(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
