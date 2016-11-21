package fsm.service.impl;

import fsm.domain.Desk;
import fsm.domain.Floor;
import fsm.domain.Table;
import fsm.domain.UI.FloorObjects;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mohit on 11/18/2016.
 */
@Service
@RequestScope
public class ConnectedComponentGraphAlgorithm {

    private class Node{

        Desk desk;
        boolean visited;
        Node(Desk desk) {
            this.desk = desk;
        }

    }
    private class Point{

        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
        int x;
        int y;
    }

    ArrayList<Node> nodes = new ArrayList<Node>();


    public void dfs(List<Desk> deskInCurrentTable,Node node,Point relativeCoordinates) {

        node.visited = true;
        node.desk.setTableRow(relativeCoordinates.y);
        node.desk.setTableCol(relativeCoordinates.x);
        deskInCurrentTable.add(node.desk);

     /*   Node rightNode = findNeighbours( node.desk.getX() + node.desk.getWidth(), node.desk.getY());
        Node bottomNode = findNeighbours( node.desk.getX(), node.desk.getY() + node.desk.getHeight());
       *//* Node topNode = findNeighbours( node.desk.getX() , node.desk.getY()- node.desk.getHeight());
        Node leftNode= findNeighbours( node.desk.getX()-node.desk.getWidth(), node.desk.getY());
        Node topLeft = findNeighbours( node.desk.getX() - node.desk.getWidth(), node.desk.getY() - node.desk.getHeight());
        Node topRight= findNeighbours( node.desk.getX() + node.desk.getWidth(), node.desk.getY() - node.desk.getHeight());
        Node bottomLeft = findNeighbours( node.desk.getX() - node.desk.getWidth(), node.desk.getY() + node.desk.getHeight());
       *//*
       Node bottomRight= findNeighbours( node.desk.getX() + node.desk.getWidth(), node.desk.getY() + node.desk.getHeight());
*/
        for(int i=0;i<=1;i++)
            for(int j=0;j<=1;j++)
            {
                if(i==0 && j==0)
                    continue;

                Node nodeTraverse = findNeighbours( node.desk.getX() + i*node.desk.getWidth(), node.desk.getY()+j*node.desk.getHeight());

                if (nodeTraverse != null && !nodeTraverse.visited)
                    dfs(deskInCurrentTable, nodeTraverse, new Point(relativeCoordinates.x+i,relativeCoordinates.y+j));

            }

/*

        if (rightNode != null && !rightNode.visited)
            dfs(deskInCurrentTable, rightNode, new Point(relativeCoordinates.x+1,relativeCoordinates.y));

        if (bottomNode != null && !bottomNode.visited)
            dfs(deskInCurrentTable, bottomNode,new Point(relativeCoordinates.x,relativeCoordinates.y+1));

        if (topNode != null && !topNode.visited)
            dfs(deskInCurrentTable, topNode,new Point(relativeCoordinates.x,relativeCoordinates.y-1));
        if (leftNode != null && !leftNode.visited)
            dfs(deskInCurrentTable, leftNode,new Point(relativeCoordinates.x-1,relativeCoordinates.y));

        if (bottomRight != null && !bottomRight.visited)
            dfs(deskInCurrentTable, bottomRight,new Point(relativeCoordinates.x+1,relativeCoordinates.y+1));

*/

    }

    private Node findNeighbours( int x, int y) {
        for(Node temp:nodes){
            if(temp.desk.getX()==x && temp.desk.getY()==y)
                return temp;
        }
        return null;
    }
/*

    public void clearVisitedFlags() {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).visited = false;
        }
    }

*/





    public List<Table> DFS_UTIL(FloorObjects floordData) {

        List<Table> graph_components = new ArrayList<Table>();

        List<Desk> deskList = floordData.getDeskList();
        Floor floor = floordData.getFloor();

        sortDeskListActualCoordinates(deskList);  //sorting wrt actual coordinates

        for(Desk desk: deskList)
            nodes.add(new Node(desk));


        for(Node node:nodes){
            if(!node.visited) {
                Table table=new Table();
                ArrayList<Desk> deskInCurrentTable=new ArrayList<>();
                dfs(deskInCurrentTable,node,new Point(0,0));   // To get Desks associated with current table
                populatingTable(table,deskInCurrentTable,node,floor); // populating table object
                graph_components.add(table);                       //adding it in result
            }
        }
        return graph_components;
    }


    void populatingTable(Table table,List<Desk> deskInCurrentTable, Node node, Floor floor){
        sortDeskListRelativeCoordinates(deskInCurrentTable); //sorting

        for(Desk d:deskInCurrentTable)
            d.setTable(table);

        // Populating various values of tables
        Desk lastDeskInTable=deskInCurrentTable.get(deskInCurrentTable.size()-1);
        int row=lastDeskInTable.getTableRow();
        int col=lastDeskInTable.getTableCol();
        table.setLength(row>col?row+1:col+1);  //set max
        table.setWidth(row<col?row+1:col+1);   // set min
        table.setTopLeftX(node.desk.getX());
        table.setTopLeftY(node.desk.getY());
        table.setDesks(deskInCurrentTable);
        table.setFloor(floor);


    }


    void sortDeskListRelativeCoordinates(List<Desk> deskInCurrentTable){

        Collections.sort(deskInCurrentTable, (o1, o2) -> {   // Sorting desk

            if(o1.getTableRow()>o2.getTableRow())
                return 1;
            else if(o1.getTableRow()==o2.getTableRow())
                if(o1.getTableCol()>o2.getTableCol())
                    return 1;
                else
                    return -1;
            else
                return -1;
        });


    }

    void sortDeskListActualCoordinates(List<Desk> deskList){

        Collections.sort(deskList, (o1, o2) -> {   // Sorting desk
            if(o1.getY()>o2.getY())
                return 1;
            else if(o1.getY()==o2.getY())
                if(o1.getX()>o2.getX())
                    return 1;
                else
                    return -1;
            else
                return -1;
        });



    }


}
