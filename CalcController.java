import java.sql.SQLOutput;

public class CalcController implements InputListener {

    private BasicView view;
    private CalcBrain brain;
    public CalcController(BasicView view, CalcBrain brain) {
        this.view = view;
        this.brain = brain;
        brain.registerDisplayChanged(view);
        view.registerInputListener(this);
    }

    public void start() {
        view.show();
    }

    @Override
    public void inputChanged(String input) {
        char ch = input.charAt(0);
        if(Character.isDigit(ch)){
            brain.pushDigit(input);
        }else if("+-*/".indexOf(ch) != -1){
            brain.pushOperator(ch);
        }else if(ch == '='){
            brain.evaluate();
        }

    }
}
