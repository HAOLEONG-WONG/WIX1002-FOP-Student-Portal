package fop_assignment_coco_calculation_part_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FOP_Assignment_Coco_Calculation_Part_1 {
   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Matric Number: ");
        String matric_number=sc.nextLine();
        
        // Define relative paths for the input files
        String fileClubSociety = "./ClubSocieties.txt";
        String fileStudentPositions = "./StudentPositions.txt";
        String fileActivityLog = "./ActivitiesLog.txt";        
        
            
        
        String position_society="";
        String position_uniform_body="";
        String position_sports_club="";
        int check=0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileStudentPositions))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split each line by comma
                String[] parts = line.split(",");
                
                // Extract student ID and positions
                String studentId = parts[0]; // Student ID (e.g., s100201)
                if(studentId.equals(matric_number)){
                    position_society = parts[1]; // First position (e.g., Active Member)
                    position_uniform_body = parts[2]; // Second position (e.g., President)
                    position_sports_club = parts[3]; // Third position (e.g., Vice Secretary)
                    
                }
                else
                    check=check-1;
                
                if (check==-2){
                    System.out.println("Wrong matric number! Please run again the program!");
                    return;}

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String activity_society="";
        String level_activity_society="";
        String achievement_level_activity_society="";
        String society="";
        String society_code="";
        String activity_uniform_body="";
        String level_activity_uniform_body="";
        String achievement_level_activity_uniform_body="";
        String uniform_body="";
        String uniform_body_code="";
        String activity_sports_club="";
        String level_activity_sports_club="";
        String achievement_level_activity_sports_club="";
        String sports_club="";
        String sports_club_code="";
        try (BufferedReader brActivityLog = new BufferedReader(new FileReader(fileActivityLog))) {
            String line;
            while ((line = brActivityLog.readLine()) != null) {
                // Split each line by comma
                String[] parts = line.split(",");

                // Extract the individual components
                String studentId = parts[0];        // Student ID (e.g., s100201)

                if(studentId.equals(matric_number)){
                    String clubCode_check = parts[1];         // Club Code (e.g., P82)
                    if(clubCode_check.charAt(0)=='P'){
                        activity_society = parts[2];           // Activity Name (e.g., National Robotics Competition 2024)
                        level_activity_society = parts[3];          // Activity Level (e.g., National)
                        achievement_level_activity_society = parts[4];       // Achievement Level (e.g., Gold)

                        // Now, find the club name by matching the club code with the ClubSocieties.txt file
                        society = "";
                        try (BufferedReader brClubSociety = new BufferedReader(new FileReader(fileClubSociety))) {
                            String clubLine;
                            while ((clubLine = brClubSociety.readLine()) != null) {
                                // Split each line by comma
                                String[] clubParts = clubLine.split(",");
                                String clubCode = clubParts[0]; // Club Code
                                if(clubCode_check.equals(clubCode)){
                                    society = clubParts[1]; // Club Name
                                    society_code=clubCode;
                                    break; // Exit once we find the matching club
                                }
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                    }      }
                    if(clubCode_check.charAt(0)=='B'){
                        activity_uniform_body = parts[2];           // Activity Name (e.g., National Robotics Competition 2024)
                        level_activity_uniform_body = parts[3];          // Activity Level (e.g., National)
                        achievement_level_activity_uniform_body = parts[4];       // Achievement Level (e.g., Gold)

                        // Now, find the club name by matching the club code with the ClubSocieties.txt file
                        
                        try (BufferedReader brClubSociety = new BufferedReader(new FileReader(fileClubSociety))) {
                            String clubLine;
                            while ((clubLine = brClubSociety.readLine()) != null) {
                                // Split each line by comma
                                String[] clubParts = clubLine.split(",");
                                String clubCode = clubParts[0]; // Club Code
                                if(clubCode_check.equals(clubCode)){
                                    uniform_body = clubParts[1]; // Club Name
                                    uniform_body_code=clubCode;
                                    break; // Exit once we find the matching club
                                }
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                    }      }
                    if(clubCode_check.charAt(0)=='S'){
                        activity_sports_club = parts[2];           // Activity Name (e.g., National Robotics Competition 2024)
                        level_activity_sports_club = parts[3];          // Activity Level (e.g., National)
                        achievement_level_activity_sports_club = parts[4];       // Achievement Level (e.g., Gold)

                        // Now, find the club name by matching the club code with the ClubSocieties.txt file
                        sports_club = "";
                        try (BufferedReader brClubSociety = new BufferedReader(new FileReader(fileClubSociety))) {
                            String clubLine;
                            while ((clubLine = brClubSociety.readLine()) != null) {
                                // Split each line by comma
                                String[] clubParts = clubLine.split(",");
                                String clubCode = clubParts[0]; // Club Code
                                if(clubCode_check.equals(clubCode)){
                                    sports_club = clubParts[1]; // Club Name
                                    sports_club_code=clubCode;
                                    break; // Exit once we find the matching club
                                }
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                    }      }                   
                    


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Uniform Body: " + uniform_body); // Debugging line
       
        
        System.out.println("");

        
        System.out.println("Cocurriculum Transcript for "+matric_number);
        System.out.println("============================================");
        
        System.out.println("["+society_code+" - "+society+"]");
        System.out.println("Attendance: assume full -----------> 50/50 marks");
        int position_society_mark=0;
        switch (position_society) {
            case "President" -> position_society_mark=10;
            case "Vice President" -> position_society_mark=9;
            case "Vice Secretary" -> position_society_mark=8;
            case "Committee" -> position_society_mark=7;
            case "Active Member" -> position_society_mark=6;
            default -> position_society_mark=6;
        }
         System.out.println("Position: "+position_society+"-----------> "+position_society_mark+"/10 marks");
         System.out.println("");
         System.out.println("Selected Activity: "+activity_society);
         int level_activity_society_mark=0;
         
        switch (level_activity_society) {
            case "International" -> level_activity_society_mark=20;
            case "National" -> level_activity_society_mark=15;
            case "State" -> level_activity_society_mark=12;
            case "School" -> level_activity_society_mark=10;
            default -> level_activity_society_mark=0;
        }
         
         System.out.println("Level of Activities: "+level_activity_society+" -----------> "+level_activity_society_mark+"/20 marks");
         int achievement_level_activity_society_mark=0;
        switch (achievement_level_activity_society) {
            case "Gold" -> achievement_level_activity_society_mark=20;
            case "Silver" -> achievement_level_activity_society_mark=19;
            case "Bronze" -> achievement_level_activity_society_mark=18;
            case "Participation" -> achievement_level_activity_society_mark=0;
            default -> achievement_level_activity_society_mark=0;
        }
         System.out.println("Achievement Level: "+achievement_level_activity_society+" ----> "+achievement_level_activity_society_mark+"/20 marks");
         System.out.println("===========================================================");
         int total_society=50+position_society_mark+level_activity_society_mark+achievement_level_activity_society_mark;
         System.out.println("Total: "+total_society+"/100 marks");
         System.out.println("===========================================================");
         
        System.out.println("["+uniform_body_code+" - "+uniform_body+"]");
        System.out.println("Attendance: assume full -----------> 50/50 marks");
        int position_uniform_body_mark=0;
        switch (position_uniform_body) {
            case "President" -> position_uniform_body_mark=10;
            case "Vice President" -> position_uniform_body_mark=9;
            case "Vice Secretary" -> position_uniform_body_mark=8;
            case "Committee" -> position_uniform_body_mark=7;
            case "Active Member" -> position_uniform_body_mark=6;
            default -> position_uniform_body_mark=0;
        }
         System.out.println("Position: "+position_uniform_body+"-----------> "+position_uniform_body_mark+"/10 marks");
         System.out.println("");
         System.out.println("Selected Activity: "+activity_uniform_body);
         int level_activity_uniform_body_mark=0;
         
        switch (level_activity_uniform_body) {
            case "International" -> level_activity_uniform_body_mark=20;
            case "National" -> level_activity_uniform_body_mark=15;
            case "State" -> level_activity_uniform_body_mark=12;
            case "School" -> level_activity_uniform_body_mark=10;
            default -> level_activity_uniform_body_mark=0;
        }
         
         System.out.println("Level of Activities: "+level_activity_uniform_body+" -----------> "+level_activity_uniform_body_mark+"/20 marks");
         int achievement_level_activity_uniform_body_mark=0;
        switch (achievement_level_activity_uniform_body) {
            case "Gold" -> achievement_level_activity_uniform_body_mark=20;
            case "Silver" -> achievement_level_activity_uniform_body_mark=19;
            case "Bronze" -> achievement_level_activity_uniform_body_mark=18;
            case "Participation" -> achievement_level_activity_uniform_body_mark=0;
            default -> achievement_level_activity_uniform_body_mark=0;
        }
         System.out.println("Achievement Level: "+achievement_level_activity_uniform_body+" ----> "+achievement_level_activity_uniform_body_mark+"/20 marks");
         System.out.println("===========================================================");
         int total_uniform_body=50+position_uniform_body_mark+level_activity_uniform_body_mark+achievement_level_activity_uniform_body_mark;
         System.out.println("Total: "+total_uniform_body+"/100 marks");
         System.out.println("===========================================================");
         
         
         System.out.println("["+sports_club_code+" - "+sports_club+"]");
        System.out.println("Attendance: assume full -----------> 50/50 marks");
        int position_sports_club_mark=0;
        switch (position_sports_club) {
            case "President" -> position_sports_club_mark=10;
            case "Vice President" -> position_sports_club_mark=9;
            case "Vice Secretary" -> position_sports_club_mark=8;
            case "Committee" -> position_sports_club_mark=7;
            case "Active Member" -> position_sports_club_mark=6;
            default ->  position_sports_club_mark=0;
        }
         System.out.println("Position: "+position_sports_club+"-----------> "+position_sports_club_mark+"/10 marks");
         System.out.println("");
         System.out.println("Selected Activity: "+activity_sports_club);
         int level_activity_sports_club_mark=0;
         
        switch (level_activity_sports_club) {
            case "International" -> level_activity_sports_club_mark=20;
            case "National" -> level_activity_sports_club_mark=15;
            case "State" -> level_activity_sports_club_mark=12;
            case "School" -> level_activity_sports_club_mark=10;
            default -> level_activity_sports_club_mark=0;
        }
         
         System.out.println("Level of Activities: "+level_activity_sports_club+" -----------> "+level_activity_sports_club_mark+"/20 marks");
         int achievement_level_activity_sports_club_mark=0;
        switch (achievement_level_activity_sports_club) {
            case "Gold" -> achievement_level_activity_sports_club_mark=20;
            case "Silver" -> achievement_level_activity_sports_club_mark=19;
            case "Bronze" -> achievement_level_activity_sports_club_mark=18;
            case "Participation" -> achievement_level_activity_sports_club_mark=0;
            default -> achievement_level_activity_sports_club_mark=0;
        }
         System.out.println("Achievement Level: "+achievement_level_activity_sports_club+" ----> "+achievement_level_activity_sports_club_mark+"/20 marks");
         System.out.println("===========================================================");
         int total_sports_club=50+position_sports_club_mark+level_activity_sports_club_mark+achievement_level_activity_sports_club_mark;
         System.out.println("Total: "+total_sports_club+"/100 marks");
         System.out.println("===========================================================");
         
         
         int max1=Math.max(total_society, Math.max(total_uniform_body,total_sports_club));
         
         if (max1 == total_society)
            total_society = 0;
         else if (max1 == total_uniform_body)
            total_uniform_body = 0;
         else if (max1 == total_sports_club)
            total_sports_club = 0;
         
        int max2=Math.max(total_society, Math.max(total_uniform_body,total_sports_club));
        
        double sum=(max1+max2)/2.0;
        
        System.out.printf("FINAL MARKS: %.1f marks", sum);
        System.out.println("");
        
    }
    
}
