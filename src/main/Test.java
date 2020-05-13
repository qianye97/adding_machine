package main;

/**
 * 测试用例
 */
public class Test {
    public static Schedule schedule = new Schedule();

    public static void main(String[] args) {
        Wire a = new Wire("a");
        probe(a, "a");
        Wire b = new Wire("b");
        probe(b, "b");
        Wire c_in = new Wire("c_in");
        probe(c_in, "c_in");
        Wire sum = new Wire("sum");
        probe(sum, "sum");
        Wire c_out = new Wire("c_out");
        probe(c_out, "c_out");
        FullAdder fullAdder = new FullAdder(a, b, c_in, sum, c_out);
        a.setSignal(1);
        b.setSignal(1);
        c_in.setSignal(1);
        Schedule.propogate(schedule);
        System.out.println(new Result(sum.getSignal(), c_out.getSignal()));
    }

    public static void probe(Wire wire, String name) {
        wire.acceptAction(()-> {
            System.out.println("导线" + wire.getName() + "接收到值： " + wire.getSignal());
        });
    }
}
