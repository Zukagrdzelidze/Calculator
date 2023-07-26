import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingView extends BasicView{

    public static final int CALC_WIDTH = 300;
    public static final int CALC_HEIGHT = 300;

    private JFrame frame;
    private JTextField inputField;
    private InputListener inputListener;


    public SwingView(){
        frame = new JFrame();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int x = (screenSize.width - CALC_WIDTH)/2;
        int y = (screenSize.height - CALC_HEIGHT)/2;

        frame.setSize(CALC_WIDTH, CALC_HEIGHT);
        frame.setLocation(x, y);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout border = new BorderLayout();
        border.setHgap(10);
        border.setVgap(10);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setFont(new Font("Times new Roman", Font.BOLD, 20));
        inputField.setEditable(false);
        inputPanel.add(inputField);
        
        JPanel valueButtonPanel = new JPanel(getGridLayout(4, 3));
        for(int i = 0; i <= 9; i++){
            valueButtonPanel.add(getCalcButton("" + i));
        }
        valueButtonPanel.add(getCalcButton("."));
        valueButtonPanel.add(getCalcButton("="));

        JPanel OperatorButtonPanel = new JPanel(getGridLayout(4, 1));
        String[] operators = {"+", "-", "*", "/"};
        for(String str : operators){
            OperatorButtonPanel.add(getCalcButton(str));
        }
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(valueButtonPanel, BorderLayout.CENTER);
        frame.add(OperatorButtonPanel, BorderLayout.EAST);
    }



    private GridLayout getGridLayout(int rows, int cols) {
        GridLayout gridLayout = new GridLayout(rows, cols);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);
        return gridLayout;
    }

    public JButton getCalcButton(String str){
        JButton button = new JButton(str);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fireInputChanged(actionEvent.getActionCommand());
            }
        });
        return button;
    }

    @Override
    public void show() {
        frame.setVisible(true);
    }


    @Override
    public void DisplayChanged(String display) {
        inputField.setText(display);
    }
}
