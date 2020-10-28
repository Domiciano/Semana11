package entity;

public class CursoEstudianteRelationship {
    private int id;
    private int estudianteID;
    private int profesorID;

    public CursoEstudianteRelationship() {
    }

    public CursoEstudianteRelationship(int id, int estudianteID, int profesorID) {
        this.id = id;
        this.estudianteID = estudianteID;
        this.profesorID = profesorID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(int estudianteID) {
        this.estudianteID = estudianteID;
    }

    public int getProfesorID() {
        return profesorID;
    }

    public void setProfesorID(int profesorID) {
        this.profesorID = profesorID;
    }
}
