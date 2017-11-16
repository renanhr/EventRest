package com.eventrest.dao;

import com.eventrest.dao.impl.LocalDAOImpl;
import com.eventrest.model.Local;
import javax.inject.Inject;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author renan
 */
@RunWith(CdiRunner.class)
@AdditionalClasses(LocalDAOImpl.class)
public class LocalTest {

    private static final Local PQ_EXP_MGA;
    private static final Local PQ_EXP_MGRI;
    private static final Local PQ_EXP_SAR;

    static {
        PQ_EXP_MGA = new Local("Parque de Exposições de Maringá", "23,9982", "45,9882");
        PQ_EXP_MGRI = new Local("Parque de Exposições de Mandaguari", "54,9332", "88,9876");
        PQ_EXP_SAR = new Local("Parque de Exposições de Sarandi", "66,9182", "12,9854");
    }

    @Inject
    private LocalDAO localDAO;

    @Test
    public void injectionTest() {
        Assert.assertNotNull(localDAO);
    }
    
    @Test
    public void saveTest() {
        Local finded = localDAO.findByPoints(PQ_EXP_MGA.getLatitude(), PQ_EXP_MGA.getLongitude());
        if(finded == null) {
            localDAO.save(PQ_EXP_MGA);
        }
        finded = localDAO.findByPoints(PQ_EXP_MGA.getLatitude(), PQ_EXP_MGA.getLongitude());
        Assert.assertNotNull(finded);
        Assert.assertNotNull(finded.getId());
        
        finded = localDAO.findByPoints(PQ_EXP_MGRI.getLatitude(), PQ_EXP_MGRI.getLongitude());
        if(finded == null) {
            localDAO.save(PQ_EXP_MGRI);
        }
        finded = localDAO.findByPoints(PQ_EXP_MGRI.getLatitude(), PQ_EXP_MGRI.getLongitude());
        Assert.assertNotNull(finded);
        Assert.assertNotNull(finded.getId());
        
        finded = localDAO.findByPoints(PQ_EXP_SAR.getLatitude(), PQ_EXP_SAR.getLongitude());
        if(finded == null) {
            localDAO.save(PQ_EXP_SAR);
        }
        finded = localDAO.findByPoints(PQ_EXP_SAR.getLatitude(), PQ_EXP_SAR.getLongitude());
        Assert.assertNotNull(finded);
        Assert.assertNotNull(finded.getId());
    }
}
