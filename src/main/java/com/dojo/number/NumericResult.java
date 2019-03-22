package com.dojo.number;

import java.util.Objects;

public class NumericResult implements MagicResult {
    private int result;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumericResult that = (NumericResult) o;
        return result == that.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    public NumericResult(int result) {
        this.result = result;
    }

    @Override
    public void accept(MagicResultVisitor visitor) {
        visitor.visit(this);
    }

    public int getResult() {
        return result;
    }
}
