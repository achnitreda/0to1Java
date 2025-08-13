public class DoOp {
    public static void main(String[] args) {
        System.out.println(DoOp.operate(new String[]{"1","+","2"}));
        System.out.println(DoOp.operate(new String[]{"1","-","1"}));
        System.out.println(DoOp.operate(new String[]{"1","%","0"}));
        System.out.println(DoOp.operate(args));
    }
    public static String operate(String[] args) {
        if (args == null || args.length != 3) return "Error";
        String op = args[1];
        double num1, num2;
        num1 = Double.parseDouble(args[0]); 
        num2 = Double.parseDouble(args[2]); 
        double res;
        if (op == "+") {
            res = num1+num2;
        }else if (op == "-") {
            res = num1-num2;
        }else if (op == "*") {
            res = num1*num2;
        }else if (op == "/") {
            res = num1/num2;
        }else if (op == "%") {
            if (num2 == 0) {
                return "Error";
            }
            res = num1%num2;
        }else {
            return "Error";
        }
        return String.format("%.0f",res);
    }
}