package de.aypac.filenameconverter3;

import de.aypac.filenameconverter3.*;
import java.awt.Point;
import java.util.Hashtable;
import javax.swing.table.AbstractTableModel;

class SparseTableModel
        extends AbstractTableModel {

    private Hashtable lookup;
    private final int rows;
    private final int columns;
    private final String[] headers;

    public SparseTableModel(int rows, String[] columnHeaders) {
        if ((rows < 0) || (columnHeaders == null)) {
            throw new IllegalArgumentException("Invalid row count/columnHeaders");
        }
        this.rows = rows;
        this.columns = columnHeaders.length;
        this.headers = columnHeaders;
        this.lookup = new Hashtable();
    }

    public int getColumnCount() {
        return this.columns;
    }

    public int getRowCount() {
        return this.rows;
    }

    public String getColumnName(int column) {
        return this.headers[column];
    }

    public Object getValueAt(int row, int column) {
        return this.lookup.get(new Point(row, column));
    }

    public void setValueAt(Object value, int row, int column) {
        if ((this.rows < 0) || (this.columns < 0)) {
            throw new IllegalArgumentException("Invalid row/column setting");
        }
        if ((row < this.rows) && (column < this.columns)) {
            this.lookup.put(new Point(row, column), value);
        }
    }

    public String[] resolveUrl(String url) {
        String[] urlresolved = new String[2];
        if (url.contains("http://")) {
            String newurl = url.split("http://", 2)[1];
            urlresolved = newurl.split("/", 2);
        } else {
            urlresolved = url.split("/", 2);
        }
        if (urlresolved[1].equals("")) {
            urlresolved[1] = "/";
        }
        return urlresolved;
    }
}
