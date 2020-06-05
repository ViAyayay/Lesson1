import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    public CalculatorFrame(String title) {
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 350, 300, 300);

        setLayout(new GridLayout(5, 4));


        JTextField jtf = new JTextField("Result...");

        char[] chars = {'1', '2', '3', '+', '4', '5', '6', '-', '7', '8', '9', '*', 'C', '0', '=', '/'};
        for (int i = 0; i < chars.length; i++) {
            JButton jb = new JButton(String.valueOf(chars[i]));
            jb.addActionListener(new ButtonListener(jtf));
            add(jb);
        }

        add(jtf);
        setVisible(true);
    }
}
