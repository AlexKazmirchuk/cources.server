package com.softgroup.main.router;

import com.softgroup.main.router.configuration.FirstRouterAppCfg;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author AlexKazmirchuk
 * @since 28.02.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FirstRouterAppCfg.class})
public class MainRouterAppCfgIT {

    @Autowired
    private FirstRouter firstRouter;

    @Test
    public void test(){
        assertThat(firstRouter, CoreMatchers.notNullValue());
        assertEquals(FirstRouter.class, firstRouter.getClass());
    }
}
