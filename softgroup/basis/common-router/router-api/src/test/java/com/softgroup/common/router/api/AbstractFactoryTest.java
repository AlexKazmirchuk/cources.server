package com.softgroup.common.router.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author AlexKazmirchuk
 * @since 10.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonRouterApiCfgIT.class})
public class AbstractFactoryTest {

    @Autowired
    private AbstractFactory<RequestHandler> requestHandlerFactory;

    @Test
    public void someTest(){
        System.out.println("working");
    }


}
