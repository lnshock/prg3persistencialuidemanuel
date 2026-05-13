package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.ICursoDao;
import br.com.ifba.curso.entity.Curso;
import java.util.List;

public class CursoService implements ICursoService {
    
    private final ICursoDao cursoDao = new CursoDao();

    @Override
    public Curso save(Curso curso) throws RuntimeException {
        if (curso == null) {
            throw new RuntimeException("O curso está nulo!");
        }
        if (curso.getNome() == null || curso.getNome().trim().isEmpty()) {
            throw new RuntimeException("Nome do curso é obrigatório!");
        }
        return cursoDao.save(curso);
    }

    @Override
    public Curso update(Curso curso) throws RuntimeException {
        if (curso == null || curso.getId() == null) {
            throw new RuntimeException("Curso inválido para atualização!");
        }
        return cursoDao.update(curso);
    }

    @Override
    public void delete(Curso curso) throws RuntimeException {
        if (curso == null || curso.getId() == null) {
            throw new RuntimeException("Curso inválido para exclusão!");
        }
        cursoDao.delete(curso);
    }

    @Override
    public List<Curso> findAll() throws RuntimeException {
        return cursoDao.findAll();
    }

    @Override
    public Curso findById(Long id) throws RuntimeException {
        return cursoDao.findById(id);
    }

    @Override
    public List<Curso> findByNome(String nome) throws RuntimeException {
        return cursoDao.findByNome(nome);
    }
}