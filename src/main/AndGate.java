package main;

/**
 * 与门
 */
public class AndGate {
    private Wire a;
    private Wire b;
    private Wire output;

    public AndGate(Wire a, Wire b, Wire output) {
        this.a = a;
        this.b = b;
        this.output = output;
        registerAction();
    }

    public void getNewOutput() {
        output.setSignal(logicAnd(a, b));
    }

    public void registerAction() {
        a.acceptAction(()->Schedule.afterDelay(Test.schedule, 3, this::getNewOutput));
        b.acceptAction(()->Schedule.afterDelay(Test.schedule, 3, this::getNewOutput));
    }

    public int logicAnd(Wire a, Wire b) {
        return a.getSignal() & b.getSignal();
    }
}
