package tests;

import com.shecodes.controllers.AccountController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;



class AccountControllerTest {

    @Test
    void checkBalance() throws SQLException {
        Assert.assertEquals(200,AccountController.checkBalance(1,1234));
    }
}