/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erick_warlly
 */

//Class responsavel em fazer a conexão com o banco de dados.
public class ConexaoDB {

    Connection conexao;

    public Connection abrirconexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Utilização do jdbc.Driver | Para que seja possível a interpretação entre JAVA e SQL.

            conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nome_do_DB", "nome_do_usuario", "senha_do_usuario"); //Caminho para o o banco de dados

            return conexao;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
