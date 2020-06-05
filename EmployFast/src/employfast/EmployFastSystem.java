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

    private Mission selectedMission;
    private Shuttle selectedShuttle;

    public EmployFastSystem() {
    }

    public boolean hasMissionSelected() {
        if (selectedMission != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasShuttleSelected() {
        if (selectedShuttle != null) {
            return true;

        } else {
            return false;
        }
    }

    public boolean hasSelectionCriteria() {
        if (hasMissionSelected()) {
            if (selectedMission.getSelectionCriteria().getSelectionRangeOfAge() != null
                    && selectedMission.getSelectionCriteria().getSelectionHealthRecords() != null
                    && selectedMission.getSelectionCriteria().getSelectionQualifications() != null) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> readUsersFile() {
        ArrayList<String> result = new ArrayList<String>();
        String path = "users";
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
        return result;
    }

    public User verifyUser(String uname, String pw) {
        String result = "";
        ArrayList<String> usersList = readUsersFile();
        User u = new User();
        for (int i = 0; i < usersList.size(); i += 4) {
            String userId = usersList.get(i);
            String username = usersList.get(i + 1);
            String usertype = usersList.get(i + 2);
            String userpassword = usersList.get(i + 3);
            if (uname.equals(username) && pw.equals(userpassword)) {
                u = new User(userId, username, usertype, userpassword);
            }
        }
        return u;
    }

    public Shuttle getSelectedShuttle() {
        return selectedShuttle;
    }

    public Mission getSelectedMission() {
        return selectedMission;
    }
    
    public void setSelectedMission(Mission m){
        selectedMission = m;
    }

    public void setSelectedShuttle(Shuttle s) {
        selectedShuttle = s;
    }

    public void rangeOfAgeSetting(String rangeOfAge) {
        selectedMission.getSelectionCriteria().setSelectionRangeOfAge(rangeOfAge);
    }

    public void healthSetting(String healthRank) {
        selectedMission.getSelectionCriteria().setSelectionHealthRecords(healthRank);
    }

    public void qualificationSetting(ArrayList<String> qualification) {
        selectedMission.getSelectionCriteria().setSelectionQualifications(qualification);
    }

    public ArrayList<Candidate> getNBestCandidates() {
        EmployFast ef = new EmployFast();
        ArrayList<Candidate> clist = new ArrayList<Candidate>();
        clist = ef.getCandidateList();
        ArrayList<Candidate> nBest1 = new ArrayList<Candidate>();
        ArrayList<Candidate> nBest2 = new ArrayList<Candidate>();
        ArrayList<Candidate> nBest3 = new ArrayList<Candidate>();
        ArrayList<Candidate> finalList = new ArrayList<Candidate>();

        //get number of candidates required:
        int count = getRequiredTitleCount();

        //define mission criteria
        String missionAgeRange = selectedMission.getSelectionCriteria().getSelectionRangeOfAge();
        String[] ages = missionAgeRange.split("-");
        int minAge = Integer.valueOf(ages[0]);
        int maxAge = Integer.valueOf(ages[1]);
        String missionHealthRecords = selectedMission.getSelectionCriteria().getSelectionHealthRecords();
        ArrayList<String> missionQualifications = selectedMission.getSelectionCriteria().getSelectionQualifications();

        //fill list of candidates who fit the selection criteria until N count
        for (Candidate c : clist) {
            int score = 0;
            int candAge = c.getCandAge();
            String candHealthRecords = c.getCandidateHealthRecords();
            ArrayList<String> candQuals = c.getCandidateQualifications();
            if (candAge > minAge && candAge < maxAge) {
                score++;
            }
            if (!candHealthRecords.equals(missionHealthRecords) || candHealthRecords.trim().toUpperCase().equals("NONE")) {
                score++;
            }
            for (String s : candQuals) {
                if (missionQualifications.contains(candQuals)) {
                    score++;
                }
            }
            if (score == 3) {
                nBest1.add(c);
            }
            if (score == 2) {
                nBest2.add(c);
            }
            if (score == 1) {
                nBest3.add(c);
            }
        }

        for (Candidate c : nBest1) {
            if (finalList.size() < count) {
                finalList.add(c);
            }
        }
        for (Candidate c : nBest2) {
            if (finalList.size() < count) {
                finalList.add(c);
            }
        }
        for (Candidate c : nBest3) {
            if (finalList.size() < count) {
                finalList.add(c);
            }
        }
        return finalList;
    }

    public void setMissionCandidates(ArrayList<Candidate> clist) {
        selectedMission.setBestNCandidates(clist);
    }

    public int getRequiredTitleCount() {
        ArrayList<RequiredTitle> rt = selectedMission.getMissionTitles();
        int count = 0;
        for (RequiredTitle r : rt) {
            count = count + r.getRequiredTitleCount();
        }
        return count;
    }

}
