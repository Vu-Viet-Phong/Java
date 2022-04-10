package lab.tung.lab3;

import java.util.Random;
import java.util.Stack;

// To represent a particular operation
class Operation {
    int index;
    int oldValue;
    int newValue;

    public Operation(int index, int oldValue, int newValue) {
        this.index = index;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }
}

public class SpecialArray {
    private int values[];
    Stack<Operation> updates;
    Stack<Operation> redoUpdates;

    SpecialArray() {
        // Allocate memory and fill with 20 random values
        values = new int[20];
        Random rd = new Random();
        for (int i = 0; i < 20; i++) {
            values[i] = rd.nextInt(10) + 1;
        }
        // Allocate memory to stacks
        updates = new Stack<>();
        redoUpdates = new Stack<>();
    }

    // method to update value at particular index
    public void update(int index, int newValue) {
        // create a new operation and add it to the stack
        Operation op = new Operation(index, values[index], newValue);
        updates.add(op);
        values[index] = newValue; // update the value in the array
    }

    // method to undo the updating
    public void undoUpdate() {
        // if there was some update done in the past
        if (!updates.empty()) {
            Operation op = updates.peek(); // get the operation
            // set the old value in the index
            values[op.index] = op.oldValue;
            int temp = op.oldValue;
            op.oldValue = op.newValue;
            op.newValue = temp;
            redoUpdates.add(op); // add it to the other stack
            updates.pop();
        }
    }

    /* Method to redo the updating */
    public void redoUpdate() {
        // if there was some update done in the past
        if (!redoUpdates.empty()) {
            Operation op = redoUpdates.peek(); // get the operation
            // set the old value in the index
            values[op.index] = op.oldValue;
            // swap the values
            int temp = op.oldValue;
            op.oldValue = op.newValue;
            op.newValue = temp;

            updates.add(op); // add it to the other stack
            redoUpdates.pop();
        }
    }

    // method to display the content of the array
    public void display() {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        SpecialArray arr = new SpecialArray();
        arr.display(); // display the initial contents

        // update the value at 3rd index to 20
        System.out.println("Updated value at 3rd index to 20");
        arr.update(3, 20);
        
        // display
        arr.display();
        
        // update the value at 0th index to 100
        System.out.println("Updated value at 0th index to 100");
        arr.update(0, 100);
        
        arr.display();
        
        // undo the update
        System.out.println("Undo the update");
        arr.undoUpdate();
        
        arr.display();
        
        // redo the update
        System.out.println("Redo the update");
        arr.redoUpdate();

        arr.display();
        
        //undo the update twice
        System.out.println("Undo the update twice");
        arr.undoUpdate();
        arr.undoUpdate();

        arr.display();
    }
}