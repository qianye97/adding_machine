package main;

/**
 * 非门
 */
public class Inverter {
    private Wire a;
    private Wire output;

    public Inverter(Wire a, Wire output) {
        this.a = a;
        this.output = output;
        registerAction();
    }

    public void getNewOutput() {
        output.setSignal(logicInvert(a));
    }

    public void registerAction() {
        a.acceptAction(()-> Schedule.afterDelay(Test.schedule, 2, this::getNewOutput));
    }

    public int logicInvert(Wire a) {
        return a.getSignal() == 0 ? 1 : 0;
    }
}
