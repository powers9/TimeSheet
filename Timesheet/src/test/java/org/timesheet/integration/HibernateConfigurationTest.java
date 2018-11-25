package org.timesheet.integration;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
/**
* 
* @author powers
*To test if we get the session factory from the presistance-beans.xml
*/
@ContextConfiguration(locations = "/persistence-beans.xml")
public class HibernateConfigurationTest extends AbstractJUnit4SpringContextTests{

	/**
	 * Inject session factory when the bean factory is ready
	 */
	@Autowired
    private SessionFactory sessionFactory;
 
    @Test
    public void testHibernateConfiguration() {
        // Spring IOC container instantiated and prepared sessionFactory
        assertNotNull (sessionFactory);
    }

}
