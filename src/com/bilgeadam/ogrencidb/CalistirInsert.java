package com.bilgeadam.ogrencidb;

import org.postgresql.core.Query;

import java.sql.*;

public class CalistirInsert {
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");

            Connection conn =
                    DriverManager.getConnection("jdbc:postgresql://localhost:5432/odb","postgres","postgres");

            Statement st = conn.createStatement();

            int sonuc = st.executeUpdate("insert into ogrenci (ad, soyad) values('İrem','Günay')");

            if (sonuc > 0)
                System.out.println("UPDATE: " + sonuc + "\n" + "Başarılıyla insert edildi.");
            else
                System.out.println("WARN: Insert edilemedi.");

            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
        }

    }
}
