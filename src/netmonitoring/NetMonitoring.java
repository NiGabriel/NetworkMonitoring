/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package netmonitoring;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode;
import org.pcap4j.core.Pcaps;

/**
 *
 * @author Gabe
 */


public class NetMonitoring {
    public static void main(String[] args) {
        try {
            List<PcapNetworkInterface> allDevs = Pcaps.findAllDevs();
            for (PcapNetworkInterface device : allDevs) {
                if (device.getName().equals("eth0")) {
                    PcapHandle handle = device.openLive(65536, PromiscuousMode.PROMISCUOUS, 10);
                    handle.loop(-1, new PacketHandler());
                }
            }
        } catch (PcapNativeException e) {
            e.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(NetMonitoring.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
