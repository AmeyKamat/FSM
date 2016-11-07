package fsm.entity;

import java.util.List;

/**
 * Created by Sarthak on 13-09-2016.
 */
public class LayoutExtremes {
    private String layoutId;
    private int minimumX,minimumY,maximumX,maximumY;
    public List<TableData> tableList;
    public LayoutExtremes(){}
    public LayoutExtremes(String layoutId,int minimumX, int minimumY, int maximumX, int maximumY) {
        this.layoutId = layoutId;
        this.minimumX = minimumX;
        this.minimumY = minimumY;
        this.maximumX = maximumX;
        this.maximumY = maximumY;
    }

    public void setLayoutId(String layoutId) {
        this.layoutId = layoutId;
    }

    public String getLayoutId() {
        return layoutId;
    }

    public int getMinimumX() {
        return minimumX;
    }

    public void setMinimumX(int minimumX) {
        this.minimumX = minimumX;
    }

    public int getMinimumY() {
        return minimumY;
    }

    public void setMinimumY(int minimumY) {
        this.minimumY = minimumY;
    }

    public int getMaximumX() {
        return maximumX;
    }

    public void setMaximumX(int maximumX) {
        this.maximumX = maximumX;
    }

    public int getMaximumY() {
        return maximumY;
    }

    public void setMaximumY(int maximumY) {
        this.maximumY = maximumY;
    }
}
