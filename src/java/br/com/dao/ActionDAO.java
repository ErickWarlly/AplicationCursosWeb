/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.connection.ConexaoDB;
import br.com.model.Cursos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author android
 */
public class ActionDAO {

    ConexaoDB conect;

    public ActionDAO() {

        conect = new ConexaoDB();
    }

    public List<Cursos> listaCurso() {

        String sql = "select * from cursos";

        try {
            PreparedStatement pstm = conect.abrirconexao().prepareStatement(sql);

            ResultSet result = pstm.executeQuery();
            
            List<Cursos> optionsCursos = new ArrayList<>();

            while (result.next()) {
                Cursos curs = new Cursos();
                
                curs.setIdcursos(result.getInt(1));
                curs.setDescricao(result.getString(2));
                curs.setHabilidade(result.getString(3));
                curs.setModalidade(result.getString(4));
                
                optionsCursos.add(curs);
            }
            
            return optionsCursos;

        } catch (SQLException ex) {
            Logger.getLogger(ActionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    

}
