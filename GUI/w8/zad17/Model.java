package w8.zad17;

import java.awt.*;

public class Model {
    private Color fgColor;
    private Color bgColor;
    private int fontSize;

    public Model() {
        this.fgColor = Color.BLACK;
        this.bgColor = Color.WHITE;
        this.fontSize = 10;
    }

    //SETTER
    public void setFgColor(Color fgColor) {

        this.fgColor = fgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    //GETTER
    public Color getFgColor() {
        return fgColor;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public int getFontSize() {
        return fontSize;
    }
}
