package fsm.domain;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Sarthak on 14-09-2016.
 */
public class TableData {
    int tableUid;
    String layoutId;
    int tableNumber;
    List<Desk> deskList;
    int[][] deskIds;
    int rows,columns;
    int topLeftX,topLeftY;
    String deskString;
    public int getTableUid() {
        return tableUid;
    }
    public TableData(){}

    public String getDeskString() {
        return deskString;
    }

    public void setDeskString(String deskString) {
        this.deskString = deskString;
    }

    public void setTableUid(int tableUid) {
        this.tableUid = tableUid;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public String getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(String layoutId) {
        this.layoutId = layoutId;
    }

    public TableData(int tableNumber, List<Desk> deskList, int[][] deskIds, int rows, int columns, int topLeftX, int topLeftY, String layoutId) {
        this.tableNumber = tableNumber;
        this.deskList = deskList;
        this.deskIds = deskIds;
        this.rows = rows;
        this.columns = columns;
        this.topLeftX=topLeftX;
        this.topLeftY=topLeftY;
        this.layoutId=layoutId;
        Gson gson=new Gson();
        deskString=gson.toJson(deskIds).toString();
    }

    public int getTopLeftX() {
        return topLeftX;
    }

    public void setTopLeftX(int topLeftX) {
        this.topLeftX = topLeftX;
    }

    public int getTopLeftY() {
        return topLeftY;
    }

    public void setTopLeftY(int topLeftY) {
        this.topLeftY = topLeftY;
    }

    public int[][] getDeskIds() {
        return deskIds;
    }

    public void setDeskIds(int[][] deskIds) {
        this.deskIds = deskIds;
    }

    public List<Desk> getDeskList() {
        return deskList;
    }

    public void setDeskList(List<Desk> deskList) {
        this.deskList = deskList;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
