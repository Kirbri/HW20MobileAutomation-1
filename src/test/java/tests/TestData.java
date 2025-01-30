package tests;

import lombok.Getter;

public class TestData {
    @Getter
    public static String user = System.getProperty("user"),
            key = System.getProperty("key");
}