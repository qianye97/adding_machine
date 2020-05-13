package main.adder;

import main.gate.OrGate;
import main.model.Wire;

public class FullAdder {
    private Wire s = new Wire("s");
    private Wire c1 = new Wire("c1");
    private Wire c2 = new Wire("c2");
    public FullAdder(Wire a, Wire b, Wire c_in, Wire sum, Wire c_out) {
        new HalfAdder(b, c_in, s, c1);
        new HalfAdder(a, s, sum, c2);
        new OrGate(c1, c2, c_out);
    }
}
