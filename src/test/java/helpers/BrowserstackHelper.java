package helpers;

import tests.TestData;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class BrowserstackHelper {
    public static URL getBrowserstackUrl() {
        try {
            return new URL("https://" + TestData.getUser() + ":" + TestData.getKey()
                    + "@hub-cloud.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBrowserstackVideoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .auth().basic(TestData.getUser(), TestData.getKey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
