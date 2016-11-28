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
		boolean queued;

		Node(ParsedDesk desk) {
			this.desk = desk;
			this.queued = false;
		}

		public ParsedDesk getDesk() {
			return desk;
		}

		public boolean hasBeenQueued() {
			return queued;
		}

		public void markAsQueued() {
			queued = true;
		}
	}

	ArrayList<Node> nodes = new ArrayList<Node>();

	private List<ParsedDesk> getDesksInTable(Node initialNode, ParsedTable table) {

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(initialNode);
		initialNode.markAsQueued();
		List<ParsedDesk> desksInTable = new LinkedList<ParsedDesk>();

		while (!queue.isEmpty()) {
			Node node = queue.remove();
			node.getDesk().setTableRow(node.getDesk().getX() - initialNode.getDesk().getX() + 1);
			node.getDesk().setTableCol(node.getDesk().getY() - initialNode.getDesk().getY() + 1);
			System.out.println(node.getDesk().getDeskCode());
			table.addDesk(node.getDesk());
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
						if (temp.getDesk().getX() == node.getDesk().getX() + i * node.getDesk().getLength()
								&& temp.getDesk().getY() == node.getDesk().getY() + j * node.getDesk().getWidth() && !temp.hasBeenQueued()) {
							temp.markAsQueued();
							neighbours.add(temp);
						}

					}
				}
			}
		}
		return neighbours;
	}

	public List<ParsedTable> getParsedTables(ParsedFloor floor, List<ParsedDesk> desks) {

		List<ParsedTable> tables = new LinkedList<ParsedTable>();
		this.sortDesksByAbsoluteCoordinates(desks);

		for (ParsedDesk desk : desks) {
			nodes.add(new Node(desk));
		}

		for (Node node : nodes) {
			if (!node.hasBeenQueued()) {
				ParsedTable table = new ParsedTable();
				List<ParsedDesk> desksInATable = this.getDesksInTable(node, table);
				this.buildTable(table, desksInATable, node.getDesk(), floor); 
				tables.add(table);
			}
		}
		return tables;
	}

	private void buildTable(ParsedTable table, List<ParsedDesk> desksInATable, ParsedDesk initialDesk, ParsedFloor floor) {

		int maxRow = 0, maxCol = 0;
		for (Desk d : desksInATable) {
			if (maxCol < d.getTableCol())
				maxCol = d.getTableCol();
			if (maxRow < d.getTableRow())
				maxRow = d.getTableRow();
		}

		table.setLength(maxCol + 1);
		table.setWidth(maxRow + 1);
		table.setTopLeftX(initialDesk.getX());
		table.setTopLeftY(initialDesk.getY());
		floor.addTable(table);
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