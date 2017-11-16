package com.eventrest.service.impl;

import com.eventrest.dao.DAO;
import com.eventrest.dao.LocalDAO;
import com.eventrest.model.Local;
import com.eventrest.service.GenericCRUDRestService;
import com.eventrest.service.LocalService;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author renanhr
 */
@ManagedBean
@Path("/local")
public class LocalServiceImpl extends GenericCRUDRestService<Local> implements LocalService {

    private static final Logger LOG = LoggerFactory.getLogger(LocalServiceImpl.class);

    @Inject
    private LocalDAO localDAO;

    public LocalServiceImpl() {
        super(Local.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Local> list) {
        return new GenericEntity<List<Local>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return localDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

}
