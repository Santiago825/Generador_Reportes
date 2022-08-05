/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.vo.ProyectoVo;
import util.JDBCUtilities;

/**
 *
 * @author santi
 */
public class ProyectoDao {
    
        public List<ProyectoVo> findAll() throws SQLException {
        var response = new ArrayList<ProyectoVo>();
        try (var connection = JDBCUtilities.getConnection();
                var statement = connection.prepareStatement(
                        "SELECT ID_Proyecto,Constructora ,Numero_Habitaciones,Ciudad FROM Proyecto WHERE Clasificacion='Casa Campestre' AND ( Ciudad='Barranquilla' OR Ciudad='Cartagena' OR Ciudad='Santa Marta')");
                var rset = statement.executeQuery()) {

            while (rset.next()) {
                var proyecto = new ProyectoVo();
                proyecto.setId(rset.getInt("ID_Proyecto"));
                proyecto.setConstructora(rset.getString("Constructora"));
                proyecto.setNumero_habitantes(rset.getString("Numero_Habitaciones"));
                proyecto.setCiudad(rset.getString("Ciudad"));
                response.add(proyecto);
            }
        }
        return response;
    }
    
    
}
