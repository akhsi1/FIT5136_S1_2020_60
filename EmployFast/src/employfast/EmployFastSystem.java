/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author akhsi
 */
public class EmployFastSystem {

    public EmployFastSystem() {

    }

    public ArrayList<String> readUsersFile() {
        ArrayList<String> result = new ArrayList<String>();
        String path = "users.txt";
        try {
            FileReader fileName = new FileReader(path);
            Scanner file = new Scanner(fileName);
            while (file.hasNextLine()) {
                result.add(file.nextLine());
            }
            //System.out.println(content);
            fileName.close();
            file.close();
        } catch (IOException e) {
        }
        System.out.println(result);
        return result;
    }

    public String verifyUser(String uname, String pw) {
        String result = "";
        ArrayList<String> usersList = readUsersFile();
        for (int i = 0; i < usersList.size(); i += 3) {
            String username = usersList.get(i);
            String usertype = usersList.get(i + 1);
            String userpassword = usersList.get(i + 2);
            if (uname.equals(username) && pw.equals(userpassword)) {
                result = usertype;
            }
        }
        return result;
    }

}
