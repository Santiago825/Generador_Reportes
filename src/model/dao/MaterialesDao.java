/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.vo.MaterialesVo;
import util.JDBCUtilities;

/**
 *
 * @author santi
 */
public class MaterialesDao {
            public List<MaterialesVo> findAll() throws SQLException {
        var response = new ArrayList<MaterialesVo>();
        try (var connection = JDBCUtilities.getConnection();
                var statement = connection.prepareStatement(
                        "SELECT ID_Compra,Constructora, Banco_Vinculado FROM Proyecto INNER JOIN Compra ON Proyecto.ID_Proyecto=Compra.ID_Compra WHERE Proveedor='Homecenter' and Ciudad='Salento'");
                var rset = statement.executeQuery()) {

            while (rset.next()) {
                var materiales = new MaterialesVo();
                materiales.setId(rset.getInt("ID_Compra"));
                materiales.setConstructora(rset.getString("Constructora"));
                materiales.setBanco(rset.getString("Banco_Vinculado"));
                response.add(materiales);
            }
        }
        return response;
    }
    
    
}
