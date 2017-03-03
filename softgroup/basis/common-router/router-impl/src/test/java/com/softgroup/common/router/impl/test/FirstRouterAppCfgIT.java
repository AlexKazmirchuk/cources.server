package com.softgroup.common.router.impl.test;

import com.softgroup.common.datamapper.configuration.DataMapperAppCfg;
import com.softgroup.common.router.impl.FirstRouter;
import com.softgroup.common.router.impl.configuration.FirstRouterAppCfg;
import com.softgroup.common.router.impl.test.configuration.RouterImplAppCfgTest;
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
@ContextConfiguration(classes = {FirstRouterAppCfg.class,
                                 RouterImplAppCfgTest.class,
                                 DataMapperAppCfg.class})
public class FirstRouterAppCfgIT {

    @Autowired
    private FirstRouter firstRouter;

    @Test
    public void test(){
        assertThat(firstRouter, CoreMatchers.notNullValue());
        assertEquals(FirstRouter.class, firstRouter.getClass());
    }
}
