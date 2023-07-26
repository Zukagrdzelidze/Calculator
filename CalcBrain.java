public class CalcBrain {

    private char operator;
    private String display;
    private String prevDisplay;
    private DisplayChange displayChange;
    private boolean clear;
    public CalcBrain(){
        display = "0";
        prevDisplay = "0";
        clear = false;
    }

    public void pushOperator(char operator){
        this.operator = operator;
        prevDisplay = display;
        display = "0";
        clear = false;
    }

    public void pushDigit(String digit){
        if(clear){
            display = "" + digit.charAt(0);
            clear = false;
        }else if(Integer.parseInt(display) == 0){
            display = "" + digit.charAt(0);
            System.out.println("apaa");
        }else{
            display = display + digit.charAt(0);
        }
        fireDisplayChanged(display);
    }

    public void registerDisplayChanged(DisplayChange displayChange){
        this.displayChange = displayChange;
    }

    private void fireDisplayChanged(String display) {
        displayChange.DisplayChanged(display);
    }

    public void evaluate(){
        double first = Double.valueOf(display);
        double second = Double.valueOf(prevDisplay);
        double result = 0;
        switch (operator){
            case '+' : result = first + second; break;
            case '-' : result = second - first; break;
            case '*' : result = first * second; break;
            case '/' : result = second / first; break;
        }
        String resultStr = String.valueOf(result);
        display = resultStr;
        clear = true;
        fireDisplayChanged(resultStr);
    }


}
