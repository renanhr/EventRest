package com.eventrest.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author renan
 */
@Entity
@Table(name = "Atividade")
@XmlRootElement(name = "atividade")
@NamedQueries({
    @NamedQuery(name = "Atividade.findByNome", query = "select q from Atividade q where q.nome = :nome")
})
public class Atividade extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(length = 255, nullable = false)
    private String descricao;

    @Column(length = 255, nullable = false)
    private String localDeInteresse;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dia;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horario;

    @ManyToOne
    private Evento evento;

    @ManyToOne
    private Pessoa pessoa;

    public Atividade() {
    }

    public Atividade(String nome, String descricao, String localDeInteresse, Date dia, Date horario, Evento evento, Pessoa pessoa) {
        this.nome = nome;
        this.descricao = descricao;
        this.localDeInteresse = localDeInteresse;
        this.dia = dia;
        this.horario = horario;
        this.evento = evento;
        this.pessoa = pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalDeInteresse() {
        return localDeInteresse;
    }

    public void setLocalDeInteresse(String localDeInteresse) {
        this.localDeInteresse = localDeInteresse;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public void updateParameters(Object entity) {
        Atividade other = (Atividade) entity;
        this.nome = other.nome;
        this.descricao = other.descricao;
        this.localDeInteresse = other.localDeInteresse;
        this.dia = other.dia;
        this.horario = other.horario;
        this.evento = other.evento;
        this.pessoa = other.pessoa;
    }

}
