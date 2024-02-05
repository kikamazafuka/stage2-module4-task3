package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
        throw new UnsupportedOperationException("ChainParserBuilder constructor is not intended for use without parsers." +
                " Use setParser method to add parsers.");
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        // Write your code here!
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        for (int i = 0; i < parsers.size() - 1; i++) {
            parsers.get(i).setNextParser(parsers.get(i + 1));
        }
        return parsers.get(0);
    }
}
