    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;
import br.com.ifba.curso.entity.Curso;
import java.util.List;
/**
 *
 * @author LUID1.7
 */


public interface ICursoService {
    public abstract Curso save(Curso curso) throws RuntimeException;
    public abstract Curso update(Curso curso) throws RuntimeException;
    public abstract void delete(Curso curso) throws RuntimeException;
    public abstract List<Curso> findAll() throws RuntimeException;
    public abstract Curso findById(Long id) throws RuntimeException;
    public abstract List<Curso> findByNome(String nome) throws RuntimeException;
}