package tung.lab01;

class Person {
    private String lastName;
    private String firstName;
    private int age;
    
    public Person(String last, String first, int a) {
        lastName = last;
        firstName = first;
        age = a;
    }
    
    public String getLast() { return lastName; }

    public void displayPerson() { 
        System.out.print("   Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
    }
} 

class ClassDataArray {
    private Person[] a;           
    private int nElems;

    public ClassDataArray(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public Person find(String searchName) {
        int j;

        for (j = 0; j < nElems; j++) { 
            if (a[j].getLast().equals(searchName)) break; 
        }

        if (j == nElems) return null;
        else return a[j];
    }

    public void insert(String last, String first, int age) {
        a[nElems] = new Person(last, first, age);
        nElems++;
    }

    /**
     * Delete person from array
     * @param searchName
     * @return 
     */
    public boolean delete(String searchName) {
        int j;

        for (j = 0; j < nElems; j++) {
            if(a[j].getLast().equals(searchName)) break;
        }

        if (j == nElems) return false;
        else {
            for (int k = j; k < nElems; k++) { 
                a[k] = a[k+1];
            }
            nElems--;
            
            return true;
        }
    }

    /** Displays array contents */
    public void displayA() {
        for (int j = 0; j < nElems; j++) {
            a[j].displayPerson(); // display it
        }
    } 
}

class ClassDataApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ClassDataArray arr = new ClassDataArray(maxSize);

        /** Insert 10 items */
        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Adams", "Henry", 63);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Lamarque", "Henry", 54);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        /** Display items */
        arr.displayA();

        /** Search for item */
        String searchKey = "Stimson";
        Person found = arr.find(searchKey);

        if (found != null) {
            System.out.print("Found ");
            found.displayPerson();
        } else System.out.println("Can't find " + searchKey);
        
        System.out.println("Deleting Smith, Yee, and Creswell");

        /** Delete 3 items */
        arr.delete("Smith");
        arr.delete("Yee");
        arr.delete("Creswell");
        
        /** Display items again */
        arr.displayA();
    }
}
