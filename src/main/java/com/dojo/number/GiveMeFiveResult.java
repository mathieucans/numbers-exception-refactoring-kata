package com.dojo.number;

public class GiveMeFiveResult implements MagicResult {
    @Override
    public void accept(MagicResultVisitor visitor) {
        visitor.visit(this);
    }

}
