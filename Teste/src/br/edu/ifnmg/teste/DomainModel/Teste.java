/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.teste.DomainModel;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager manager;
        
        EntityManagerFactory factory;
        
        factory= Persistence.createEntityManagerFactory("UnidadePersistencia");
        manager = factory.createEntityManager();   
        
        EntityTransaction transacao = manager.getTransaction();
        
        try {
            transacao.begin();
            
            Pessoa p = new Pessoa();
            
            p.setNome("Thaisa");
            
            p.setDataNascimento(new Date());
            
            manager.persist(p);
            
            transacao.commit();
            
        } 
        catch (Exception e) {
            transacao.rollback();
        }
        
    }
}
