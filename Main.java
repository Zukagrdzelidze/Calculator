public class Main {
    public static void main(String[] args) {
        CalcBrain calcBrain = new CalcBrain();
        BasicView swingView = new SwingView();
        CalcController calcController = new CalcController(swingView, calcBrain);

        calcController.start();
    }


}