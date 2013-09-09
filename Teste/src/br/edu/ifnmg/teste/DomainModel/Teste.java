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
        
       
        Tipo tipo = new Tipo ("Pessoa Fisica");
        
        try {
            transacao.begin();
            
            
            manager.persist(tipo);
            transacao.commit();
            
            } 
        catch (Exception e) {
            transacao.rollback();
        }
        
        try{
            transacao.begin();
            
            Pessoa p = new Pessoa();
            
            p.setNome("Thaisa");
            
            p.setDataNascimento(new Date());
            p.setTipo(tipo);
            Email email = new Email("thaisagontijo@jhgghjgjhgj");
            
            p.addEmail(email);
            manager.persist(p);
            
            transacao.commit();
            
            
            
        } 
        catch (Exception e) {
            transacao.rollback();
        }
        
    }
}
