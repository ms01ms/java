package com.hillel;

import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name = "invalidCredentials")
    public Object[][] getInvalidCredentials() {
        return new Object[][]{
                {"test@hillel.ua", "1111"},
                {"test@hillel.ua", "1234"}
        };
    }
}

