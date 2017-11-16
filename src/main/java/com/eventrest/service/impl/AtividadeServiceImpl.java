package com.eventrest.service.impl;

import com.eventrest.dao.AtividadeDAO;
import com.eventrest.dao.DAO;
import com.eventrest.model.Atividade;
import com.eventrest.service.AtividadeService;
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
 * @author renanhr
 */
@ManagedBean
@Path("/atividade")
public class AtividadeServiceImpl extends GenericCRUDRestService<Atividade> implements AtividadeService {

    private static final Logger LOG = LoggerFactory.getLogger(AtividadeServiceImpl.class);

    @Inject
    private AtividadeDAO atividadeDAO;

    public AtividadeServiceImpl() {
        super(Atividade.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Atividade> list) {
        return new GenericEntity<List<Atividade>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return atividadeDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

}
