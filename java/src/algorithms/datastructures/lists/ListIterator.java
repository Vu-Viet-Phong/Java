package algorithms.datastructures.lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListIterator {
    private Link current;
    private Link previous;
    private LinkedList ourList;

    public ListIterator(LinkedList list) {
        ourList = list;
        reset();
    }

    public void reset() {
        // current = ourList.getFirst();
        previous = null;
    }

    public boolean atEnd() {
        return current.next == null;
    }

    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public Link getCurrent() {
        return current;
    }

    public void insertAfter(int item) {
        Link newLink = new Link(item);

        if (ourList.isEmpty()) {
            // ourList.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(int item) {
        Link newLink = new Link(item);

        if (previous == null) {
            // newLink.next = ourList.getFirst();
            // ourList.setFirst(newLink);
            reset();
        } else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public int deleteCurrent() {
        int value = current.data;

        if (previous == null) {
            // ourList.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;

            if (atEnd()) {
                reset();
            } else {
                current = current.next;
            }
        }

        return value;
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        LinkedList theList = new LinkedList();           // new list
        ListIterator iter1 = theList.getIterator();  // new iter
        int value;

        iter1.insertAfter(20);             // insert items
        iter1.insertAfter(40);
        iter1.insertAfter(80);
        iter1.insertBefore(60);

        while (true) {
            System.out.print("Enter first letter of show, reset, ");
            System.out.print("next, get, before, after, delete: ");
            System.out.flush();
            
            int choice = getChar(); // get user's option
            switch(choice) {
                case 's': // show list
                    if (!theList.isEmpty()) {
                        theList.displayList();
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case 'r': // reset (to first)
                    iter1.reset();
                    break;
                case 'n': // advance to next item
                    if(!theList.isEmpty() && !iter1.atEnd()) {
                        iter1.nextLink();
                    } else {
                        System.out.println("Can't go to next link");
                    }
                    break;
                case 'g': // get current item
                    if (!theList.isEmpty()) {
                        value = iter1.getCurrent().data;
                        System.out.println("Returned " + value);
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case 'b': // insert before current
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertBefore(value);
                    break;
                case 'a': // insert after current
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertAfter(value);
                    break;
                case 'd': // delete current item
                    if(!theList.isEmpty()) {
                        value = iter1.deleteCurrent();
                        System.out.println("Deleted " + value);
                    } else {
                        System.out.println("Can't delete");
                    }
                    break;
                default:
                    System.out.println("Invalid entry");
            } 
        }
    }
}

