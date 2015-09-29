package org.netbeans.ts.lexer;

import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

class ECMAScriptNBLexer implements Lexer<ECMAScriptTokenId> {

    private LexerRestartInfo<ECMAScriptTokenId> info;

    private ECMAScriptLexer lexer;

    public ECMAScriptNBLexer(LexerRestartInfo<ECMAScriptTokenId> info) {
        this.info = info;
        AntlrCharStream charStream = new AntlrCharStream(info.input(), "ECMAScriptEditor");
        lexer = new ECMAScriptLexer(charStream);
    }

    @Override
    public Token<ECMAScriptTokenId> nextToken() {
        org.antlr.v4.runtime.Token token = lexer.nextToken();
        if (token.getType() != lexer.EOF) {
            ECMAScriptTokenId tokenId = ECMAScriptLanguageHierarchy.getToken(token.getType());
            return info.tokenFactory().createToken(tokenId);
        }
        return null;
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }

}
