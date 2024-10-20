import javax.swing.*;
import java.awt.event.*;
public class WindowListenerExample {

    public static void main(String[] args){
        JFrame frame = new JFrame("Window Listener Example");

        JLabel label = new JLabel("Lakukan operasi pada jendela");
        label.setBounds(50, 50, 300, 30);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                label.setText("Window opened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                label.setText("Window closing");
            }


            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windows Closed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                label.setText("Window Minimized");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                label.setText("Window Restored");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                label.setText("Window Activated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                label.setText("Window Deactivated");
            }
        });

        frame.add(label);
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
