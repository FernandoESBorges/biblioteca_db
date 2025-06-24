/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.biblioteca.db.admin.model.dao;

import com.unincor.biblioteca.db.admin.model.domain.Autor;
import com.unincor.sistema.bancario.admin.configurations.MySQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ferna
 */
public class AutorDao {

    public void inserirAutor(Autor autor) {
        String sql = "INSERT INTO autores(nome, nacionalidade, data_nascimento) VALUES (?, ?, ?)";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, autor.getNome());
            ps.setString(2, autor.getNacionalidade());
            ps.setDate(3, Date.valueOf(autor.getData_nascimento()));
            ps.executeUpdate(); // <- executando o insert
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Autor> buscarTodosAutores() {
        List<Autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM autores";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Autor autor = construirAutorSql(rs);
                autores.add(autor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, "Erro ao buscar todos os autores", ex);
        }
        return autores;
    }

    public Autor buscarAutorPorId(Long idAutor) {
        String sql = "SELECT * FROM autores WHERE id_autor = ?";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, idAutor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return construirAutorSql(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, "Erro ao buscar autor por ID", ex);
        }
        return null;
    }

    private Autor construirAutorSql(ResultSet rs) throws SQLException {
        Autor autor = new Autor();
        autor.setIdAutor(rs.getLong("id_autor"));
        autor.setNome(rs.getString("nome"));
        autor.setNacionalidade(rs.getString("nacionalidade"));
        autor.setData_nascimento(rs.getDate("data_nascimento").toLocalDate());
        return autor;
    }

    public static void main(String[] args) {
        AutorDao autorDao = new AutorDao();

        System.out.println("Teste de inserir Autor:");
        Autor novoAutor = new Autor(null, "Carlos", "Brasil",LocalDate.now() );
        autorDao.inserirAutor(novoAutor); 

        System.out.println("Teste buscar todos os autores:");
        List<Autor> autores = autorDao.buscarTodosAutores();
        autores.forEach(au -> System.out.println("Id: " + au.getIdAutor() + " Nome: " + au.getNome()));

        System.out.println("\nTeste buscar autor por ID:");
        Autor autor = autorDao.buscarAutorPorId(1L);
        if (autor != null) {
            System.out.println("Id: " + autor.getIdAutor()
                    + " Nome: " + autor.getNome()
                    + " Nacionalidade: " + autor.getNacionalidade());
        } else {
            System.out.println("Autor não encontrado.");
        }
    }
}
