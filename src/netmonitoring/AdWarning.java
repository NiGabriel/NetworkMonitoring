/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netmonitoring;

/**
 *
 * @author Gabe
 */
import javax.swing.JOptionPane;

public class AdWarning {
  public static void sendWarning(String ip) {
    JOptionPane.showMessageDialog(null, "Warning: The IP address " + ip + " is misusing the network. Please stop any illegal activity or your IP will be blocked.", "Network Misuse Warning", JOptionPane.WARNING_MESSAGE);
  }
}

