/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author android
 */
public class Disciplinas {
    
    private int iddisciplinas;
    private String descricao;
    private String cursos;
    private int cargahoraria;
    int idcursos;


    public Disciplinas() {
    }

    public Disciplinas(String descricao, String cursos, int cargahoraria) {
        this.descricao = descricao;
        this.cursos = cursos;
        this.cargahoraria = cargahoraria;
    }
    
    
    public int getIddisciplinas() {
        return iddisciplinas;
    }

    public void setIddisciplinas(int iddisciplinas) {
        this.iddisciplinas = iddisciplinas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCursos() {
        return cursos;
    }

    public void setCursos(String cursos) {
        this.cursos = cursos;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public int getIdcursos() {
        return idcursos;
    }

    public void setIdcursos(int idcursos) {
        this.idcursos = idcursos;
    }

    
}
