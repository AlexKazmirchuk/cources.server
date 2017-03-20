package com.softgroup.authorization.impl.tests;

import com.softgroup.authorization.impl.cache.AuthorizationCacheService;
import com.softgroup.authorization.impl.cache.RegistrationCacheData;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author AlexKazmirchuk
 * @since 20.03.17.
 */

public class AuthorizationCacheServiceTest {


    @Test
    public void saveAndGetMethodTest(){
        AuthorizationCacheService cacheService = new AuthorizationCacheService();

        RegistrationCacheData cacheData = new RegistrationCacheData();
        cacheData.setAuthCode(233);
        cacheData.setDeviceID("sffdag34434");
        cacheData.setLocale("en_EN");
        cacheData.setPhoneNumber("35663434");

        RegistrationCacheData cacheData2 = new RegistrationCacheData();
        cacheData2.setAuthCode(243433);
        cacheData2.setDeviceID("sdkl4903");
        cacheData2.setLocale("ru_RU");
        cacheData2.setPhoneNumber("0500403443");

        cacheService.save("first", cacheData);
        cacheService.save("second", cacheData2);

        RegistrationCacheData retrieveData = cacheService.get("first");
        RegistrationCacheData retrieveData2 = cacheService.get("second");

        assertThat(cacheData,is(retrieveData));
        assertThat(cacheData2,is(retrieveData2));
    }

}
