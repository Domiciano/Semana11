package model.provider;

import db.MySQLConnection;
import entity.Profesor;
import model.dto.CursoDTO;
import model.dto.ProfesorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesorProvider {
    //Proveer informacion

    public ProfesorDTO getCompleteProfesorById(int id) {
        ProfesorDTO profesorDTO = new ProfesorDTO();
        MySQLConnection connection = new MySQLConnection();
        CursoProvider cursoProvider = new CursoProvider();
        try {
            String sql = "SELECT id, nombre, facultad FROM profesores WHERE id=" + id;
            ResultSet resultSet = connection.query(sql);
            while (resultSet.next()) {
                profesorDTO.setId( resultSet.getInt(1) );
                profesorDTO.setNombre( resultSet.getString(2) );
                profesorDTO.setFacultad( resultSet.getString(3) );
                ArrayList<CursoDTO> cursoDTOS = cursoProvider.getAllCursosByProfesor(profesorDTO.getId());
                profesorDTO.setCursos(cursoDTOS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Control alt L
        //Command option L
        connection.disconnect();
        return profesorDTO;
    }

    public ProfesorDTO getProfesorById(int id) {
        ProfesorDTO profesorDTO = new ProfesorDTO();
        MySQLConnection connection = new MySQLConnection();
        CursoProvider cursoProvider = new CursoProvider();
        try {
            String sql = "SELECT id, nombre, facultad FROM profesores WHERE id=" + id;
            ResultSet resultSet = connection.query(sql);
            while (resultSet.next()) {
                profesorDTO.setId( resultSet.getInt(1) );
                profesorDTO.setNombre( resultSet.getString(2) );
                profesorDTO.setFacultad( resultSet.getString(3) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Control alt L
        //Command option L
        connection.disconnect();
        return profesorDTO;
    }





    public ArrayList<ProfesorDTO> getAllProfesores() {
        ArrayList<ProfesorDTO> output = new ArrayList<>();
        MySQLConnection connection = new MySQLConnection();
        try {
            String sql = "SELECT id, nombre, facultad FROM profesores";
            ResultSet resultSet = connection.query(sql);
            while (resultSet.next()) {
                output.add(new ProfesorDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        null
                ));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        connection.disconnect();
        return output;
    }

    //Proveer las acciones
    public void insertProfesor(Profesor profesor) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "INSERT INTO profesores(nombre, facultad) VALUES ('$nombre','$facultad')";
        sql = sql.replace("$nombre", profesor.getNombre());
        sql = sql.replace("$facultad", profesor.getFacultad());
        connection.executeSQL(sql);
    }

    public void updateProfesor() {

    }

    public boolean deleteProfesor(String id) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "DELETE FROM profesores WHERE id="+id;
        return connection.executeSQL(sql);
    }

    public Profesor mapFromDTO(ProfesorDTO dto) {
        Profesor profesor = new Profesor();
        profesor.setId(dto.getId());
        profesor.setNombre(dto.getNombre());
        profesor.setFacultad(dto.getFacultad());
        return profesor;
    }

    public ProfesorDTO mapToDTO(Profesor profesor){
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setId(profesor.getId());
        profesorDTO.setNombre(profesor.getNombre());
        profesorDTO.setFacultad(profesor.getFacultad());
        return profesorDTO;
    }
}
