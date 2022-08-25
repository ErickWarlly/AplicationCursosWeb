/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.connection.ConexaoDB;
import br.com.model.Cursos;
import br.com.model.Disciplinas;
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
public class PageDAO {

    ConexaoDB conect;

    public PageDAO() {

        conect = new ConexaoDB();
    }

    public List<Disciplinas> listaDisciplinas() {
        try {

            String sql = "select iddisc, discdescricao, discch, cursodescricao from disciplinas d, cursos c where c.idcursos = d.idcursos order by iddisc";

            PreparedStatement pstm = conect.abrirconexao().prepareStatement(sql);

            ResultSet result = pstm.executeQuery();

            List<Disciplinas> listagem = new ArrayList<>();

            while (result.next()) {
                Disciplinas disc = new Disciplinas();

                disc.setIddisciplinas(result.getInt(1));
                disc.setDescricao(result.getString(2));
                disc.setCargahoraria(result.getInt(3));
                disc.setCursos(result.getString(4));

                listagem.add(disc);
            }

            return listagem;

        } catch (SQLException SQLEX) {
            Logger.getLogger(PageDAO.class.getName());
        }
        return null;

    }

    public boolean cadastrarDisciplinar(String descricao, int idcurso, int cargaHora) {

        try {
            String sql = "insert into disciplinas(discdescricao, idcursos, discch) value (?, ?, ?)";
            PreparedStatement pstm = conect.abrirconexao().prepareStatement(sql);
            pstm.setString(1, descricao);
            pstm.setInt(2, idcurso);
            pstm.setInt(3, cargaHora);

            pstm.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(PageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean updateDisciplina(Disciplinas disciplina) {

        try {

            String sql = "Update disciplinas set idcursos = ?, discch = ? where iddisc = ?";
            PreparedStatement pstm = conect.abrirconexao().prepareStatement(sql);
            pstm.setInt(1, disciplina.getIdcursos());
            pstm.setInt(2, disciplina.getCargahoraria());
            pstm.setInt(3, disciplina.getIddisciplinas());

            pstm.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(PageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateDisciplinaCurso(Disciplinas disciplina) {

        try {

            String sql = "Update disciplinas set idcursos = ? where iddisc = ?";
            PreparedStatement pstm = conect.abrirconexao().prepareStatement(sql);
            pstm.setInt(1, disciplina.getIdcursos());
            pstm.setInt(2, disciplina.getIddisciplinas());

            pstm.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(PageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deletarDisciplina(int id) {

        try {
            String sql = "delete from disciplinas where iddisc = ?";
            PreparedStatement pstm = conect.abrirconexao().prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(PageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
