/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sedanur
 */
public class Tablo extends AbstractTableModel{
    private int satirSayisi;
    private int kolonSayisi;
    private ResultSet resultSet;
    private ArrayList veri=new ArrayList();
    public Tablo(ResultSet resultSet) throws Exception
    {
        setResultSet(resultSet);
    }
    public void setResultSet(ResultSet resultSet) throws Exception {
        this.resultSet = resultSet;
        ResultSetMetaData metaData = resultSet.getMetaData();
        satirSayisi = 0;
        kolonSayisi = metaData.getColumnCount();
        while (resultSet.next()) {
            Object[] row = new Object[kolonSayisi];
            for (int j = 0; j < kolonSayisi; j++) {
                row[j] = resultSet.getObject(j + 1);
            }
            veri.add(row);
            satirSayisi++;
        }
    }
    public int getRowCount() {
        return satirSayisi;
    }
    public int getColumnCount() {
        return kolonSayisi;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
       Object[] row=(Object[]) veri.get(rowIndex);
       return row[columnIndex];
    }
    @Override
    public String getColumnName(int columnIndex) {
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            return metaData.getColumnName(columnIndex + 1);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    
}

