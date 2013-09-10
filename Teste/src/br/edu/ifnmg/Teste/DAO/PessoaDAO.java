/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Teste.DAO;

import br.edu.ifnmg.teste.DomainModel.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public class PessoaDAO {
    
    //Gerenciador de entidade
    
    protected EntityManager manager;
    private EntityManagerFactory factory;
    
    public PessoaDAO() {
        factory = Persistence.createEntityManagerFactory("UnidadePersistencia");
        manager = factory.createEntityManager();
    }    
    
    //Salvar Pessoa
      
    public boolean Salvar(Pessoa obj){
        
       EntityTransaction transacao = manager.getTransaction(); 
   
    
        
        try{
            
           transacao.begin();
            
            
            manager.persist(obj);
            return true;
            
        }
        catch(Exception e){
            e.printStackTrace();
            transacao.rollback();
            return  false;
        }
        
    }
    //Abrir o objeto
        
     public Pessoa Abrir(long id){
         
         
        try{
            
          Pessoa obj = (Pessoa) manager.find(Pessoa.class, id);
          return obj;
            
                     
        }
        catch(Exception e){
            e.printStackTrace();
            return  null;
        }
        
    }
         
       public boolean Excluir(Pessoa obj){
           EntityTransaction transacao = manager.getTransaction();
           
           try{
               //Inicia a transação
               
              transacao.begin();
              
              //Remove o obj
              manager.remove(obj);
              //confirma 
              transacao.commit();
              
              return true;
               }
        catch(Exception e){
            transacao.rollback();
            return false;
              
           }
           
       }  
              
            
        
        
  
    
    
}
