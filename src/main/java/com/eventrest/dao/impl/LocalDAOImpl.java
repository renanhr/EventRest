package com.eventrest.dao.impl;

import com.eventrest.dao.GenericDAO;
import com.eventrest.dao.LocalDAO;
import com.eventrest.model.Local;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author renanhr
 */
@ApplicationScoped
public class LocalDAOImpl extends GenericDAO<Local, Long> implements LocalDAO {

    private static final Logger LOG = LoggerFactory.getLogger(LocalDAOImpl.class);

    public LocalDAOImpl() {
        super(Local.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public List<Local> findByDescricao(String descricao) {
        Query query = getEntityManager().createNamedQuery("Local.findByDescricao", Local.class);
        query.setParameter("descricao", descricao);
        return query.getResultList();
    }

    @Override
    public Local findByPoints(String latitude, String longitude) {
        Query query = getEntityManager().createNamedQuery("Local.findByPoints", Local.class);
        query.setParameter("latitude", latitude);
        query.setParameter("longitude", longitude);
        List<Local> locais = query.getResultList();
        if (locais == null || locais.isEmpty()) {
            return null;
        } else if (locais.size() > 1) {
            throw new NonUniqueResultException();
        } else {
            return locais.get(0);
        }
    }

}
