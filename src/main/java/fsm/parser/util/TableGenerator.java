package fsm.parser.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.stereotype.Component;

import fsm.model.domain.Desk;
import fsm.model.domain.Floor;
import fsm.model.domain.Table;
import fsm.parser.entities.ParsedDesk;
import fsm.parser.entities.ParsedFloor;
import fsm.parser.entities.ParsedTable;

@Component
public class TableGenerator {

	private class Node {

		ParsedDesk desk;
		boolean visited;

		Node(ParsedDesk desk) {
			this.desk = desk;
			this.visited = false;
		}

		public ParsedDesk getDesk() {
			return desk;
		}

		public boolean isVisited() {
			return visited;
		}

		public void markAsVisited() {
			visited = true;
		}
	}

	ArrayList<Node> nodes = new ArrayList<Node>();

	private List<ParsedDesk> getDesksInTable(Node initialNode, Table table) {

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(initialNode);
		List<ParsedDesk> desksInTable = new LinkedList<ParsedDesk>();

		while (!queue.isEmpty()) {
			Node node = queue.remove();
			node.markAsVisited();
			node.getDesk().setTable(table);
			node.getDesk().setTableRow(node.getDesk().getX() - initialNode.getDesk().getX());
			node.getDesk().setTableCol(node.getDesk().getY() - initialNode.getDesk().getY());
			desksInTable.add(node.getDesk());
			queue.addAll(this.getNeighbours(node));
		}
		return desksInTable;

	}

	private List<Node> getNeighbours(Node node) {
		List<Node> neighbours = new LinkedList<Node>();
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 1; j++) {
				if (i == 0 && j == 0) {
					continue;
				} else {
					for (Node temp : nodes) {
						if (temp.desk.getX() == node.desk.getX() + i * node.desk.getLength()
								&& temp.desk.getY() == node.desk.getY() + j * node.desk.getWidth() && node.isVisited())
							neighbours.add(temp);
					}
				}
			}
		}
		return neighbours;
	}

	public List<ParsedTable> getParsedTables(ParsedFloor floor, List<ParsedDesk> desks) {

		List<ParsedTable> tables = new LinkedList<ParsedTable>();
		this.sortDesksByAbsoluteCoordinates(desks);

		List<Node> nodes = new LinkedList<Node>();
		for (ParsedDesk desk : desks)
			nodes.add(new Node(desk));

		for (Node node : nodes) {
			if (!node.isVisited()) {
				ParsedTable table = new ParsedTable();
				List<ParsedDesk> desksInATable = this.getDesksInTable(node, table);
				this.buildTable(table, desksInATable, node.getDesk(), floor); 
				tables.add(table);
			}
		}
		return tables;
	}

	private void buildTable(Table table, List<ParsedDesk> desksInATable, ParsedDesk initialDesk, Floor floor) {

		int maxRow = 0, maxCol = 0;
		for (Desk d : desksInATable) {
			if (maxCol < d.getTableCol())
				maxCol = d.getTableCol();
			if (maxRow < d.getTableRow())
				maxRow = d.getTableRow();
		}

		table.setLength(maxCol + 1); // set max
		table.setWidth(maxRow + 1); // set min
		table.setTopLeftX(initialDesk.getX());
		table.setTopLeftY(initialDesk.getY());
		table.setFloor(floor);
	}

	private void sortDesksByAbsoluteCoordinates(List<ParsedDesk> desks) {
		Collections.sort(desks, (desk1, desk2) -> {
			if (desk1.getY() > desk2.getY())
				return 1;
			else if (desk1.getY() == desk2.getY())
				if (desk1.getX() > desk2.getX())
					return 1;
				else
					return -1;
			else
				return -1;
		});
	}
}