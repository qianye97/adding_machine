package main;

/**
 * 或门
 */
public class OrGate {
    private Wire a;
    private Wire b;
    private Wire output;

    public OrGate(Wire a, Wire b, Wire output) {
        this.a = a;
        this.b = b;
        this.output = output;
        registerAction();
    }

    public void getNewOutput() {
        output.setSignal(logicOr(a, b));
    }

    public void registerAction() {
        a.acceptAction(()-> Schedule.afterDelay(Test.schedule, 5, this::getNewOutput));
        b.acceptAction(()-> Schedule.afterDelay(Test.schedule, 5, this::getNewOutput));
    }

    public int logicOr(Wire a, Wire b) {
        return a.getSignal() | b.getSignal();
    }
}
