/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import java.util.List;

/**
 *
 * @author LUID1.7
 */
public class CursoDao extends GenericDao<Curso> implements ICursoDao {
    
    //Busca por nome
    @Override
    public List<Curso> findByNome(String nome) {
        return entityManager.createQuery("SELECT c FROM Curso c WHERE c.nome LIKE :nome", Curso.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }
}
