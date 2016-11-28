package fsm.parser.entities;

import fsm.model.domain.Desk;

public class ParsedDesk extends Desk {

	private int x;
	private int y;
	private int width;
	private int length;

	public ParsedDesk(String deskCode, int x, int y, int length, int width) {
		super();
		super.setDeskCode(deskCode);
		this.x = x;
		this.y = y;
		this.width = width;
		this.length = length;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public Desk getDesk(){
		return this;
	}

}
