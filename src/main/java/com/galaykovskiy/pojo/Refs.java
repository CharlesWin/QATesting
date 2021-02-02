package com.galaykovskiy.pojo;

import java.util.List;

public class Refs {
    private List<String> git;

    public List<String> getGit() {
        return git;
    }

    public static Builder newBuilder() {
        return new Refs().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setGit(List<String> git) {
            Refs.this.git = git;
            return this;
        }

        public Refs build() {
            return Refs.this;
        }
    }
}
