package com.galaykovskiy.pojo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

import static com.galaykovskiy.tools.Caster.*;

@Slf4j
public class POJOWorker {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("content", "Step 1");
        map1.put("expected", "Expected Result 1");

        Map<String, String> map2 = new HashMap<>();
        map2.put("content", "Step 2");
        map2.put("expected", "Expected Result 2");

        List<Map<String, String>> stepsSeparated = new ArrayList<>();
        stepsSeparated.add(map1);
        stepsSeparated.add(map2);

        List<String> gitList = new ArrayList<>();
        gitList.add("commit");
        gitList.add("owner");

        Map<String, List<String>> refs = new HashMap<>();
        refs.put("git", gitList);

        Map<String, Object> pojoFile = new HashMap<>();
        pojoFile.put("title", "This is a test case");
        pojoFile.put("type_id", 1);
        pojoFile.put("priority_id", 3);
        pojoFile.put("estimate", "3m");
        pojoFile.put("refs", refs);
        pojoFile.put("custom_steps_separated", stepsSeparated);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(POJOWorker.builderPOJO(pojoFile)));
    }

    public static RailStepResult builderPOJO(Map<String, Object> pojoFile) {
        RailStepResult result = new RailStepResult();

        try {
            result.setTitle(pojoFile.get("title").toString());
            result.setTypeId(Integer.parseInt(pojoFile.get("type_id").toString()));
            result.setPriorityId(Integer.parseInt(pojoFile.get("priority_id").toString()));
            result.setEstimate(pojoFile.get("estimate").toString());

            Refs refs = new Refs();
            Map<String, List<String>> refsMap = castObjectToMap(pojoFile.get("refs"));
            refs.setGit(new ArrayList<>(refsMap.get("git")));

            result.setRefs(refs);

            List<CustomStepsSeparated> stepsResultList = new ArrayList<>();
            List<Map<String, String>> stepsList = castObjectToList(pojoFile.get("custom_steps_separated"));

            for (Map<String, String> step : stepsList) {
                CustomStepsSeparated stepsSeparated = new CustomStepsSeparated();
                stepsSeparated.setContent(step.get("content"));
                stepsSeparated.setExpected(step.get("expected"));

                stepsResultList.add(stepsSeparated);
            }
            result.setCustomStepsSeparated(stepsResultList);

        } catch (ArrayIndexOutOfBoundsException e) {
            log.error("Something went wrong!".concat(e.getMessage()));
            throw new ArrayIndexOutOfBoundsException();
        } catch (ClassCastException e) {
            log.error("Oops... Class cast exception".concat(e.getMessage()));
            throw new ClassCastException();
        }

        return result;
    }
}
