/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netmonitoring;

/**
 *
 * @author Gabe
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame {

  private static JTextArea textArea;
  private JButton startButton;
  private JButton stopButton;
  private JButton blockButton;

  public UserInterface() {
    setTitle("Network Monitor");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    textArea = new JTextArea();
    textArea.setEditable(false);

    startButton = new JButton("Start");
    startButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // start capturing packets
        PacketCapturer.startCapturing();
      }
    });

    stopButton = new JButton("Stop");
    stopButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // stop capturing packets
        PacketCapturer.stopCapturing();
      }
    });

    blockButton = new JButton("Block IP");
    blockButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String ip = JOptionPane.showInputDialog("Enter the IP address to block:");
        // block the specified IP address
        NetworkBlocker.blockIP(ip);
      }
    });

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(startButton);
    buttonPanel.add(stopButton);
    buttonPanel.add(blockButton);

    JScrollPane scrollPane = new JScrollPane(textArea);

    add(scrollPane, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
    setVisible(true);

    }

public static void displayPacketInfo(String info) {
    textArea.append(info + "\n");
  }


}

