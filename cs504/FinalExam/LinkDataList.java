public class LinkDataList {

    private LinkData head;

    public int length() {                           // return the size of LinkDataList
        LinkData current = head;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public void add(LinkData lD) {                  // add a LinkData to the end of the list
        LinkData current = head;
        if (head == null) {
            head = lD;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = lD;
        }
    }

    public void addAt(int index, LinkData lD) {     // add a LinkData at the given index
        LinkData current = head;
        int count = 0;
        if (index == 0) {
            lD.next = head;
            head = lD;
        } else {
            while (count < index-1) {
                current = current.next;
                count++;
            }
            lD.next = current.next;
            current.next = lD;
        }
    }

    public void removeFirst() {                     // remove the first item of the list
        LinkData current = head;
        if (current.next != null) {
            head = current.next;
            current = current.next;
        }
    }

    public void printList() {                       // print the list
        LinkData current = head;
        while (current != null) {
            System.out.println(current.name);
            current = current.next;
        }
    }
}
