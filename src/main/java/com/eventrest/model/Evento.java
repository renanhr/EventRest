package com.eventrest.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author renan
 */
@Entity
@Table(name = "Evento")
@XmlRootElement(name = "evento")
@NamedQueries({
    @NamedQuery(name = "Evento.findByNome", query = "select e from Evento e where e.nome = :nome")
})
public class Evento extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFim;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    private Local local;

    @OneToMany(mappedBy = "evento")
    private Set<Convite> convites;

    @OneToMany(mappedBy = "evento")
    private Set<Atividade> atividades;

    public Evento() {
    }

    public Evento(String nome, Date dataInicio, Date dataFim, Pessoa pessoa, Local local) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.pessoa = pessoa;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Set<Convite> getConvites() {
        return convites;
    }

    public void setConvites(Set<Convite> convites) {
        this.convites = convites;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }

    @Override
    public void updateParameters(Object entity) {
        Evento other = (Evento) entity;
        this.nome = other.nome;
        this.dataInicio = other.dataInicio;
        this.dataFim = other.dataFim;
        this.pessoa = other.pessoa;
        this.local = other.local;
        this.convites = other.convites;
        this.atividades = other.atividades;
    }
}
