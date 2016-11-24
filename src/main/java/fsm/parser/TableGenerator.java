package fsm.parser;

import fsm.domain.Desk;
import fsm.domain.Floor;
import fsm.domain.Table;
import fsm.domain.UI.FloorObjects;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.*;

@Service
@RequestScope
public class TableGenerator { //Uses Connected Component Graph Algorithm

    private class Node {

        Desk desk;
        boolean visited;

        Node(Desk desk) {
            this.desk = desk;
        }

    }

    private class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    ArrayList<Node> nodes = new ArrayList<Node>();


    public void dfs(List<Desk> deskInCurrentTable, Node node, Point relativeCoordinates) {

        node.visited = true;
        node.desk.setTableRow(relativeCoordinates.y);
        node.desk.setTableCol(relativeCoordinates.x);

        deskInCurrentTable.add(node.desk);

        for (int i = 0; i <= 1; i++)
            for (int j = 0; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;

                Node nodeTraverse = findNeighbours(node.desk.getX() + i * node.desk.getWidth(), node.desk.getY() + j * node.desk.getHeight());

                if (nodeTraverse != null && !nodeTraverse.visited)
                    dfs(deskInCurrentTable, nodeTraverse, new Point(relativeCoordinates.x + i, relativeCoordinates.y + j));

            }

    }

    private Node findNeighbours(int x, int y) {
        for (Node temp : nodes) {
            if (temp.desk.getX() == x && temp.desk.getY() == y)
                return temp;
        }
        return null;
    }

    public List<Table> DFS_UTIL(FloorObjects floordData) {

        List<Table> tablesList = new ArrayList<Table>();

        List<Desk> deskList = new ArrayList<>(floordData.getDeskList());
        Floor floor = floordData.getFloor();

        sortDeskListActualCoordinates(deskList);  //sorting wrt actual coordinates

        for (Desk desk : deskList)
            nodes.add(new Node(desk));


        for (Node node : nodes) {
            if (!node.visited) {
                Table table = new Table();
                ArrayList<Desk> deskInCurrentTable = new ArrayList<>();
                dfs(deskInCurrentTable, node, new Point(0, 0));   // To get Desks associated with current table
                populatingTable(table, deskInCurrentTable, node, floor); // populating table object
                tablesList.add(table);                       //adding it in result
            }
        }
        return tablesList;
    }


    void populatingTable(Table table, List<Desk> deskInCurrentTable, Node node, Floor floor) {

        // sortDeskListRelativeCoordinates(deskSet); //sorting

        TreeSet<Desk> deskSet = new TreeSet<Desk>(new CustomComparator());
        deskSet.addAll(deskInCurrentTable);

        int maxRow = 0, maxCol = 0, len = 0, width = 0;
        for (Desk d : deskSet) {
            d.setTable(table);
            if (maxCol < d.getTableCol())
                maxCol = d.getTableCol();
            if (maxRow < d.getTableRow())
                maxRow = d.getTableRow();
        }

        if (maxRow < maxCol) {
            len = maxCol;
            width = maxRow;
        } else {
            len = maxRow;
            width = maxCol;
        }
        table.setLength(len + 1);  //set max
        table.setWidth(width + 1);   // set min
        table.setTopLeftX(node.desk.getX());
        table.setTopLeftY(node.desk.getY());
        table.setDesks(deskSet);
        table.setFloor(floor);
    }


    void sortDeskListActualCoordinates(List<Desk> deskList) {

        Collections.sort(deskList, (o1, o2) -> {   // Sorting desk
            if (o1.getY() > o2.getY())
                return 1;
            else if (o1.getY() == o2.getY())
                if (o1.getX() > o2.getX())
                    return 1;
                else
                    return -1;
            else
                return -1;
        });


    }

    class CustomComparator implements Comparator<Desk> {

        @Override
        public int compare(Desk o1, Desk o2) {
            if (o1.getTableRow() > o2.getTableRow())
                return 1;
            else if (o1.getTableRow() == o2.getTableRow())
                if (o1.getTableCol() > o2.getTableCol())
                    return 1;
                else
                    return -1;
            else
                return -1;
        }
    }


}