package com.test.api.scripts;

import com.jayway.restassured.response.Response;
import com.test.api.endpoints.TestEndpoints;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.HashMap;


public class TestAPI {
    private Logger logger = LogManager.getLogger();

    @SuppressWarnings("unchecked")
    @Test(priority = 1)
    public void testBookByIsbnAPI() {
        logger.info("Started executing testBookByIsbnAPI");

        String url = "https://flask-bookread-app.herokuapp.com/";
        HashMap isbns = new HashMap() {
            {
                put("0679889175", "First Test");
                put("1439199353", "The Boston Girl");
                put("0330247042", "Marathon Man");
                put("0385743602", "Calamity");
                put("0689862210", "The View from Saturday");
                put("0440237556", "The Dark Highlander");
                put("0061969559", "I Am Number Four");
                put("184756190X", "A Girl Like You");
                put("1561797464", "A Christmas Carol");
                put("006440174X", "Good Night, Mr. Tom");
            }
        };

        for (Object isbn : isbns.keySet()
        ) {

            Response response = TestEndpoints.getBookByIsbn(url, isbn.toString(), 200);
            Assert.assertEquals(response.jsonPath().get("title").toString(), isbns.get(isbn));

        }


    }

}
