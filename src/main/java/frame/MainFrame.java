package frame;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MainFrame extends JFrame {
    private static final String HEAD = "Тема";
    private static final String JAVA = "Java";
    private static final String SPRING = "Spring";
    private static final String OOP = "OOP";

    public MainFrame() {
        super(HEAD);
        setLocationRelativeTo(null);
        final JButton button1 = new JButton(JAVA);
        final JButton button2 = new JButton(SPRING);
        final JButton button3 = new JButton(OOP);
        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        Arrays.asList(button1, button2, button3).forEach(button -> {
            button.setFocusPainted(true);
            button.setContentAreaFilled(true);
            button.setBorderPainted(true);
            button.addActionListener(actionEvent -> DialogEnum.valueOf(button.getText().toUpperCase()).getCardFrame(this));
            container.add(button);
        });
        setSize(240, 75);
        setResizable(false);
        setVisible(true);

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
