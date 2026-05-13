/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoService;
import br.com.ifba.curso.service.ICursoService;
import java.util.List;


/**
 *
 * @author LUID1.7
 */
public class CursoController implements ICursoController {
    // O Controller utiliza o Service
    private ICursoService cursoService = new CursoService();

    @Override
    public Curso save(Curso curso) throws RuntimeException {
        return cursoService.save(curso);
    }

    @Override
    public Curso update(Curso curso) throws RuntimeException {
        return cursoService.update(curso);
    }

    @Override
    public void delete(Curso curso) throws RuntimeException {
        cursoService.delete(curso);
    }

    @Override
    public List<Curso> findAll() throws RuntimeException {
        return cursoService.findAll();
    }

    @Override
    public Curso findById(Long id) throws RuntimeException {
        return cursoService.findById(id);
    }

    @Override
    public List<Curso> findByNome(String nome) throws RuntimeException {
        return cursoService.findByNome(nome);
    }
}