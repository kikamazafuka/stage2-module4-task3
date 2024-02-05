package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends AbstractTextParser{

    // Write your code here!

    public WordParser() {
    }

    public WordParser(AbstractTextParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        Pattern wordPattern = Pattern.compile(LexemeParser.getWordRegex());
        Matcher matcher = wordPattern.matcher(string);
        while (matcher.find()) {
            TextComponent symbolComponent = new TextComponent(TextComponentType.SYMBOL);
            abstractTextComponent.add(symbolComponent);
            for (char symbol : matcher.group().toCharArray()) {
                symbolComponent.add(new SymbolLeaf(symbol));
            }
        }
        if (nextParser != null) {
            nextParser.parse(abstractTextComponent, string);
        }
    }
}
