package com.galaykovskiy.pojo;

import java.util.List;

public class RailStepResult {
    private String title;
    private int typeId;
    private int priorityId;
    private String estimate;

    private Refs refs;
    private List<CustomStepsSeparated> customStepsSeparated;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }

    public Refs getRefs() {
        return refs;
    }

    public void setRefs(Refs refs) {
        this.refs = refs;
    }

    public void setCustomStepsSeparated(List<CustomStepsSeparated> customStepsSeparated) {
        this.customStepsSeparated = customStepsSeparated;
    }

    public List<CustomStepsSeparated> getCustomStepsSeparated() {
        return customStepsSeparated;
    }
}
