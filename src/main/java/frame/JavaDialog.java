package frame;

import javax.swing.*;

public class JavaDialog extends BaseCardDialog {
    private static final int TICKET_NUMBER = 11;
    public JavaDialog(JFrame frame) {
        super(frame,"JAVA");
    }

    @Override
    protected int getRandomTicket() {
        return (int) (Math.random() * TICKET_NUMBER + 1);
    }
}
