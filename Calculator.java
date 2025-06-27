import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener
{
    private JTextField display;
    private String currentInput = "";
    private String fullOperation = "";

    public Calculator()
    {
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));
        setupDisplay();
        setupButtons();
        setVisible(true);
    }

    private void setupDisplay()
    {
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        add(display, BorderLayout.NORTH);
    }

    private void setupButtons()
    {
        JPanel buttonPanel = new JPanel(new GridLayout(4, 3, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttonLabels = 
        {
            "7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            "0", "C", "="
        };

        for (String label : buttonLabels)
        {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);

            if (label.equals("C"))
            {
                button.setBackground(new Color(255, 150, 150));
            }
            else if (label.equals("="))
            {
                button.setBackground(new Color(150, 255, 150));
            }
            else
            {
                button.setBackground(new Color(240, 240, 240));
            }

            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        if (command.matches("[0-9]"))
        {
            currentInput += command;
            fullOperation += command;
            display.setText(currentInput);
        }
        else if (command.equals("C"))
        {
            currentInput = "";
            fullOperation = "";
            display.setText("");
        }
        else if (command.equals("="))
        {
            display.setText("= " + currentInput);
            currentInput = "";
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            new Calculator();
        });
    }
}
