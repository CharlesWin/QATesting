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

    public String getEstimate() {
        return estimate;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getPriorityId() {
        return priorityId;
    }

    public Refs getRefs() {
        return refs;
    }

    public List<CustomStepsSeparated> getCustomStepsSeparated() {
        return customStepsSeparated;
    }

    public static Builder newBuilder() {
        return new RailStepResult().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setTitle(String title) {
            RailStepResult.this.title = title;
            return this;
        }

        public Builder setTypeId(int typeId) {
            RailStepResult.this.typeId = typeId;
            return this;
        }

        public Builder setPriorityId(int priorityId) {
            RailStepResult.this.priorityId = priorityId;
            return this;
        }

        public Builder setEstimate(String estimate) {
            RailStepResult.this.estimate = estimate;
            return this;
        }

        public Builder setRefs(Refs refs) {
            RailStepResult.this.refs = refs;
            return this;
        }

        public Builder setCustomStepsSeparated(List<CustomStepsSeparated> customStepsSeparated) {
            RailStepResult.this.customStepsSeparated = customStepsSeparated;
            return this;
        }

        public RailStepResult build(){
            return RailStepResult.this;
        }
    }
}
