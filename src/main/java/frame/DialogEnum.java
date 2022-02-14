package frame;

import javax.swing.*;
import java.awt.*;

public enum DialogEnum {
    SPRING() {
        @Override
        public BaseCardDialog getCardFrame(JFrame frame) {
            return new SpringDialog(frame);
        }

        @Override
        public Color getColor() {
            return new Color(120,130,189);
        }
    },
    JAVA() {
        @Override
        public BaseCardDialog getCardFrame(JFrame frame) {
            return new JavaDialog(frame);
        }

        @Override
        public Color getColor() {
            return Color.LIGHT_GRAY;
        }
    },
    OOP() {
        @Override
        public BaseCardDialog getCardFrame(JFrame frame) {
            return new OopDialog(frame);
        }

        @Override
        public Color getColor() {
            return new Color(39,190,176);
        }
    };

    public abstract BaseCardDialog getCardFrame(JFrame frame);
    public abstract Color getColor();

    private BaseCardDialog cardFrame;
}
