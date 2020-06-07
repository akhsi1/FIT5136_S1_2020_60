/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employfast;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author akhsi
 */
public class Candidate extends User{
    private String userId;
    private String userName;
    private String userType;
    private String password;
    private String candidateStreet;
    private String candidateCity;
    private String candidatePostal;
    private String candidateCountry;
    private String candidatePhone;
    private String candidateGender;
    private String candidateAllergies;
    private String candidateFoodPreferences;
    private String candidateYearsOfWork;
    private String candidateComputerSkills;
    private String candidateLanguagesKnown;
    private String candidateCriminalRecords;
    private ArrayList<Mission> candidateOffers;
    private Date candDob;
    private String candidateHealthRecords;
    private ArrayList<String> candidateQualifications;
    private int candAge;
    
    
    public Candidate (String userId, String userName, String userType, String password) {
        super(userId, userName, userType, password);
    }
    
    public Candidate(String userId, String userName, int age, String healthRecords, ArrayList<String> qualifications){
        this.userId = userId;
        this.userName = userName;
        candAge = age;
        candidateHealthRecords = healthRecords;
        candidateQualifications = qualifications;
    }

    public int getCandAge() {
        return candAge;
    }

    public void setCandAge(int candAge) {
        this.candAge = candAge;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCandidateStreet() {
        return candidateStreet;
    }

    public void setCandidateStreet(String candidateStreet) {
        this.candidateStreet = candidateStreet;
    }

    public String getCandidateCity() {
        return candidateCity;
    }

    public void setCandidateCity(String candidateCity) {
        this.candidateCity = candidateCity;
    }

    public String getCandidatePostal() {
        return candidatePostal;
    }

    public void setCandidatePostal(String candidatePostal) {
        this.candidatePostal = candidatePostal;
    }

    public String getCandidateCountry() {
        return candidateCountry;
    }

    public void setCandidateCountry(String candidateCountry) {
        this.candidateCountry = candidateCountry;
    }

    public String getCandidatePhone() {
        return candidatePhone;
    }

    public void setCandidatePhone(String candidatePhone) {
        this.candidatePhone = candidatePhone;
    }

    public String getCandidateGender() {
        return candidateGender;
    }

    public void setCandidateGender(String candidateGender) {
        this.candidateGender = candidateGender;
    }

    public String getCandidateAllergies() {
        return candidateAllergies;
    }

    public void setCandidateAllergies(String candidateAllergies) {
        this.candidateAllergies = candidateAllergies;
    }

    public String getCandidateFoodPreferences() {
        return candidateFoodPreferences;
    }

    public void setCandidateFoodPreferences(String candidateFoodPreferences) {
        this.candidateFoodPreferences = candidateFoodPreferences;
    }

    public String getCandidateYearsOfWork() {
        return candidateYearsOfWork;
    }

    public void setCandidateYearsOfWork(String candidateYearsOfWork) {
        this.candidateYearsOfWork = candidateYearsOfWork;
    }

    public String getCandidateComputerSkills() {
        return candidateComputerSkills;
    }

    public void setCandidateComputerSkills(String candidateComputerSkills) {
        this.candidateComputerSkills = candidateComputerSkills;
    }

    public String getCandidateLanguagesKnown() {
        return candidateLanguagesKnown;
    }

    public void setCandidateLanguagesKnown(String candidateLanguagesKnown) {
        this.candidateLanguagesKnown = candidateLanguagesKnown;
    }

    public String getCandidateCriminalRecords() {
        return candidateCriminalRecords;
    }

    public void setCandidateCriminalRecords(String candidateCriminalRecords) {
        this.candidateCriminalRecords = candidateCriminalRecords;
    }

    public ArrayList<Mission> getCandidateOffers() {
        return candidateOffers;
    }

    public void setCandidateOffers(ArrayList<Mission> candidateOffers) {
        this.candidateOffers = candidateOffers;
    }

    public Date getCandDob() {
        return candDob;
    }

    public void setCandDob(Date candDob) {
        this.candDob = candDob;
    }

    public String getCandidateHealthRecords() {
        return candidateHealthRecords;
    }

    public void setCandidateHealthRecords(String candidateHealthRecords) {
        this.candidateHealthRecords = candidateHealthRecords;
    }

    public ArrayList<String> getCandidateQualifications() {
        return candidateQualifications;
    }

    public void setCandidateQualifications(ArrayList<String> candidateQualifications) {
        this.candidateQualifications = candidateQualifications;
    }
    
}
