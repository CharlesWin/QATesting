package com.galaykovskiy.pojo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.galaykovskiy.tools.Caster.*;

@Slf4j
public class POJOBuilder {
    public RailStepResult setupPOJO(Map<String, Object> pojoFile) {
        try {
            List<CustomStepsSeparated> stepsSeparatedList = new ArrayList<>();
            List<Map<String, String>> stepsList = castObjectToList(pojoFile.get("custom_steps_separated"));

            for (Map<String, String> step : stepsList)
                stepsSeparatedList.add(CustomStepsSeparated.newBuilder()
                        .setContent(step.get("content"))
                        .setExpected(step.get("expected"))
                        .build());

            return RailStepResult.newBuilder()
                    .setTitle(pojoFile.get("title").toString())
                    .setTypeId(Integer.parseInt(pojoFile.get("type_id").toString()))
                    .setPriorityId(Integer.parseInt(pojoFile.get("priority_id").toString()))
                    .setEstimate(pojoFile.get("estimate").toString())
                    .setRefs(Refs.newBuilder()
                            .setGit(castObjectToList(castObjectToMap(pojoFile.get("refs")).get("git")))
                            .build())
                    .setCustomStepsSeparated(stepsSeparatedList)
                    .build();
        } catch (ArrayIndexOutOfBoundsException e) {
            log.error("Something went wrong!".concat(e.getMessage()));
            throw new ArrayIndexOutOfBoundsException();
        } catch (ClassCastException e) {
            log.error("Oops... Class cast exception".concat(e.getMessage()));
            throw new ClassCastException();
        }
    }
}
