package frame;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public abstract class BaseCardDialog extends JDialog {
    private static final String NEXT = "Далее";
    private static final String ERROR = "Ошибка";
    private static final String SHOW = "Показать ответ";
    private final JTextArea textArea = new JTextArea();
    final JButton button1 = new JButton(NEXT);
    final JButton button2 = new JButton(ERROR);
    final JButton button3 = new JButton(SHOW);

    public BaseCardDialog(JFrame frame, String title) throws HeadlessException {
        super(frame, title, true);
        setLocationRelativeTo(null);
        final Container container = getContentPane();
        final String[] ticket = {new String()};
        try {
            ticket[0] = getTicket(getClass());
            textArea.setText(ticket[0].split("\\|")[0]);
            textArea.setLineWrap(true);
            textArea.setBackground(DialogEnum.valueOf(title).getColor());
        } catch (IOException e) {
        }
        container.add(textArea);
        JPanel grid = new JPanel(new GridLayout(1, 10, 5, 0));

        Arrays.asList(button1, button2, button3).forEach(button -> {
            button.setFocusPainted(true);
            button.setContentAreaFilled(true);
            button.setBorderPainted(true);
            grid.add(button);
        });

        button1.addActionListener(actionEvent -> {
            textArea.setBackground(DialogEnum.valueOf(title).getColor());
            try {
                ticket[0] = getTicket(getClass());
                textArea.setText(ticket[0].split("\\|")[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        button2.addActionListener(actionEvent -> {
            textArea.setBackground(Color.RED);
        });

        button3.addActionListener(actionEvent -> {
            textArea.setText(ticket[0].split("\\|")[1]);
        });

        JPanel flow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        flow.add(grid);

        container.add(flow, BorderLayout.SOUTH);

        setSize(700, 350);
        setVisible(true);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private String getTicket(Class invoker) throws IOException {
        final String resource = String.format("%s/%s.txt", this.getClass().getSimpleName(), getRandomTicket());
        final URL res = invoker.getResource(resource);
        final File file;
        if (res.getProtocol().equals("jar")) {
            InputStream input = getClass().getResourceAsStream(resource);
            file = File.createTempFile("tempfile", ".tmp");
            try (OutputStream out = new FileOutputStream(file)) {
                int read;
                byte[] bytes = new byte[1024];
                while ((read = input.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                file.deleteOnExit();
            }
        } else {
            //this will probably work in IDE, but not from a JAR
            file = new File(res.getFile());
        }
        return Files.readString(Paths.get(file.getPath()));
    }

    abstract int getRandomTicket();
}
