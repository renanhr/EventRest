package com.eventrest.service.impl;

import com.eventrest.dao.DAO;
import com.eventrest.dao.PessoaDAO;
import com.eventrest.model.Pessoa;
import com.eventrest.service.GenericCRUDRestService;
import com.eventrest.service.PessoaService;
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
@Path("/pessoa")
public class PessoaServiceImpl extends GenericCRUDRestService<Pessoa> implements PessoaService {

    private static final Logger LOG = LoggerFactory.getLogger(PessoaServiceImpl.class);

    @Inject
    private PessoaDAO pessoaDAO;

    public PessoaServiceImpl() {
        super(Pessoa.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Pessoa> list) {
        return new GenericEntity<List<Pessoa>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return pessoaDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

}
