/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventrest.service.impl;

import com.eventrest.dao.ConviteDAO;
import com.eventrest.dao.DAO;
import com.eventrest.model.Convite;
import com.eventrest.service.ConviteService;
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
 * @author renan
 */
@ManagedBean
@Path("/convite")
public class ConviteServiceImpl extends GenericCRUDRestService<Convite> implements ConviteService {

    private static final Logger LOG = LoggerFactory.getLogger(ConviteServiceImpl.class);

    @Inject
    private ConviteDAO conviteDAO;

    public ConviteServiceImpl() {
        super(Convite.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Convite> list) {
        return new GenericEntity<List<Convite>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return conviteDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }
}
