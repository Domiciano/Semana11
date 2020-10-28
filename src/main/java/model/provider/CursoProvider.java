package model.provider;

import db.MySQLConnection;
import entity.Curso;
import model.dto.CursoDTO;
import model.dto.ProfesorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoProvider {

    //Proveer informacion
    public ArrayList<CursoDTO> getAllCursos(){
        ArrayList<CursoDTO> cursoDTOS = new ArrayList<>();
        MySQLConnection connection = new MySQLConnection();
        ProfesorProvider profesorProvider = new ProfesorProvider();
        try {
            String sql = "SELECT nombre, programa, profesorID FROM cursos";
            ResultSet resultSet = connection.query(sql);
            while (resultSet.next()) {
                CursoDTO cursoDTO = new CursoDTO();
                cursoDTO.setNombre( resultSet.getString(1) );
                cursoDTO.setPrograma( resultSet.getString(2) );
                ProfesorDTO profesorDTO = profesorProvider.getProfesorById( resultSet.getInt(3) );
                cursoDTO.setProfesor(profesorDTO);
                cursoDTOS.add(cursoDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Control alt L
        //Command option L
        connection.disconnect();
        return cursoDTOS;
    }

    public ArrayList<CursoDTO> getAllCursosByProfesor(int id){
        ArrayList<CursoDTO> cursoDTOS = new ArrayList<>();
        MySQLConnection connection = new MySQLConnection();
        try {
            String sql = "SELECT nombre, programa FROM cursos WHERE profesorID="+id;
            ResultSet resultSet = connection.query(sql);
            while (resultSet.next()) {
                CursoDTO cursoDTO = new CursoDTO();
                cursoDTO.setNombre( resultSet.getString(1) );
                cursoDTO.setPrograma( resultSet.getString(2) );
                cursoDTOS.add(cursoDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Control alt L
        //Command option L
        connection.disconnect();
        return cursoDTOS;

    }

    //Proveer las acciones
    public void insertCurso(Curso curso){
        MySQLConnection connection = new MySQLConnection();
        String sql = "INSERT INTO cursos(nombre, programa, profesorID) VALUES ('$nombre','$programa', $profesor)";
        sql = sql.replace("$nombre", curso.getNombre());
        sql = sql.replace("$programa", curso.getPrograma());
        sql = sql.replace("$profesor", ""+curso.getProfesorID());
        connection.executeSQL(sql);
    }

    public void updateCurso(){

    }

    public void deleteCurso(){

    }

    public Curso mapFromDTO(CursoDTO dto){
        Curso curso = new Curso();
        curso.setNombre(dto.getNombre());
        curso.setPrograma(dto.getPrograma());
        curso.setProfesorID(dto.getProfesor().getId());
        return curso;
    }

    //CRUD: Create, Read, Update y Delete


}
