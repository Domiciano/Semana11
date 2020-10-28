package model.dto;

public class CursoDTO {
    private String nombre;
    private String programa;
    private ProfesorDTO profesor;

    public CursoDTO() {
    }

    public CursoDTO(String nombre, String programa, ProfesorDTO profesor) {
        this.nombre = nombre;
        this.programa = programa;
        this.profesor = profesor;
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

    public ProfesorDTO getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorDTO profesor) {
        this.profesor = profesor;
    }
}
