package fsm.domain;

import java.util.List;

/**
 * Created by Sarthak on 13-09-2016.
 */
public class LayoutData {
	private LayoutExtremes layoutExtremes;
	private List<Desk> desks;

	public LayoutData(LayoutExtremes layoutExtremes, List<Desk> desks) {
		this.layoutExtremes = layoutExtremes;
		this.desks = desks;
	}

	public LayoutExtremes getLayoutExtremes() {
		return layoutExtremes;
	}

	public List<Desk> getDesks() {
		return desks;
	}
}
