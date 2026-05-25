/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners.statements;

import org.junit.runners.model.Statement;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ExpectException
extends Statement {
    private Statement fNext;
    private final Class<? extends Throwable> fExpected;

    public ExpectException(Statement statement, Class<? extends Throwable> clazz) {
        this.fNext = statement;
        this.fExpected = clazz;
    }

    @Override
    public void evaluate() {
        boolean bl2;
        block3: {
            bl2 = false;
            try {
                this.fNext.evaluate();
                bl2 = true;
            }
            catch (Throwable throwable) {
                if (this.fExpected.isAssignableFrom(throwable.getClass())) break block3;
                String string = "Unexpected exception, expected<" + this.fExpected.getName() + "> but was<" + throwable.getClass().getName() + ">";
                throw new Exception(string, throwable);
            }
        }
        if (bl2) {
            throw new AssertionError((Object)("Expected exception: " + this.fExpected.getName()));
        }
    }
}

