/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bdluts;

/**
 *
 * @author HP
 */
import java.sql.ResultSet;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DbUtils {

    public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector<String> columnNames = new Vector<>();

            // Mendapatkan nama kolom
            for (int column = 1; column <= numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column));
            }

            // Mendapatkan semua baris
            Vector<Vector<Object>> rows = new Vector<>();

            while (rs.next()) {
                Vector<Object> newRow = new Vector<>();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }

                rows.addElement(newRow);
            }

            return new DefaultTableModel(rows, columnNames);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}

