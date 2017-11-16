package com.eventrest.dao;

import com.eventrest.dao.impl.ConviteDAOImpl;
import com.eventrest.dao.impl.EventoDAOImpl;
import com.eventrest.dao.impl.PessoaDAOImpl;
import com.eventrest.model.Convite;
import com.eventrest.model.Evento;
import com.eventrest.model.Pessoa;
import com.eventrest.model.Resposta;
import java.util.List;
import javax.inject.Inject;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author renan
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({ConviteDAOImpl.class, EventoDAOImpl.class, PessoaDAOImpl.class})
public class ConviteTest {

    private static Convite SIM;

    static {
        SIM = new Convite(Resposta.SIM, null, null);
    }

    @Inject
    private ConviteDAO conviteDAO;

    @Inject
    private EventoDAO eventoDAO;

    @Inject
    private PessoaDAO pessoaDAO;

    private List<Evento> eventos;
    private List<Pessoa> pessoas;

    @Before
    public void buscaObjetos() {
        eventos = eventoDAO.findAll();
        pessoas = pessoaDAO.findAll();
    }

    @Test
    public void injectionTest() {
        Assert.assertNotNull(eventoDAO);
        Assert.assertNotNull(pessoaDAO);
        Assert.assertNotNull(conviteDAO);
    }

    @Test
    public void saveTest() {
        Assert.assertFalse(eventos.isEmpty());
        Assert.assertFalse(pessoas.isEmpty());

        List<Convite> convites = conviteDAO.findAll();
        if (convites == null || convites.isEmpty()) {
            SIM.setEvento(eventos.get(0));
            SIM.setPessoa(pessoas.get(0));
            conviteDAO.save(SIM);
        }
        convites = conviteDAO.findAll();
        Assert.assertNotNull(convites);
        Assert.assertFalse(convites.isEmpty());
    }
}
