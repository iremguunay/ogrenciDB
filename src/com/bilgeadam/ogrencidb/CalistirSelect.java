package com.bilgeadam.ogrencidb;

import java.sql.*;

public class CalistirSelect {

    public static void main(String[] args) {

        try {
            // Class.forName ile jdbc driverın ilgili classını gösteriyoruz
            Class.forName("org.postgresql.Driver");

            //Connection objesi oluşturuyoruz
            Connection conn =
                    DriverManager.getConnection("jdbc:postgresql://localhost:5432/odb","postgres","postgres");

            //Statement ile sql sorgusu yazabiliriz
            Statement st = conn.createStatement();

            //Select sonucu ResultSet'e açılır
            ResultSet rs = st.executeQuery("select no, ad, soyad, kredi from ogrenci order by kredi desc");

            //rs üzerinde while döneriz
            while (rs.next()) {
                System.out.println("No:" + rs.getInt("no") + " " +
                        "Ad:" + rs.getString(2) + " " +
                        "Soyad:" + rs.getString("soyad") + " " +
                        "Kredi:" + rs.getDouble("kredi") + "\n");
            }
            rs.close();

            st.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
        }
    }

}
