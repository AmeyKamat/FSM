package fsm.service.impl;

import java.util.*;

import fsm.domain.Desk;
import fsm.domain.Floor;
import fsm.domain.Table;



/**
 * Created by Sarthak on 10-09-2016.
 */
public class TableGenerator {
	private int maxX, maxY;
	boolean visited[][];
	HashSet<Desk> deskSet;
	public String tableIds[][];

	private Table generateTable(Desk desk) {
		Table generatedTable=new Table();

        desk = getDesk(desk);
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
			if (deskSet.contains(rightDesk)) {
				rightDesk = getDesk(rightDesk);
				queue.add(rightDesk);
				pointQueue.add(new Point(currentPoint.x + 1, currentPoint.y));
				maxPushPointX = Math.max(currentPoint.x + 1, maxPushPointX);
				maxPushPointY = Math.max(currentPoint.y, maxPushPointY);
			}

			if (deskSet.contains(downDesk)) {
				downDesk = getDesk(downDesk);
				queue.add(downDesk);
				pointQueue.add(new Point(currentPoint.x, currentPoint.y + 1));
				maxPushPointX = Math.max(currentPoint.x, maxPushPointX);
				maxPushPointY = Math.max(currentPoint.y + 1, maxPushPointY);
			}
		}
		//String deskIds[] = new String[desksForCurrentTable.size()];
		//int index = 0;

		for (Desk d : desksForCurrentTable) {
            d.setTable(generatedTable);
		}
		// System.out.println("For table number "+tableNumber+" Max x
		// "+maxPushPointX+" Max Y "+maxPushPointY);
		//String finalTable[][] = new String[maxPushPointY + 1][maxPushPointX + 1];


        for (int i = 0; i <= maxPushPointY; i++)
            for (int j = 0; j <= maxPushPointX; j++) {
                getDeskFromCode(desksForCurrentTable,tableIds[j][i]).setTableRow(i);
                getDeskFromCode(desksForCurrentTable,tableIds[j][i]).setTableCol(j);
            }

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

	private Desk getDesk(Desk searchDesk) {
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
        return null;
    }


    public List<Table> generateTables(Vector floordData) {


		List<Desk> deskList = (List<Desk>)floordData.get(0);
		Floor floor=(Floor)floordData.get(1);

		List<Table> tables = new ArrayList<Table>();

		tableIds = new String[1000][1000];
		deskSet = new HashSet<Desk>(deskList);
		maxX = floor.getMaxX();
		maxY = floor.getMaxY();
		visited = new boolean[maxX + 1][maxY + 1];
		for (int i = 0; i <= maxX; i++)
			Arrays.fill(visited[i], false);
		for (int i = 0; i <= maxX; i++) {
			for (int j = 0; j <= maxY; j++) {
				Desk searchDesk = new Desk(i, j);
				if (deskSet.contains(searchDesk) && !visited[i][j]) {
					searchDesk = getDesk(searchDesk);
					Table generatedTable = generateTable(searchDesk);
                    generatedTable.setFloor(floor);
					tables.add(generatedTable);
				}
			}
		}
		return tables;
	}

	private class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
