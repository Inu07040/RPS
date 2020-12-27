import dao.GraduateDAO;
import dao.GroupDAO;
import model.Group;
import model.Graduate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GroupDAO groupDAO = new GroupDAO();
        GraduateDAO graduateDAO = new GraduateDAO();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Menu:");
        System.out.println("1 - Add group");
        System.out.println("2 - View group");
        System.out.println("3 - Update group");
        System.out.println("4 - Delete group");
        System.out.println("5 - Update graduate");
        System.out.println("6 - View graduate");
        System.out.println("7 - Add graduate");
        System.out.println("8 - Delete graduate");
        System.out.println("9 - Exit");
        boolean k = true;
        while(k){
            System.out.println("Input command");
            int command = scanner.nextInt();
            switch (command){
                case 1:
                    System.out.print("Title group: ");
                    String title = scanner.next();
                    System.out.print("Direction: ");
                    String direction = scanner.next();
                    groupDAO.add(new Group(title, direction));
                    break;
                case 2:
                    System.out.println("Input id");
                    int id = scanner.nextInt();
                    Group group = groupDAO.getOneById(id);
                    System.out.print("Title group: ");
                    System.out.println(group.getTitle());
                    System.out.print("Direction: ");
                    System.out.println(group.getDirection());
                    break;
                case 3:
                    System.out.println("Input id");
                    int idd = scanner.nextInt();
                    System.out.println("Title group: ");
                    String updTitle = scanner.next();
                    System.out.println("Direction: ");
                    String updDirection = scanner.next();
                    groupDAO.update(idd,new Group(updTitle, updDirection));
                    break;
                case 4:
                    System.out.println("Input id");
                    int delId = scanner.nextInt();
                    groupDAO.delete(delId);
                    break;
                case 5:
                    System.out.println("Input id");
                    int idS = scanner.nextInt();
                    System.out.println("Last Name: ");
                    String updLastName = scanner.next();
                    System.out.println("First Name: ");
                    String updFirstName = scanner.next();
                    System.out.println("Group id: ");
                    int updGroup_id = scanner.nextInt();
                    graduateDAO.update(idS,new Graduate(updLastName, updFirstName, updGroup_id));
                    break;
                case 6:
                    System.out.println("Input id");
                    int idGraduate = scanner.nextInt();
                    Graduate graduate = graduateDAO.getOneById(idGraduate);
                    System.out.print("Last Name: ");
                    System.out.println(graduate.getLastName());
                    System.out.print("First Name: ");
                    System.out.println(graduate.getFirstName());
                    System.out.print("Group id: ");
                    System.out.println(graduate.getGroup_id());
                    break;
                case 7:
                    System.out.println("Last Name: ");
                    String last_name = scanner.next();
                    System.out.println("First Name: ");
                    String first_name = scanner.next();
                    System.out.println("Group id: ");
                    int group_id = scanner.nextInt();
                    graduateDAO.add(new Graduate(last_name, first_name, group_id));
                    break;
                case 8:
                    System.out.println("Input id");
                    int deleteId = scanner.nextInt();
                    graduateDAO.delete(deleteId);
                    break;
                case 9:
                    k = false;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }
}
