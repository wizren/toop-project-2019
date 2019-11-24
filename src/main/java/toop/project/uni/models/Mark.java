package toop.project.uni.models;

public class Mark {
    public static final String empty = "Не выставлена";
    public static final String two = "Неудовлетворительно";
    public static final String three = "Удовлетворительно";
    public static final String four = "Хорошо";
    public static final String five = "Отлично";

    private byte mark;

    public Mark() {
        this.mark = 0;
    }

    public Mark(byte mark) {
        this.mark = mark;
    }

    public void setMark(byte mark) {
        this.mark = mark;
    }

    public byte getMark() {
        return mark;
    }

    public String toString() {
        switch (mark) {
            case 0: return empty;
            case 2: return two;
            case 3: return three;
            case 4: return four;
            case 5: return five;
            default:return "";
        }
    }
}
