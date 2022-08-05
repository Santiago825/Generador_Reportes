/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.LiderVo;
import util.JDBCUtilities;

/**
 *
 * @author santi
 */
public class LiderDao {

    public LiderDao() {
    }
    
    
    
    public List<LiderVo> findAll() throws SQLException {
        var response = new ArrayList<LiderVo>();
        try (var connection = JDBCUtilities.getConnection();
                var statement = connection.prepareStatement(
                        "SELECT ID_Lider,Nombre,Primer_Apellido,Ciudad_Residencia FROM Lider ORDER BY Ciudad_Residencia");
                var rset = statement.executeQuery()) {

            while (rset.next()) {
                var lider = new LiderVo();
                lider.setId(rset.getInt("ID_Lider"));
                lider.setNombre(rset.getString("Nombre"));
                lider.setPrimerApellido(rset.getString("Primer_Apellido"));
                lider.setCiudadResidencial(rset.getString("Ciudad_Residencia"));
                response.add(lider);
            }
        }
        return response;
    }
    
}
