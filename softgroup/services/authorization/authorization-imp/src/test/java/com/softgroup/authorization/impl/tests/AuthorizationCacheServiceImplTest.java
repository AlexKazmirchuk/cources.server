package com.softgroup.authorization.impl.tests;

import com.softgroup.authorization.impl.cache.AuthorizationCacheService;
import com.softgroup.authorization.impl.cache.AuthorizationCacheServiceImpl;
import com.softgroup.authorization.impl.cache.RegistrationCacheData;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author AlexKazmirchuk
 * @since 20.03.17.
 */
public class AuthorizationCacheServiceImplTest {

    private RegistrationCacheData cacheData1;
    private RegistrationCacheData cacheData2;

    private AuthorizationCacheService cacheService = new AuthorizationCacheServiceImpl();

    @Before
    public void init(){
        cacheData1 = new RegistrationCacheData();
        cacheData1 = new RegistrationCacheData();
        cacheData1.setAuthCode("233");
        cacheData1.setDeviceID("sffdag34434");
        cacheData1.setLocale("en_EN");
        cacheData1.setPhoneNumber("35663434");

        cacheData2 = new RegistrationCacheData();
        cacheData2.setAuthCode("243433");
        cacheData2.setDeviceID("sdkl4903");
        cacheData2.setLocale("ru_RU");
        cacheData2.setPhoneNumber("0500403443");
    }

    @Test
    public void saveMethodTest(){
        cacheService.save("first", cacheData1);
        cacheService.save("second", cacheData2);
        cacheService.save("third",null);
        cacheService.save(null,cacheData1);
        cacheService.save(null,null);
    }

    @Test
    public void getMethodTest(){
        saveMethodTest();

        RegistrationCacheData retrieveData1 = cacheService.get("first");
        RegistrationCacheData retrieveData2 = cacheService.get("second");
        RegistrationCacheData retrieveData3 = cacheService.get("third");
        RegistrationCacheData retrieveData4 = cacheService.get(null);

        assertThat(cacheData1,is(retrieveData1));
        assertThat(cacheData2,is(retrieveData2));
        assertThat(null,is(retrieveData3));
        assertThat(null,is(retrieveData4));

        assertThat(retrieveData1,is(cacheData1));
        assertThat(retrieveData2,is(cacheData2));
        assertThat(retrieveData3,nullValue());
        assertThat(retrieveData4,nullValue());
    }
}
