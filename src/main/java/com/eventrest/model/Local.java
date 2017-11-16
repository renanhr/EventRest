package com.eventrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author renanhr
 */
@Entity
@Table(name = "Local")
@XmlRootElement(name = "local")
@NamedQueries({
    @NamedQuery(name = "Local.findByDescricao", query = "select l from Local l where l.descricao = :descricao"),
    @NamedQuery(name = "Local.findByPoints", query = "select l from Local l where l.latitude = :latitude and l.longitude = :longitude")
})
public class Local extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String descricao;

    @Column(length = 255, nullable = false)
    private String latitude;

    @Column(length = 255, nullable = false)
    private String longitude;

    public Local() {
    }

    public Local(String descricao, String latitude, String longitude) {
        this.descricao = descricao;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public void updateParameters(Object entity) {
        Local other = (Local) entity;
        this.descricao = other.descricao;
        this.latitude = other.latitude;
        this.longitude = other.longitude;
    }

}
