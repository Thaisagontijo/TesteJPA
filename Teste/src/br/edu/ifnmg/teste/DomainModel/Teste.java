/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.teste.DomainModel;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
        
       
        Tipo tipo = new Tipo ("Aluno");
        
        try {
            transacao.begin();
            
            
            manager.persist(tipo);
            
            
            Pessoa p = new Pessoa();
            
            p.setNome("Ana Luiza");
            
            p.setDataNascimento(new Date());
            p.setTipo(tipo);
            Email email = new Email("thaisagontijo@jhgghjgjhgj");
            
            p.addEmail(email);
            manager.persist(p);
            
            transacao.commit();
            
            
            
        } 
        catch (Exception e) {
            transacao.rollback();
            System.out.println(e.getMessage());
        }
   
    Query consulta = manager.createQuery("Select p from Pessoa p");
    List<Pessoa> pessoas = consulta.getResultList();
    
    for(Pessoa p: pessoas){
    System.out.println(p.getNome());
    }
    
    } 

}
