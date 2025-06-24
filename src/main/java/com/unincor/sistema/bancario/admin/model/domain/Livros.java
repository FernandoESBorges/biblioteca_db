/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.domain;

/**
 *
 * @author Ferna
 */
public class Livros {

    private long idLivro;
    private String titulo;
    private String genero;
    private Autor autor;

    public Livros() {

    }

    public Livros(long idLivros, String titulo, String genero, Autor autor) {
        this.idLivro = idLivros;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;

    }

    public long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(long idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    

}
