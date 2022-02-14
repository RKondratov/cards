package frame;

import javax.swing.*;

public class OopDialog extends BaseCardDialog {
    private static final int TICKET_NUMBER = 5;

    public OopDialog(JFrame frame) {
        super(frame, "OOP");
    }

    @Override
    protected int getRandomTicket() {
        return (int) (Math.random() * TICKET_NUMBER + 1);
    }
}
