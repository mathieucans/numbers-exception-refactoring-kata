package com.dojo.number;

public class DevilResult extends MessageResult{
    public DevilResult(String message) {
        super(message);
    }

    @Override
    public void accept(MagicResultVisitor visitor) {
        visitor.visit(this);
    }
}
