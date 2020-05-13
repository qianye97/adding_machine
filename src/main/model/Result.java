package main.model;

public class Result {
    private Integer sum;
    private Integer carry;

    public Result(int sum, int carry) {
        this.sum = sum;
        this.carry = carry;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getCarry() {
        return carry;
    }

    public void setCarry(Integer carry) {
        this.carry = carry;
    }

    @Override
    public String toString() {
        return "Result{" +
                "sum=" + sum +
                ", carry=" + carry +
                '}';
    }
}
