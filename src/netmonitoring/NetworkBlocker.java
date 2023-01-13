/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netmonitoring;

/**
 *
 * @author Gabe
 */
import java.io.IOException;

public class NetworkBlocker {
    public static void blockIP(String ip) {
        // command to block the IP address on the operating system
        // Windows:
        // Runtime.getRuntime().exec("netsh advfirewall firewall add rule name=BlockIP dir=in action=block remoteip=" + ip);
        // Linux:
        // Runtime.getRuntime().exec("iptables -A INPUT -s " + ip + " -j DROP");
        // Mac:
        // Runtime.getRuntime().exec("ipfw add deny src-ip " + ip);

    }
}

