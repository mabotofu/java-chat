package com.meltmedia.nsuzuki;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class App implements Runnable, ActionListener {

    private JTextArea chatLog;
    private JTextArea chatInput;


    public void run() {

        JFrame f = new JFrame ("Hello, World!");
        JComponent panel = new JPanel();
        chatInput = new JTextArea(5,20);
        JButton sendBtn = new JButton("Send");
        chatLog = new JTextArea("<html>Hello,\n world!</html>");
        chatLog.setEnabled(false);
        String fakeList[] = {
                "Kyle",
                "Wolf",
                "Ben"
        };
        JList onlineList = new JList(fakeList);
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sendBtn.addActionListener(this);
        // Turn on automatically adding gaps between components
        layout.setAutoCreateGaps(true);

        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup().
                addComponent(chatLog).
                addComponent(chatInput).
                addComponent(sendBtn));

        hGroup.addGroup(layout.createParallelGroup().
                addComponent(onlineList));

        layout.setHorizontalGroup(hGroup);

        // Create a sequential group for the vertical axis.
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup(
                GroupLayout.Alignment.BASELINE).
                  addComponent(chatLog).
                  addComponent(onlineList));

        vGroup.addGroup(layout.createParallelGroup(
                GroupLayout.Alignment.BASELINE).
                  addComponent(chatInput));

        vGroup.addGroup(layout.createParallelGroup(
                GroupLayout.Alignment.BASELINE).
                addComponent(sendBtn));

        layout.setVerticalGroup(vGroup);
        f.getContentPane().add(panel);
        f.pack();
        f.setVisible(true);
    }


    public static void main(String[] args) {
        App se = new App();
        // Schedules the application to be run at the correct time in the event queue.
        SwingUtilities.invokeLater(se);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.print("called");
        try {

            chatLog.setText(
                    chatLog.getDocument().getText(0, chatLog.getDocument().getLength())
                    + "\n"
                    + chatInput.getText(0,chatInput.getDocument().getLength()) );

            chatInput.setText("");

        } catch (BadLocationException e) {
            System.out.print( "something bad happened");
        }
    }
}
