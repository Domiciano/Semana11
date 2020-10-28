package entity;

public class Curso {
    private int id;
    private String nombre;
    private String programa;
    private int profesorID;

    public Curso() {
    }

    public Curso(int id, String nombre, String programa, int profesorID) {
        this.id = id;
        this.nombre = nombre;
        this.programa = programa;
        this.profesorID = profesorID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public int getProfesorID() {
        return profesorID;
    }

    public void setProfesorID(int profesorID) {
        this.profesorID = profesorID;
    }
}
