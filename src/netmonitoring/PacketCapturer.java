/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netmonitoring;

/**
 *
 * @author Gabe
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode;

public class PacketCapturer {
    private static PcapHandle handle;
    private static PcapNetworkInterface device;

    public static void startCapturing() {
        try {
            handle = device.openLive(65536, PromiscuousMode.PROMISCUOUS, 10);
            handle.loop(-1, new PacketHandler());
        } catch (PcapNativeException e) {
            e.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(PacketCapturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void stopCapturing() {
        handle.breakLoop();
        handle.close();
    }
}

