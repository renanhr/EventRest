package com.eventrest.dao.impl;

import com.eventrest.dao.AtividadeDAO;
import com.eventrest.dao.GenericDAO;
import com.eventrest.model.Atividade;
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
public class AtividadeDAOImpl extends GenericDAO<Atividade, Long> implements AtividadeDAO {

    private static final Logger LOG = LoggerFactory.getLogger(AtividadeDAOImpl.class);

    public AtividadeDAOImpl() {
        super(Atividade.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public List<Atividade> findByNome(String nome) {
        Query query = getEntityManager().createNamedQuery("Atividade.findByNome", Atividade.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }
}
