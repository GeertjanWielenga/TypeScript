package org.netbeans.ts.lexer;

import java.util.*;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

public class ECMAScriptLanguageHierarchy extends LanguageHierarchy<ECMAScriptTokenId> {

    private static List<ECMAScriptTokenId> tokens = new ArrayList<ECMAScriptTokenId>();
    private static Map<Integer, ECMAScriptTokenId> idToToken = new HashMap<Integer, ECMAScriptTokenId>();

    static {
        TokenType[] tokenTypes = TokenType.values();
        for (TokenType tokenType : tokenTypes) {
            tokens.add(new ECMAScriptTokenId(tokenType.name(), tokenType.category, tokenType.id));
        }
        for (ECMAScriptTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    static synchronized ECMAScriptTokenId getToken(int id) {
        return idToToken.get(id);
    }

    protected synchronized Collection<ECMAScriptTokenId> createTokenIds() {
        return tokens;
    }

    protected synchronized Lexer<ECMAScriptTokenId> createLexer(LexerRestartInfo<ECMAScriptTokenId> info) {
        return new ECMAScriptNBLexer(info);
    }

    protected String mimeType() {
        return "text/x-ts";
    }
}