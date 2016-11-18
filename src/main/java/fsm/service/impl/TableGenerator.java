package fsm.service.impl;

import java.util.*;

import fsm.domain.Desk;
import fsm.domain.Floor;
import fsm.domain.Table;
import fsm.domain.UI.FloorObjects;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;


/**
 * Created by Sarthak on 10-09-2016.
 */
@Service
@RequestScope
public class TableGenerator {
	private int maxX, maxY;
	boolean visited[][];
	public String tableIds[][];

	private Table generateTable(List<Desk> deskSet,Desk desk) {
		Table generatedTable=new Table();
        desk = getDesk(deskSet,desk);
		int topLeftX = desk.getX(), topLeftY = desk.getY();
		int maxPushPointX = 0, maxPushPointY = 0;
		List<Desk> desksForCurrentTable = new ArrayList<Desk>();
		Queue<Desk> queue = new LinkedList<Desk>();
		Queue<Point> pointQueue = new LinkedList<Point>();
		queue.add(desk);
		Point point = new Point(0, 0);
		pointQueue.add(point);
		while (!queue.isEmpty()) {
			Desk current = queue.remove();
			Point currentPoint = pointQueue.remove();
			tableIds[currentPoint.x][currentPoint.y] = current.getDeskCode();
			if (visited[current.getX()][current.getY()])
				continue;
			desksForCurrentTable.add(current);
			visited[current.getX()][current.getY()] = true;
			Desk rightDesk = new Desk(current.getX() + current.getWidth(), current.getY());
			Desk downDesk = new Desk(current.getX(), current.getY() + current.getHeight());
            /*Desk diagonalDownDesk = new Desk(current.getX()+current.getWidth(), current.getY() + current.getHeight());
*/

            if (containsDesk(deskSet,rightDesk)) {
				rightDesk = getDesk(deskSet,rightDesk);
				queue.add(rightDesk);
				pointQueue.add(new Point(currentPoint.x + 1, currentPoint.y));
				maxPushPointX = Math.max(currentPoint.x + 1, maxPushPointX);
				maxPushPointY = Math.max(currentPoint.y, maxPushPointY);
			}

			if (containsDesk(deskSet,downDesk)) {
				downDesk = getDesk(deskSet,downDesk);
				queue.add(downDesk);
				pointQueue.add(new Point(currentPoint.x, currentPoint.y + 1));
				maxPushPointX = Math.max(currentPoint.x, maxPushPointX);
				maxPushPointY = Math.max(currentPoint.y + 1, maxPushPointY);
			}
           /* if (containsDesk(deskSet,diagonalDownDesk)) {
                diagonalDownDesk = getDesk(deskSet,diagonalDownDesk);
                queue.add(diagonalDownDesk);
                pointQueue.add(new Point(currentPoint.x+1, currentPoint.y + 1));
                maxPushPointX = Math.max(currentPoint.x+1, maxPushPointX);
                maxPushPointY = Math.max(currentPoint.y + 1, maxPushPointY);
            }*/


        }
		//String deskIds[] = new String[desksForCurrentTable.size()];
		//int index = 0;

		for (Desk d : desksForCurrentTable) {
            d.setTable(generatedTable);
		}
		// System.out.println("For table number "+tableNumber+" Max x
		// "+maxPushPointX+" Max Y "+maxPushPointY);
		//String finalTable[][] = new String[maxPushPointY + 1][maxPushPointX + 1];



        System.out.println("table Id");
        for(int i=0;i<=maxPushPointX;i++) {
            for (int j = 0; j <= maxPushPointY; j++)
                System.out.print(tableIds[i][j] + " ");
        System.out.println();
        }
        for (int i = 0; i <= maxPushPointY; i++)
            for (int j = 0; j <= maxPushPointX; j++) {
                getDeskFromCode(desksForCurrentTable,tableIds[j][i]).setTableRow(i);
                getDeskFromCode(desksForCurrentTable,tableIds[j][i]).setTableCol(j);
                System.out.print(tableIds[j][i]+" ");
            }
        System.out.println();


		if (maxPushPointX < maxPushPointY) {
            for(Desk d:desksForCurrentTable){
                    int temp=d.getTableRow();
                    d.setTableRow(d.getTableCol());
                    d.setTableCol(temp);
            }
        }

        generatedTable.setDesks(desksForCurrentTable);
        generatedTable.setWidth(maxPushPointY+1);
        generatedTable.setLength(maxPushPointX+1);
        generatedTable.setTopLeftX(topLeftX);
        generatedTable.setTopLeftY(topLeftY);
	return generatedTable;
	}

	private Desk getDesk(List<Desk> deskSet,Desk searchDesk) {
		for (Desk temp : deskSet) {
			if (temp.getX() == searchDesk.getX() && temp.getY() == searchDesk.getY())
				return temp;
		}
		return new Desk();
	}

    private Desk getDeskFromCode(List<Desk> deskList,String deskCode) {
        for (Desk temp : deskList) {
            if (temp.getDeskCode().equals(deskCode))
                return temp;
        }
        System.out.println("desk code "+deskCode+" not found");
        return null;
    }


    public List<Table> generateTables(FloorObjects floordData) {


		List<Desk> deskList = floordData.getDeskList();
		Floor floor=floordData.getFloor();

		List<Table> tables = new ArrayList<Table>();

		tableIds = new String[1000][1000];
        for(int i=0;i<1000;i++)
            tableIds[i]=new String[1000];


		maxX = floor.getMaxX();
		maxY = floor.getMaxY();
		visited = new boolean[maxX + 1][maxY + 1];
		for (int i = 0; i <= maxX; i++)
			Arrays.fill(visited[i], false);
		for (int i = 0; i <= maxX; i++) {
			for (int j = 0; j <= maxY; j++) {
				Desk searchDesk = new Desk(i, j);
				if (containsDesk(deskList,searchDesk) && !visited[i][j]) {
					searchDesk = getDesk(deskList,searchDesk);
					Table generatedTable = generateTable(deskList,searchDesk);
                    generatedTable.setFloor(floor);
					tables.add(generatedTable);
				}
			}
		}
		return tables;
	}


	boolean containsDesk(List<Desk> deskList,Desk desk){
        for(Desk temp:deskList)
            if(temp.getX()==desk.getX() && temp.getY()==desk.getY())
                return true;
        return false;
    }

	private class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
