/** 8.1_task1 design a Pen class
 * Pen 类表示一种可以绘画的笔，具有颜色和笔帽状态。
 * 只有在笔帽盖上时才能更换颜色，只有在笔帽打开时才能绘画。
 */
public class Pen {

    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; }
        @Override public String toString() { return color; }
    }

    private Color color;      // 当前笔的颜色
    private boolean isCapped; // 是否盖上笔帽

    // 默认构造函数，颜色为 RED，默认盖上笔帽
    public Pen() {
        this.color = Color.RED;
        this.isCapped = true;
    }

    // 构造函数，允许选择颜色
    public Pen(Color color) {
        this.color = color;
        this.isCapped = true;
    }

    // 打开笔帽
    public void capOff() {
        this.isCapped = false;
    }

    // 盖上笔帽
    public void capOn() {
        this.isCapped = true;
    }

    // 改变颜色：只有在笔帽盖上时才能更换颜色
    public void changeColor(Color newColor) {
        if (isCapped) {
            this.color = newColor;
        }
    }

    // 绘画方法
    public String draw() {
        if (isCapped) {
            return "";
        } else {
            return "Drawing " + color;
        }
    }
}
