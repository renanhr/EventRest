package com.eventrest.dao.impl;

import com.eventrest.dao.EventoDAO;
import com.eventrest.dao.GenericDAO;
import com.eventrest.model.Evento;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author renanhr
 */
@ApplicationScoped
public class EventoDAOImpl extends GenericDAO<Evento, Long> implements EventoDAO {

    private static final Logger LOG = LoggerFactory.getLogger(EventoDAOImpl.class);

    public EventoDAOImpl() {
        super(Evento.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public List<Evento> findByNome(String nome) {
        Query query = getEntityManager().createNamedQuery("Evento.findByNome", Evento.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }

}
