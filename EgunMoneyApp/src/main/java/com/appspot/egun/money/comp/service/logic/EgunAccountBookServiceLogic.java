package com.appspot.egun.money.comp.service.logic;

import java.util.logging.Logger;

import javax.jdo.PersistenceManager;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.MoneyBook;
import com.appspot.egun.money.comp.service.EgunAccountBookService;
import com.appspot.egun.money.comp.utility.PMFProvider;

@Component
public class EgunAccountBookServiceLogic
    implements EgunAccountBookService
{
    /** �ΰ� */
    private static final Logger logger = Logger.getLogger( EgunAccountBookServiceLogic.class.getSimpleName() );

    private PersistenceManager pm = null;

    @Override
    public Long createEgunAccountBook( MoneyBook accountBook )
        throws RuntimeException
    {

        pm = PMFProvider.getPersistenceManager();

        try
        {
            pm.makePersistent( accountBook );
        }
        catch ( Exception e )
        {
            throw new RuntimeException( e );
        }
        finally
        {
            if ( !pm.isClosed() )
            {
                pm.close();
            }
        }
        return accountBook.getOid();
    }
}
