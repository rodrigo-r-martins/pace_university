public class LinkData {

    public String name;
    public LinkData next;

    LinkData() {
        name = " ";
        next = null;
    }

    LinkData(String name) {
        this.name = name;
        next = null;
    }
}
