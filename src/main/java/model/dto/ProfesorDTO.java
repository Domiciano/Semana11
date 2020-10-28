package model.dto;

import java.util.ArrayList;

public class ProfesorDTO {
    private int id;
    private String nombre;
    private String facultad;
    private ArrayList<CursoDTO> cursos;

    public ProfesorDTO(int id, String nombre, String facultad, ArrayList<CursoDTO> cursos) {
        this.id = id;
        this.nombre = nombre;
        this.facultad = facultad;
        this.cursos = cursos;
    }

    public ProfesorDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public ArrayList<CursoDTO> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<CursoDTO> cursos) {
        this.cursos = cursos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
