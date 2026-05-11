/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.dao;
import java.util.List;
/**
 *
 * @author LUID1.7
 */
public interface GenericIDao<T> {
    
    // Salvar/Criar um novo registo na base de dados
    T save(T entity);
    
    // Atualizar um registo existente
    T update(T entity);
    
    // Apagar um registo
    void delete(T entity);
    
    // Listar todos os registos dessa entidade
    List<T> findAll();
    
    // Encontrar um registo específico através do seu ID
    T findById(Long id);
    
}
