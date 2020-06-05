import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener, ResultCalc {
    private JTextField jTextField;

    public ButtonListener(JTextField jTextField) {
        this.jTextField = jTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton jButton = (JButton) e.getSource();
        char textButton = jButton.getText().charAt(0);
        if(jTextField.getText().equals("Result...")){jTextField.setText("");}
        if (textButton >= '0' && textButton <= '9') {
            ResultCalc.addNumeric(jButton.getText());
            jTextField.setText(jTextField.getText() + jButton.getText());
        }else if(textButton == 'C'){
            jTextField.setText("Result...");
            ResultCalc.clearNumeric();
        }else if(textButton == '='){
            jTextField.setText(String.valueOf(ResultCalc.counting()));
        }else{
            jTextField.setText(ResultCalc.setSign(textButton));
        }

    }

}
