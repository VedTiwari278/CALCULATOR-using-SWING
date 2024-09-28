import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class calculator extends JFrame {
    JLabel l1, l2, l3, l4;
    JButton b1;
    JTextField T1, T2;
    JComboBox<String> operatorBox;

    public calculator() {}

    public calculator(String s) {
        super(s);
    }
    public void setcomponents() {
        l1 = new JLabel("CALCULATOR");
        l2 = new JLabel("First Number");
        T1 = new JTextField();
        l3 = new JLabel("Second Number");
        T2 = new JTextField();
        l4 = new JLabel();
        b1 = new JButton("Calculate");
        // Combo box for selecting operators
        String[] operators = {"+", "-", "*", "/","%"};
        operatorBox = new JComboBox<>(operators);     
        l4.setBackground(Color.DARK_GRAY);
        T1.setBorder(null);
        T2.setBorder(null);
        l1.setFont(new Font("Roman",Font.BOLD,18));
        l1.setForeground(Color.BLUE);
        add(l1);
        add(l2);
        add(T1);
        add(l3);
        add(T2);
        add(b1);
        add(operatorBox);
        add(l4);
        setLayout(null);
        l1.setBounds(90,50, 200, 20);
        l2.setBounds(50, 80, 100, 20);
        T1.setBounds(150, 80, 100, 20);
        l3.setBounds(50, 130, 100, 20);
        T2.setBounds(150, 130, 100, 20);
        operatorBox.setBounds(50, 180, 50, 20);  // For operator selection
        b1.setBounds(150, 180, 100, 20);
        l4.setBounds(50, 240, 200, 20);

        b1.addActionListener(new Handler());
    }

    class Handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int a = Integer.parseInt(T1.getText());
                int b = Integer.parseInt(T2.getText());
                String operator = (String) operatorBox.getSelectedItem();
                int result = 0;
                String error = null;

                switch (operator) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if (b != 0) {
                            result = a / b;
                        } else {
                            error = "Cannot divide by zero!";
                        }
                        break;
                        case "%":
                        result = a % b;
                        break;
                }

                if (error == null) {
                    l4.setText("Result: " + result);
                } else {
                    l4.setText(error);
                }
            } catch (NumberFormatException ex) {
                l4.setText("Please enter valid numbers!");
            }
        }
    }

    public static void main(String[] args) {
        calculator gf = new calculator("Calculator");
        gf.setcomponents();
        gf.setSize(300, 350);
        gf.setVisible(true);
        gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
