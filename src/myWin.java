import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class myWin extends JFrame {

    private MyHintTextField myJPlaceholder;
    private JTextArea myTextArea;

    class MyHintTextField extends JTextField {
        String hint;

        public MyHintTextField(String hint) {
            this.hint = hint;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (getText().isEmpty()) {
                g.drawString(hint, 4, 16);
            }
        }
    }

    myWin() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Мой \"Чат\" на Java (Swing)");
        setBounds(1100, 500, 400, 400);
        JButton jBtn = new JButton("ok");

        myJPlaceholder = new MyHintTextField("Напишите сообщение...");
        myTextArea = new JTextArea(0, 0);

        myTextArea.setLineWrap(true);
        myTextArea.setEditable(false);

        JScrollPane jsp = new JScrollPane(myTextArea);
        add(jsp, BorderLayout.CENTER);

        jBtn.addActionListener((ActionEvent e) -> {
            sendMessage();
        });

        myJPlaceholder.addActionListener(e -> sendMessage());

        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.add(jBtn, BorderLayout.EAST);
        upperPanel.add(myJPlaceholder, BorderLayout.CENTER);
        add(upperPanel, BorderLayout.NORTH);
        Font font = new Font("Roboto", Font.PLAIN, 16);
        myTextArea.setFont(font);

        setVisible(true);
    }

    void sendMessage() {

        if (!myJPlaceholder.getText().isEmpty()) {
            myTextArea.append(myJPlaceholder.getText() + "\n");
        }

        myJPlaceholder.setText("");
        myJPlaceholder.grabFocus();
    }
}