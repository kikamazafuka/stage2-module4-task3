package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.regex.Pattern;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    public LexemeParser() {
    }

    public LexemeParser(AbstractTextParser nextParser) {
        super(nextParser);
    }
    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        Pattern lexemePattern = Pattern.compile(LEXEME_REGEX);

        String[] lexemes = lexemePattern.split(string);
        for (String lexeme : lexemes) {
            if (!lexeme.isEmpty()) {
                TextComponent wordComponent = new TextComponent(TextComponentType.WORD);
                abstractTextComponent.add(wordComponent);
                if (nextParser != null) {
                    nextParser.parse(wordComponent, lexeme);
                }
            }
        }
    }

    public static String getWordRegex() {
        return WORD_REGEX;
    }
}
