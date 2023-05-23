import java.util.*;

class node {
    node left, right;
    String name;
    String number;
    String address;
    String email_id;

    node(String name, String number, String address, String email_id) {
        this.left = null;
        this.right = null;
        this.name = name;
        this.number = number;
        this.address = address;
        this.email_id = email_id;
    }
}

class bst {

    Scanner sc = new Scanner(System.in);
    node root = null;

    void create() {
        root = null;
        String name = "";
        int f = 0;
        do {
            System.out.println("\nPLEASE ENTER CONTACT NAME::");
            name = sc.next();
            f = 0;
            for (int i = 0; i < name.length(); i++) {
                char ch = name.charAt(i);
                if (!Character.isLetter(ch)) {
                    System.out.println("\nNAME INVALID !!");
                    System.out.println("GIVE ANOTHER TRY :)\n");
                    f = 1;
                    i = name.length();
                }
            }
        } while (f == 1);

        String number = "";

        do {
            System.out.println("\nPLEASE ENTER CONTACT NUMBER::");
            number = sc.next();
            int l = number.length();
            f = 0;
            if (l != 10) {
                System.out.println("\nPHONE NUMBER INVALID !!");
                System.out.println("GIVE ANOTHER TRY :)\n");
                f = 1;
            } else {
                for (int i = 0; i < number.length(); i++) {
                    char ch = number.charAt(i);
                    if (!Character.isDigit(ch)) {
                        System.out.println("\nPHONE NUMBER INVALID !!");
                        System.out.println("GIVE ANOTHER TRY :)\n");
                        f = 1;
                        i = number.length();
                    }
                }
            }
        } while (f == 1);

        String address;
        System.out.println("\nPLEASE ENTER CONTACT ADDRESS ::");
        address = sc.next();

        String email_id;
        do {
            System.out.println("\nPLEASE ENTER CONTACT EMAIL ID::");
            email_id = sc.next();
            int l = email_id.length();
            f = 0;
            int index = 0;
            for (int i = 0; i < l; i++) {
                char ch = email_id.charAt(i);
                if (ch == '@') {
                    index = i;
                    i = l;
                }
            }
            String check = email_id.substring(index + 1, l);
            check = check.trim();
            if (check.equals("gmail.com") || check.equals("yahoo.com") || check.equals("rediffmail.com")
                    || check.equals("outlook.com")) {
                f = 0;
            } else {
                System.out.println("\nEMAIL ID INVALID !!");
                System.out.println("GIVE ANOTHER TRY :)\n");
                f = 1;
            }
        } while (f == 1);

        node new_node = new node(name, number, address, email_id);
        root = new_node;
        System.out.println("\n__________________________________________________");
        System.out.println(" PRESS '1' TO INSERT MORE CONTACTS IN THIS LIST\n OTHERWISE PRESS '0'");
        System.out.println("__________________________________________________");
        int C = sc.nextInt();
        if (C == 1) {
            insert();
        }
        System.out.println();

    }

    public void inOrder() {
        System.out.println("\n************CONTACT LIST***********");

        System.out.println(
                "------------------------------------------------------------------------------------------------------");
        System.out.println("NAME\t\tNUMBER\t\t\tADDRESS\t\t\tEMAIL ID");
        System.out.println(
                "------------------------------------------------------------------------------------------------------");
        inOrder(this.root);
    }

    void inOrder(node Node) {
        if (Node != null) {
            inOrder(Node.left);

            System.out
                    .println(Node.name + "\t\t" + Node.number + "\t\t" + Node.address + "\t\t" + Node.email_id + "\n");
            inOrder(Node.right);
        }
    }

    void insert() {
        String name = "";
        int f = 0;
        do {
            System.out.println("\nPLEASE ENTER CONTACT NAME::");
            name = sc.next();
            f = 0;
            for (int i = 0; i < name.length(); i++) {
                char ch = name.charAt(i);
                if (!Character.isLetter(ch)) {
                    System.out.println("\nNAME INVALID !!");
                    System.out.println("GIVE ANOTHER TRY :)\n");
                    f = 1;
                    i = name.length();
                }
            }
        } while (f == 1);

        String number = "";

        do {
            System.out.println("\nPLEASE ENTER CONTACT NUMBER::");
            number = sc.next();
            int l = number.length();
            f = 0;
            if (l != 10) {
                System.out.println("\nPHONE NUMBER INVALID !!");
                System.out.println("GIVE ANOTHER TRY :)\n");
                f = 1;
            } else {
                for (int i = 0; i < number.length(); i++) {
                    char ch = number.charAt(i);
                    if (!Character.isDigit(ch)) {
                        System.out.println("\nPHONE NUMBER INVALID !!");
                        System.out.println("GIVE ANOTHER TRY :)\n");
                        f = 1;
                        i = number.length();
                    }
                }
            }
        } while (f == 1);

        String address;
        System.out.println("\nPLEASE ENTER CONTACT ADDRESS::");
        address = sc.next();

        String email_id;
        do {
            System.out.println("\nPLEASE ENTER CONTACT EMAIL ID::");
            email_id = sc.next();
            int l = email_id.length();
            f = 0;
            int index = 0;
            for (int i = 0; i < l; i++) {
                char ch = email_id.charAt(i);
                if (ch == '@') {
                    index = i;
                    i = l;
                }
            }
            String check = email_id.substring(index + 1, l);
            check = check.trim();
            if (check.equals("gmail.com") || check.equals("yahoo.com") || check.equals("rediffmail.com")
                    || check.equals("outlook.com")) {
                f = 0;
            } else {
                System.out.println("\nEMAIL ID INVALID !!");
                System.out.println("GIVE ANOTHER TRY :)\n");
                f = 1;
            }
        } while (f == 1);

        node new_node = new node(name, number, address, email_id);
        node ptr = root;
        if (root == null) {
            root = new_node;
        }
        while (ptr != null) {
            if (new_node.name.compareTo(ptr.name) < 0) {
                if (ptr.left == null) {
                    ptr.left = new_node;
                    break;
                } else {
                    ptr = ptr.left;
                }
            }

            else if (new_node.name.compareTo(ptr.name) > 0) {
                if (ptr.right == null) {
                    ptr.right = new_node;
                    break;
                } else {
                    ptr = ptr.right;
                }
            }

            else {
                System.out.println("\n\tNAME IS ALREADY PRESENT ");
                break;
            }
        }

        System.out.println("\n__________________________________________________");
        System.out.println(" CONTACT INSERTED IN LIST");
        System.out.println(" PRESS '1' TO INSERT MORE CONTACTS OTHERWISE PRESS '0'");
        System.out.println("__________________________________________________");
        int C = sc.nextInt();
        if (C == 1) {
            insert();
        }
        System.out.println();
    }

    void updateDetails(node ptr) {
        System.out.println("\nWHAT DO YOU WISH TO UPDATE?");
        System.out.println("1. CONTACT NAME");
        System.out.println("2. CONTACT NUMBER");
        System.out.println("3. ADDRESS");
        System.out.println("4. EMAIL ID");
        System.out.println("\nPLEASE ENTER YOUR CHOICE ::");
        int c = sc.nextInt();
        int f = 0, C = 0;
        switch (c) {
            case 1:
                String name = "";
                f = 0;
                do {
                    System.out.println("\nPLEASE ENTER NEW CONTACT NAME::");
                    name = sc.next();
                    f = 0;
                    for (int i = 0; i < name.length(); i++) {
                        char ch = name.charAt(i);
                        if (!Character.isLetter(ch)) {
                            System.out.println("\nNAME INVALID !!\n");
                            System.out.println("GIVE ANOTHER TRY :)\n");
                            f = 1;
                            i = name.length();
                        }
                    }
                } while (f == 1);
                ptr.name = name;
                System.out.println("\n__________________________________________________");
                System.out.println("\tCONTACT NAME UPDATED !!!!!");
                System.out.println("PRESS '1' TO UPDATE OTHER DETAILS OTHERWISE PRESS '0'");
                System.out.println("__________________________________________________");
                C = sc.nextInt();
                if (C == 1) {
                    updateDetails(ptr);
                }
                break;
            case 2:
                String number = "";
                int l;
                f = 0;
                do {
                    System.out.println("\nPLEASE ENTER NEW CONTACT NUMBER ::");
                    number = sc.next();
                    l = number.length();
                    f = 0;
                    if (l != 10) {
                        System.out.println("\nPHONE NUMBER INVALID !!\n");
                        System.out.println("GIVE ANOTHER TRY :)\n");
                        f = 1;
                    } else {
                        for (int i = 0; i < number.length(); i++) {
                            char ch = number.charAt(i);
                            if (!Character.isDigit(ch)) {
                                System.out.println("\nPHONE NUMBER INVALID !!\n");
                                System.out.println("GIVE ANOTHER TRY :)\n");
                                f = 1;
                                i = number.length();
                            }
                        }
                    }
                } while (f == 1);
                ptr.number = number;
                System.out.println("\n__________________________________________________");
                System.out.println("\tCONTACT NUMBER UPDATED !!!!!");
                System.out.println("PRESS '1' TO UPDATE OTHER DETAILS OTHERWISE PRESS '0'");
                System.out.println("__________________________________________________");
                C = sc.nextInt();
                if (C == 1) {
                    updateDetails(ptr);
                }
                break;
            case 3:
                String address;
                System.out.println("\nPLEASE ENTER NEW CONTACT ADDRESS ::");
                address = sc.next();
                ptr.address = address;
                System.out.println("\n__________________________________________________");
                System.out.println("\tCONTACT ADDRESS UPDATED !!!!!");
                System.out.println("PRESS '1' TO UPDATE OTHER DETAILS OTHERWISE PRESS '0'");
                System.out.println("__________________________________________________");
                C = sc.nextInt();
                if (C == 1) {
                    updateDetails(ptr);
                }
                break;
            case 4:
                String email_id;
                do {
                    System.out.println("\nPLEASE ENTER NEW CONTACT EMAIL ID::");
                    email_id = sc.next();
                    l = email_id.length();
                    f = 0;
                    int index = 0;
                    for (int i = 0; i < l; i++) {
                        char ch = email_id.charAt(i);
                        if (ch == '@') {
                            index = i;
                            i = l;
                        }
                    }
                    String check = email_id.substring(index + 1, l);
                    check = check.trim();
                    if (check.equals("gmail.com") || check.equals("yahoo.com") || check.equals("rediffmail.com")
                            || check.equals("outlook.com")) {
                        f = 0;
                    } else {
                        System.out.println("\nEMAIL ID INVALID !!");
                        System.out.println("GIVE ANOTHER TRY :)\n");
                        f = 1;
                    }
                } while (f == 1);
                ptr.email_id = email_id;
                System.out.println("\n__________________________________________________");
                System.out.println("\tCONTACT EMAIL ID UPDATED !!!!!");
                System.out.println("PRESS '1' TO UPDATE OTHER DETAILS OTHERWISE PRESS '0'");
                System.out.println("__________________________________________________");
                C = sc.nextInt();
                if (C == 1) {
                    updateDetails(ptr);
                }
                break;
            default:
                System.out.println("\n\t WRONG CHOICE !!!!!");
                updateDetails(ptr);
        }
        return;
    }

    void UpdateByName() {
        node ptr = null;
        System.out.println("\nPLEASE ENTER THE CONTACT NAME :: ");
        String key = sc.next();
        ptr = root;
        while (ptr != null) {
            if ((ptr.name).equalsIgnoreCase(key)) {
                updateDetails(ptr);
                return;
            }
            if ((ptr.name).compareTo(key) > 0) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        System.out.println("\n\tCONTACT NAME NOT PRESENT !!!!!!!");
    }

    void SearchByName() {
        node ptr = root;
        System.out.println("\nPLEASE ENTER THE CONTACT NAME :: ");
        String key = sc.next();
        while (ptr != null) {
            if (ptr.name.compareTo(key) == 0) {
                System.out.println("\n\t-----RECORD FOUND-----");
                System.out.println("-----------------------------------------------");
                System.out.println("NAME\t\tNUMBER\t\tADDRESS\t\tEMAIL ID  ");
                System.out.println("-----------------------------------------------");
                System.out.println(ptr.name + "\t\t" + ptr.number + "\t\t" + ptr.address + "\t\t" + ptr.email_id);
                return;
            }
            if ((ptr.name).compareTo(key) > 0) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        System.out.println("\n\t-----RECORD NOT FOUND-----");
    }

    
   
    void deletion() {
       
        System.out.println("ENTER THE NAME TO BE DELETED:: ");
        String s=sc.next();
       
        node ptr=root;
        node parent=null;
        while(ptr !=null){
            if(ptr.name.equalsIgnoreCase(s)){
                System.out.println("Data found");
                break;

            }
            else if(s.compareTo(ptr.name)<0) {
                parent=ptr;
                ptr=ptr.left;
            }
            else
            {
                parent=ptr;
                ptr=ptr.right;

            }


        }
        if(ptr==null)
        {
            System.out.println("NAME IS NOT FOUND !!");

        }
        else
        {
            if(ptr.left==null && ptr.right==null)
            {    //if node has 0 children
                if(ptr!=root) {
                    if(parent.left==ptr)
                    {
                        parent.left=null;
                    }
                    else
                    {
                        parent.right=null;
                    }
                }
                else
                {
                    root=null;
                }
            }
            else if(ptr.left!=null && ptr.right==null)
            {          
                if(ptr!=root)
                {
                    if (parent.left == ptr)
                    {  
                        parent.left = ptr.left;
                    }
                    else
                    {
                        parent.right = ptr.left;
                    }
                }
                else
                {
                    parent=root;
                    root=parent.left;

                }
            }
            else if(ptr.left==null && ptr.right!=null){        
                if(ptr!=root) {
                    if(parent.left==ptr)
                    {
                        parent.left=ptr.right;              
                    }
                    else{
                        parent.right=ptr.right;
                    }
                }
                else
                {
                    parent=root;
                    root=parent.right;

                }

            }
            else
            {    
                node p=ptr.left;                  
                node pp=ptr;                    
                while(p.right != null)
                {
                    pp=p;
                    p=p.right;                  
                }
                ptr.name=p.name;    
                if(pp!=ptr)
                {
                    pp.right=p.left;
                }
                if(pp==ptr)
                {
                    pp.left=p.left;
                }
            }
            System.out.println("DELETED SUCCESSFULLY");

        }
   }


}


public class Phone_Directory {

    public static void main(String[] args) {
        bst b = new bst();
        Scanner sc = new Scanner(System.in);
        int ch, ch1;
        System.out.print("\n**********WELCOME TO OUR PHONEBOOK**********\n");
        do {
            System.out.println("\n================================================");
            System.out.println("**********************************************************************");
            System.out.println(" START EXPLORING OUR PHONEBOOK BY CHOOSING ONE OF THE OPTIONS BELOW ");
            System.out.println("**********************************************************************");
            System.out.println("1. CREATE YOUR NEW CONTACT LIST  ");
            System.out.println("2. ADD A NEW CONTACT IN THE LIST ");
            System.out.println("3. EDIT DETAILS OF CONTACT USING NAME ");
            System.out.println("4. SEARCH THE LIST (BY NAME) ");
            System.out.println("5. DELETE ANY CONTACT ");
            System.out.println("6. DISPLAY LIST ");
            System.out.println("7. Exit ");
            System.out.println("=================================================");
            System.out.println();
            System.out.println("\nENTER YOUR CHOICE :- ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    b.create();
                    b.inOrder();
                    break;
                case 2:
                    b.insert();
                    b.inOrder();
                    break;
                case 3:
                    b.UpdateByName();
                    b.inOrder();
                    break;
                case 4:
                    b.SearchByName();
                    break;
                case 5:
                    b.deletion();
                    b.inOrder();
                    break;
                case 6:
                    b.inOrder();
                    break;
                case 7:
                    System.out.println("EXITING FROM THE PHONEBOOK!...");
                    return;
                default:
                    System.out.println("\n\tWRONG CHOICE !!!!!");

            }
            System.out.println("");
            System.out.println("\n.....................................");
            System.out.println("PRESS '1' TO GO TO THE EXPLORE PAGE\nPRESS '0' TO EXIT FROM THE EXPLORE PAGE ");
            System.out.println(".......................................\n");
            ch1 = sc.nextInt();
        } while (ch1 == 1);
    }

}

