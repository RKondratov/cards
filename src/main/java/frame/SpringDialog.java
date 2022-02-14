package frame;

import javax.swing.*;

public class SpringDialog extends BaseCardDialog {
    private static final int TICKET_NUMBER = 10;
    public SpringDialog(JFrame frame) {
        super(frame, "SPRING");
    }

    @Override
    protected int getRandomTicket() {
        return (int) (Math.random() * TICKET_NUMBER + 1);
    }
}
