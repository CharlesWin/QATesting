package com.galaykovskiy.pojo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

@Slf4j
public class TestPOJO {
    private Gson gson;

    @BeforeClass
    public void initGson() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @DataProvider(name = "pojo")
    public Object[][] initData() {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("title", "This is a test case");
        map1.put("type_id", 1);
        map1.put("priority_id", 3);
        map1.put("estimate", "3m");
        map1.put("refs", setRefs("commit", "owner"));
        map1.put("custom_steps_separated", setCustomSteps(
                new String[]{"Step 1", "Expected Result 1"},
                new String[]{"Step 2", "Expected Result 2"}));

        Map<String, Object> map2 = new HashMap<>();
        map2.put("title", "Second test case");
        map2.put("type_id", 2);
        map2.put("priority_id", 25);
        map2.put("estimate", "1d");
        map2.put("refs", setRefs("push", "devops", "jenkins"));
        map2.put("custom_steps_separated", setCustomSteps(
                new String[]{"Step 1", "Current result"},
                new String[]{"Step 2", "Expected Patronum"},
                new String[]{"Step 3", "The end"}));

        return new Object[][]{
                {map1},
                {map2}
        };
    }

    @Test(dataProvider = "pojo")
    public void TestGeneral(Map<String, Object> pojoMap) {
        POJOBuilder pojo = new POJOBuilder();
        System.out.println(gson.toJson(pojo.setupPOJO(pojoMap)));
    }

    private List<Map<String, String>> setCustomSteps(String[]... customSteps) {
        List<Map<String, String>> stepsSeparated = new ArrayList<>();

        for (String[] step : customSteps) {
            Map<String, String> map = new HashMap<>();
            try {
                map.put("content", step[0]);
                map.put("expected", step[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                log.warn(e.getMessage());
            }
            stepsSeparated.add(map);
        }

        return stepsSeparated;
    }

    private Map<String, List<String>> setRefs(String... args) {
        Map<String, List<String>> refs = new HashMap<>();
        refs.put("git", new ArrayList<>(Arrays.asList(args)));
        return refs;
    }
}
