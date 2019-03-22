package com.dojo.number;

public class OddResult extends MessageResult{

    public OddResult(String message) {
        super(message);
    }

    @Override
    public void accept(MagicResultVisitor visitor) {
        visitor.visit(this);
    }
}
