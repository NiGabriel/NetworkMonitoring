/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netmonitoring;

/**
 *
 * @author Gabe
 */


import org.pcap4j.core.PacketListener;
import org.pcap4j.packet.IpV4Packet;
import org.pcap4j.packet.IpV6Packet;
import org.pcap4j.packet.Packet;
import org.pcap4j.packet.namednumber.IpNumber;

public class PacketHandler implements PacketListener {

  public void gotPacket(Packet packet) {
    if (packet.contains(IpV4Packet.class)) {
      IpV4Packet ipPacket = packet.get(IpV4Packet.class);
      String srcIP = ipPacket.getHeader().getSrcAddr().getHostAddress();
      String dstIP = ipPacket.getHeader().getDstAddr().getHostAddress();
      
      String protocol = ipPacket.getHeader().getProtocol().name();
      
      String info = "Source IP: " + srcIP + ", Destination IP: " + dstIP + ", Protocol: " + protocol;
      UserInterface.displayPacketInfo(info);
      DataStorage.storePacketInfo(srcIP, dstIP, protocol);
      
      // check for misuse
      if (isMisusing(srcIP)) {
        AdWarning.sendWarning(srcIP);
      }
    }
    else if (packet.contains(IpV6Packet.class)) {
      IpV6Packet ipPacket = packet.get(IpV6Packet.class);
      String srcIP = ipPacket.getHeader().getSrcAddr().getHostAddress();
      String dstIP = ipPacket.getHeader().getDstAddr().getHostAddress();
      
      String protocol = ipPacket.getHeader().getNextHeader().name();
      
      String info = "Source IP: " + srcIP + ", Destination IP: " + dstIP + ", Protocol: " + protocol;
      UserInterface.displayPacketInfo(info);
      DataStorage.storePacketInfo(srcIP, dstIP, protocol);
      
      // check for misuse
      if (isMisusing(srcIP)) {
        AdWarning.sendWarning(srcIP);
      }
    }
  }
  
  private boolean isMisusing(String srcIP) {
    // implementation to check if the IP is misusing the network
    // ...
    return false;
  }
}