package ch1511core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ch1511 extends Frame {
    static int x = 230, y = 40;
    JPanel panel1 = new MyPanel();


    class MyPanel extends JPanel {
        public MyPanel() {
            addKeyListener(new KeyListener() {
                public void keyPressed(KeyEvent e) {
                    int keycode = e.getKeyCode();
                    switch (keycode) {
                        case KeyEvent.VK_LEFT:
                            x -= 20;
                            repaint();
                            break;
                        case KeyEvent.VK_RIGHT:
                            x += 20;
                            repaint();
                            break;
                        case KeyEvent.VK_UP:
                            y -= 20;
                            repaint();
                            break;
                        case KeyEvent.VK_DOWN:
                            y += 20;
                            repaint();
                            break;
                    }
                }

                @Override
                public void keyReleased(KeyEvent arg0) {
                    //System.out.println("키가 눌려졌다! ");
                }

                @Override
                public void keyTyped(KeyEvent arg0) {
                    //System.out.println("키가 눌려졌다! ");
                }
            });
            this.requestFocus();
            setFocusable(true);
        }

        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.black);
            g.fillOval(x, y, 40, 40);
        }

    }

    public ch1511() {
        setSize(500, 400);
        setLayout(new BorderLayout());

        // 패널설정
        panel1.setSize(500, 400);
        panel1.setBackground(Color.white);

        // 최종 실행
        add(panel1, BorderLayout.CENTER);
        setVisible(true);
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.out.println("Closed");
                e.getWindow().dispose();
            }
        });
    }




}

