import javax.swing.*;
import java.awt.event.*;

public class KeyListenerExample {
    public static void main(String[] args){
        JFrame frame = new JFrame("KeyListener example");

        JLabel label = new JLabel("tekan tombol pada keyboard");
        label.setBounds(50,50,300,30);

        JTextField textField = new JTextField();
        textField.setBounds(50,100,300,30);

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                label.setText("Key Typed: " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                label.setText("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
            }
        });

        frame.add(textField);
        frame.add(label);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
