package com.eventrest.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author renanhr
 */
@Entity
@Table(name = "Pessoa")
@XmlRootElement(name = "pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findByNome", query = "select p from Pessoa p where p.nome = :nome")
})
public class Pessoa extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String rg;

    @Column(length = 255, nullable = false)
    private String formacao;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nascimento;

    @OneToMany(mappedBy = "pessoa")
    private Set<Convite> convites;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, String rg, String formacao, Date nascimento) {
        this.nome = nome;
        this.email = email;
        this.rg = rg;
        this.formacao = formacao;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormmacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Set<Convite> getConvites() {
        return convites;
    }

    public void setConvites(Set<Convite> convites) {
        this.convites = convites;
    }

    @Override
    public void updateParameters(Object entity) {
        Pessoa other = (Pessoa) entity;
        this.nome = other.nome;
        this.email = other.email;
        this.nascimento = other.nascimento;
        this.formacao = other.formacao;
        this.rg = other.rg;
        this.convites = other.convites;
    }

}
