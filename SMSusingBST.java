import java.util.Scanner;

public class SMSusingBST {
    Node root;
    Node head;
    class Node{
        Node left;
        Node right;
        Node next;
        Node prev;
        String name;
        Long phone;
        Long endroll;
        String branch;
        int sem;
        Node(Long endroll){
            this.endroll=endroll;
        }
        public Node(String name, Long phone, Long endroll, String branch, int sem) {
            this.name = name;
            this.phone = phone;
            this.endroll = endroll;
            this.branch = branch;
            this.sem = sem;
        }
        public String getName() {
            return name;
        }
        public Long getPhone() {
            return phone;
        }
        public Long getEndroll() {
            return endroll;
        }
        public String getBranch() {
            return branch;
        }
        public int getSem() {
            return sem;
        }
    }
    void insert(String name, Long phone, Long value, String branch, int sem){
        root=insert(name,phone,value,branch,sem, root);
    }
    Node insert(String name, Long phone, Long value, String branch, int sem,Node node){
        if (node==null) {
            Node n= new Node(name,phone,value,branch,sem);
            return n;
        }
        if (value<node.endroll) {
            node.left=insert(name,phone,value,branch,sem, node.left);
        }
        if (value>node.endroll) {
            node.right=insert(name,phone,value,branch,sem, node.right);
        }
        return node;
    }
    void search(Long value){
        root=search(value,root);
    }
    Node search(Long value,Node node){
        if (node.endroll==value) {
            System.out.println("Name : "+node.getName());
            System.out.println("Endrollement number : "+node.getEndroll());
            System.out.println("Branch : "+node.getBranch());
            System.out.println("Current sem of studing : "+node.getSem());
            System.out.println("Phone number : "+node.getPhone());  
            return node;
        }
        if (node.endroll>value) {
            node.left=search(value,node.left);
        }
        if (node.endroll<value) {
            node.right=search(value, node.right);
        }
        return node;
    }
    void display(){
         display(root,"Root Node: ");
    }
    void display(Node node,String details){
        if (node==null) {
            return;
        }
        System.out.println(details+node.getEndroll()+" "+node.getName());
        display(node.left,"Left chid of "+node.getEndroll()+" is :");
        display(node.right,"Right child of "+node.getEndroll()+" is :");
    }
    void insert_into_DLL(String name, Long phone, Long endroll, String branch, int sem){
        Node n= new Node(name, phone, endroll, branch, sem);
        if (head==null) {
            head=n;
        }
        else{
            Node temp=head;
            while (temp.next!=null) {
                temp=temp.next;
            }
            temp.next=n;
            n.prev=temp;
        }
    }
    void displayDLL(){
        
        if (head==null) {
            System.out.println("\"*****THE LIST IS EMPTY*****\"");
        }
        else{
            Node temp=head;
        while (temp!=null) {
            System.out.println("Name : "+temp.name);
            System.out.println("Endrollment Number : "+temp.endroll);
            System.out.println("Branch : "+temp.branch);
            System.out.println("Current sem of studing : "+temp.sem);
            System.out.println("Phone Number  : "+temp.phone);
            System.out.println();
            temp=temp.next;
        }
    }

    }
    void update(Long endroll){
        
    }
    void delete(String n){
        int flag = 0;
        if(head == null){
            System.out.println("List is empty");
         
        }
        else{
            Node temp = head;
            while(temp != null){
                if(temp.name.equalsIgnoreCase(n)){ //compare 2 strings by ignoring upper and lower case
                    flag = 1;
                    break;
                }
                temp = temp.next;
            }
        }
        if(flag == 1){
            System.out.println("Student is present in the list");
            if((head.name.equalsIgnoreCase(n)))
            {
             if(head.next == null){
               head = null;}
            }
            else
            {
               Node temp = head;
               while(temp.next != null)
               {
                if (temp.name.equalsIgnoreCase(n)) {
                    break;
                }
                 temp = temp.next;
               }
             if(temp.next == null)
             {
                temp.prev.next = null;
                temp.prev = null;
             }
             else
              {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp.next = null;
                temp.prev = null;
              }
            }
            System.out.println();
             System.out.println("***** THE DATA OF "+n+" HAS BEEN DELETED SUCCESSFULLY *****");
             System.out.println();
        }
        else{
            System.out.println("The entered name is not present in the list");
        }
    }

    public static void main(String[] args) {
        SMSusingBST s= new SMSusingBST();
        Scanner sc= new Scanner(System.in);
        int choice=-1;
        while (choice!=0) {
            System.out.println("""
            * * * * * * * * * * * * * * * * * * 
            *    Press 0. To exit             *
            *    Press 1. To Add Student      *
            *    Press 2. To display Student  *  
            *    Press 3. To remove Student   *  
            *    Press 4. To Search student   * 
            *                                 *  
            * * * * * * * * * * * * * * * * * *  
            """);
            
            System.out.println("Enter the choice ");
            choice =sc.nextInt();
            switch (choice) {
                case 1->{
                   
                   System.out.println("Enter the Name of Student");
                   sc.next();
                   String name=sc.nextLine();
                   System.out.println("Enter the endrollement number of student");
                   long end= sc.nextLong();
                   System.out.println("Enter the Branch of student");
                   String branch=sc.next();
                   System.out.println("Enter the current sem of student");
                   int sem=sc.nextInt();
                   System.out.println("Enter the Phone number of student");
                   long num=sc.nextLong();
                   s.insert(name,num,end, branch, sem);
                   s.insert_into_DLL(name,num,end, branch, sem);
                   System.out.println("*******STUDENT ADDDED SUCCESSFULLY*******");
                   System.out.println();

                }
                case 2->{
                    System.out.println();
                   System.out.println("***********LIST OF STUDENTS***********");
                   System.out.println();
                   s.displayDLL();
                }
                case 3->{
                    System.out.println();
                    System.out.println("Enter the name of student to delete");
                    String name=sc.next();
                    s.delete(name);
                }
                case 4->{
                    System.out.println("Enter the Endrollement number of student to search");
                    Long endroll=sc.nextLong();
                    s.search(endroll);
                }
            
                default->{
                    break;
                }
                    
            }        

        }

        
    }
}
