/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventrest.dao.impl;

import com.eventrest.dao.ConviteDAO;
import com.eventrest.dao.GenericDAO;
import com.eventrest.model.Convite;
import javax.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author renan
 */
@ApplicationScoped
public class ConviteDAOImpl extends GenericDAO<Convite, Long> implements ConviteDAO {

    private static final Logger LOG = LoggerFactory.getLogger(ConviteDAOImpl.class);

    public ConviteDAOImpl() {
        super(Convite.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

}
