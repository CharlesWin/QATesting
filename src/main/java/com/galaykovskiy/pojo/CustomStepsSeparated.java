package com.galaykovskiy.pojo;

public class CustomStepsSeparated {
    private String content;
    private String expected;

    public String getContent() {
        return content;
    }

    public String getExpected() {
        return expected;
    }

    public static Builder newBuilder() {
        return new CustomStepsSeparated().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setContent(String content) {
            CustomStepsSeparated.this.content = content;
            return this;
        }

        public Builder setExpected(String expected) {
            CustomStepsSeparated.this.expected = expected;
            return this;
        }

        public CustomStepsSeparated build() {
            return CustomStepsSeparated.this;
        }
    }
}
