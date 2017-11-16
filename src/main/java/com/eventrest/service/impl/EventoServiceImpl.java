package com.eventrest.service.impl;

import com.eventrest.dao.DAO;
import com.eventrest.dao.EventoDAO;
import com.eventrest.model.Evento;
import com.eventrest.service.EventoService;
import com.eventrest.service.GenericCRUDRestService;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fernando
 */

@ManagedBean
@Path("/evento")
public class EventoServiceImpl extends GenericCRUDRestService<Evento> implements EventoService {

    private static final Logger LOG = LoggerFactory.getLogger(EventoServiceImpl.class);

    @Inject
    private EventoDAO eventoDAO;

    public EventoServiceImpl() {
        super(Evento.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Evento> list) {
        return new GenericEntity<List<Evento>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return eventoDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

}
