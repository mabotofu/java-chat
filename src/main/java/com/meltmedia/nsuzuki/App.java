package com.meltmedia.nsuzuki;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hello world!
 *
 */
public class App implements Runnable, ActionListener {

    private JTextArea chatLog;
    private JTextArea chatInput;

//    public void run() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("SpringDemo3");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        chatInput = new JTextArea(5,20);
//        JButton sendBtn = new JButton("Send");
//        chatLog = new JLabel("<html>Hello,<br> world!</html>");
//        String fakeList[] = {
//                "Kyle",
//                "Wolf",
//                "Ben"
//        };
//        JList onlineList = new JList(fakeList);
//
//        //Set up the content pane.
//        Container contentPane = frame.getContentPane();
//        SpringLayout layout = new SpringLayout();
//        contentPane.setLayout(layout);
//
//        //Create and add the components.
//        JLabel label = new JLabel("Label: ");
//        JTextField textField = new JTextField("Text field", 15);
//        contentPane.add(label);
//        contentPane.add(textField);
//
//        //Adjust constraints for the label so it's at (5,5).
//        layout.putConstraint(SpringLayout.WEST, label,
//                5,
//                SpringLayout.WEST, contentPane);
//
////        layout.putConstraint(SpringLayout.NORTH, label,
////                5,
////                SpringLayout.NORTH, contentPane);
//
//        //Adjust constraints for the text field so it's at
//        //(<label's right edge> + 5, 5).
//        layout.putConstraint(SpringLayout.WEST, textField,
//                5,
//                SpringLayout.EAST, label);
//
//        layout.putConstraint(SpringLayout.NORTH, textField,
//                5,
//                SpringLayout.NORTH, contentPane);
//
//        //Adjust constraints for the content pane: Its right
//        //edge should be 5 pixels beyond the text field's right
//        //edge, and its bottom edge should be 5 pixels beyond
//        //the bottom edge of the tallest component (which we'll
//        //assume is textField).
//        layout.putConstraint(SpringLayout.EAST, contentPane,
//                5,
//                SpringLayout.EAST, textField);
//
//        layout.putConstraint(SpringLayout.SOUTH, contentPane,
//                5,
//                SpringLayout.SOUTH, textField);
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }

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
        f.setVisible(true);
    }

//    public void run() {
//        // Create the window
//        JFrame f = new JFrame ("Hello, World!");
//        chatInput = new JTextArea(5,20);
//        JButton sendBtn = new JButton("Send");
//        chatLog = new JLabel("<html>Hello,<br> world!</html>");
//
//        sendBtn.addActionListener(this);
//        // Sets the behavior for when the window is closed
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setSize(500, 350);
//        // add a label and a button
//        f.getContentPane().add(chatLog);
//        f.getContentPane().add(sendBtn);
//        f.getContentPane().add(chatInput);
//
//        String listData[] = {
//          "test1",
//          "test2",
//          "test3"
//        };
//        f.getContentPane().add(new JList(listData));
//
//        // Add a layout manager so that the button is not placed on top of the label
//        f.getContentPane().setLayout(new FlowLayout());
//        // arrange the components inside the window
//        //f.pack();
//        //By default, the window is not visible. Make it visible.
//        f.setVisible(true);
//    }

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
