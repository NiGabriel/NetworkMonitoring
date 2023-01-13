/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netmonitoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataStorage {
  private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/network_traffic";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "root";

  public static void storePacketInfo(String srcIP, String dstIP, String protocol) {
    Connection dbConnection = null;
    PreparedStatement preparedStatement = null;

    String insertTableSQL = "INSERT INTO packets"
        + "(src_ip, dst_ip, protocol) VALUES"
        + "(?,?,?)";

    try {
      dbConnection = getDBConnection();
      preparedStatement = dbConnection.prepareStatement(insertTableSQL);

      preparedStatement.setString(1, srcIP);
      preparedStatement.setString(2, dstIP);
      preparedStatement.setString(3, protocol);

      // execute insert SQL stetement
      preparedStatement.executeUpdate();

      System.out.println("Record is inserted into packets table!");

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      if (preparedStatement != null) {
        try {
          preparedStatement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (dbConnection != null) {
        try {
          dbConnection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private static Connection getDBConnection() {
    Connection dbConnection = null;
    try {
      Class.forName(DB_DRIVER);
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
    try {
      dbConnection = DriverManager.getConnection(
          DB_CONNECTION, DB_USER, DB_PASSWORD);
      return dbConnection;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return dbConnection;
  }
}

