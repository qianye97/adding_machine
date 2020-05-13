package main.adder;

import main.gate.AndGate;
import main.gate.Inverter;
import main.gate.OrGate;
import main.model.Wire;

/**
 * 半加器
 */
public class HalfAdder {
    private Wire d = new Wire("d");
    private Wire e = new Wire("e");
    public HalfAdder(Wire a, Wire b, Wire s, Wire c) {
        new Inverter(c, e);
        new AndGate(a, b, c);
        new OrGate(a, b, d);
        new AndGate(d, e, s);
    }

}
