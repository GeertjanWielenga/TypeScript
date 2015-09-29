package org.netbeans.ts.lexer;

import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;

@LanguageRegistration(mimeType = "text/x-ts")
public class ECMAScriptLanguage extends DefaultLanguageConfig {

    @Override
    public Language getLexerLanguage() {
	return new ECMAScriptLanguageHierarchy().language();
    }

    @Override
    public String getDisplayName() {
	return "ECMAScript";
    }

}
