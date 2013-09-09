/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.teste.DomainModel;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import sun.reflect.misc.ConstructorUtil;

/**
 *
 * @author aluno
 */
@Entity
@Table(name="Email")


 public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length=200)
    private String nome;
   
    @ManyToOne(cascade= CascadeType.MERGE, fetch=FetchType.EAGER)
    Tipo tipo;
 
          
    @OneToMany(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="email")
    List<Email> emails;  
    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="dataNascimento")
    private Date dataNascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
    
    
    

       public void addEmail(Email e) {
           if(!emails.contains(e)){
               emails.add(e);
           }
       }
       
       public void removeEmail(Email e) {
           if(emails.contains(e)){
               emails.remove(e);
           }
       }
 
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.teste.DomainModel.Pessoa1[ id=" + id + " ]";
    }
    
}
