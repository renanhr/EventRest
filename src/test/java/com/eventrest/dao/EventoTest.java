package com.eventrest.dao;

import com.eventrest.dao.impl.EventoDAOImpl;
import com.eventrest.dao.impl.LocalDAOImpl;
import com.eventrest.dao.impl.PessoaDAOImpl;
import com.eventrest.model.Evento;
import com.eventrest.model.Local;
import com.eventrest.model.Pessoa;
import java.util.Date;
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
@AdditionalClasses({EventoDAOImpl.class, PessoaDAOImpl.class, LocalDAOImpl.class})
public class EventoTest {

    private static Evento HAPPY_HOLY;

    @Inject
    private EventoDAO eventoDAO;

    @Inject
    private PessoaDAO pessoaDAO;

    @Inject
    private LocalDAO localDAO;

    private List<Pessoa> pessoas;
    private List<Local> locais;

    static {
        HAPPY_HOLY = new Evento("Happy Holy", new Date(), new Date(), null, null);
    }

    @Before
    public void prepareObjects() {
        pessoas = pessoaDAO.findAll();
        locais = localDAO.findAll();
    }

    @Test
    public void injectionTest() {
        Assert.assertNotNull(eventoDAO);
        Assert.assertNotNull(pessoaDAO);
        Assert.assertNotNull(localDAO);
    }

    @Test
    public void saveTest() {
        Assert.assertFalse(pessoas.isEmpty());
        Assert.assertFalse(locais.isEmpty());

        List<Evento> finded = eventoDAO.findByNome(HAPPY_HOLY.getNome());
        if (finded == null || finded.isEmpty()) {
            HAPPY_HOLY.setPessoa(pessoas.get(0));
            HAPPY_HOLY.setLocal(locais.get(0));
            eventoDAO.save(HAPPY_HOLY);
        }
        finded = eventoDAO.findByNome(HAPPY_HOLY.getNome());
        Assert.assertNotNull(finded);
        Assert.assertFalse(finded.isEmpty());
    }
}
