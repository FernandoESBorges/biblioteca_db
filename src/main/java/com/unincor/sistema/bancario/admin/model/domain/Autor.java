/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.domain;

import java.time.LocalDate;

/**
 *
 * @author Ferna
 */
public class Autor {
    
    private long idAutor;
    private String nome;
    private String nacionalidade;
    private LocalDate data_nascimento;
    
    public Autor(){
        
    }
    
    public Autor(long idAutor,String nome,String nacionalidade,LocalDate data_nascimento){
        this.idAutor = idAutor;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.data_nascimento = data_nascimento;
        
    }

    public long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    
    
}
