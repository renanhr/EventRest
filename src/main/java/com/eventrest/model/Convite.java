/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventrest.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author renan
 */
@Entity
@Table(name = "Convite")
@XmlRootElement(name = "convite")
public class Convite extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private Resposta resposta;

    @ManyToOne
    private Evento evento;

    @ManyToOne
    private Pessoa pessoa;

    public Convite() {
    }

    public Convite(Resposta resposta, Evento evento, Pessoa pessoa) {
        this.resposta = resposta;
        this.evento = evento;
        this.pessoa = pessoa;
    }

    @Override
    public void updateParameters(Object entity) {
        Convite other = (Convite) entity;
        this.resposta = other.resposta;
        this.evento = other.evento;
        this.pessoa = other.pessoa;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
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
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.evento);
        hash = 97 * hash + Objects.hashCode(this.pessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Convite other = (Convite) obj;
        if (!Objects.equals(this.evento, other.evento)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }

}
