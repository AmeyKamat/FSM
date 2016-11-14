package fsm.service.middleLayer.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import fsm.domain.Desk;
import fsm.domain.LayoutData;
import fsm.domain.LayoutExtremes;
import fsm.domain.TableData;



/**
 * Created by Sarthak on 10-09-2016.
 */
public class TableGenerator {
	private int maxX, maxY;
	boolean visited[][];
	HashSet<Desk> deskSet;
	private int tableNumber = 0;
	public int tableIds[][];

	private TableData generateTable(Desk desk, String layoutId) {
		desk = getDesk(desk);
		int topLeftX = desk.getX(), topLeftY = desk.getY();
		int maxPushPointX = 0, maxPushPointY = 0;
		tableNumber++;
		List<Desk> desksForCurrentTable = new ArrayList<Desk>();
		Queue<Desk> queue = new LinkedList<Desk>();
		Queue<Point> pointQueue = new LinkedList<Point>();
		queue.add(desk);
		Point point = new Point(0, 0);
		pointQueue.add(point);
		while (!queue.isEmpty()) {
			Desk current = queue.remove();
			Point currentPoint = pointQueue.remove();
			tableIds[currentPoint.x][currentPoint.y] = current.getDeskId();
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
		int deskIds[] = new int[desksForCurrentTable.size()];
		int index = 0;
		for (Desk d : desksForCurrentTable) {
			deskIds[index++] = d.getDeskId();
		}
		// System.out.println("For table number "+tableNumber+" Max x
		// "+maxPushPointX+" Max Y "+maxPushPointY);
		int finalTable[][] = new int[maxPushPointY + 1][maxPushPointX + 1];
		for (int i = 0; i <= maxPushPointY; i++) {
			for (int j = 0; j <= maxPushPointX; j++) {
				finalTable[i][j] = tableIds[j][i];
			}
		}
		int finalTable1[][];
		if (maxPushPointX < maxPushPointY) {
			finalTable1 = new int[maxPushPointX + 1][maxPushPointY + 1];
			for (int i = 0; i <= maxPushPointY; i++) {
				for (int j = 0; j <= maxPushPointX; j++) {
					finalTable1[j][i] = finalTable[i][j];
				}
			}
		} else {
			finalTable1 = finalTable;
		}

		/*
		 * for(int i=0;i<=maxPushPointY;i++){ for(int j=0;j<=maxPushPointX;j++){
		 * System.out.print(finalTable[i][j]+" "); } System.out.println(); }
		 */
		return new TableData(tableNumber, desksForCurrentTable, finalTable1, maxPushPointY + 1, maxPushPointX + 1,
				topLeftX, topLeftY, layoutId);
	}

	private Desk getDesk(Desk searchDesk) {
		for (Desk temp : deskSet) {
			if (temp.getX() == searchDesk.getX() && temp.getY() == searchDesk.getY())
				return temp;
		}
		return new Desk();
	}

	public List<TableData> generateTables(LayoutData layoutData, String layoutId) {
		LayoutExtremes layoutExtremes = layoutData.getLayoutExtremes();
		ArrayList<Desk> deskList = (ArrayList<Desk>) layoutData.getDesks();
		List<TableData> tables = new ArrayList<TableData>();
		tableIds = new int[1000][1000];
		deskSet = new HashSet<Desk>(deskList);
		maxX = layoutExtremes.getMaximumX();
		maxY = layoutExtremes.getMaximumY();
		visited = new boolean[maxX + 1][maxY + 1];
		for (int i = 0; i <= maxX; i++)
			Arrays.fill(visited[i], false);
		for (int i = 0; i <= maxX; i++) {
			for (int j = 0; j <= maxY; j++) {
				Desk searchDesk = new Desk(i, j);
				if (deskSet.contains(searchDesk) && !visited[i][j]) {
					searchDesk = getDesk(searchDesk);
					TableData generatedTable = generateTable(searchDesk, layoutId);
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
