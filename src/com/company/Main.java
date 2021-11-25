package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0914 584 8804");


    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printAction();
        while(!quit){
            System.out.println("enter actions: (6 to show avalibale actions)");
            int action = scanner.nextByte();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printAction();
                    break;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }

    }

    private static void addNewContact(){
        System.out.println("enter new contacts name: ");
        String name = scanner.nextLine();
        System.out.println("enter a phone number: ");
        String phone = scanner.nextLine();
        Contacts newContact = Contacts.createScontact(name, phone);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("new contact added " + name);
        }else {
            System.out.println("cannot add " + name + ". its already on file.");
        }
    }

    private static void updateContact(){
        System.out.println("enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("contact noy found");
            return;
        }
        System.out.println("enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("enter new contact phone number: ");
        String newPhoneNumber = scanner.nextLine();
        Contacts newContact = Contacts.createScontact(newName, newPhoneNumber);
        if(mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("updated succesfully");
        }else{
            System.out.println("error updating record");
        }
    }
    private static void removeContact() {
        System.out.println("enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("contact noy found");
            return;
        }
        if (mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("successfully deleted");
        } else {
            System.out.println("error deleting contact");
        }
    }
    private static void queryContact() {
        System.out.println("enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("contact noy found");
            return;
        }
        System.out.println("name: " + existingContactRecord.getName() + "  phone numner: " + existingContactRecord.getPhoneNumber());
    }

    private static void startPhone(){
        System.out.println("Starting phone ...");
    }

    private static void printAction(){
        System.out.println("Avalible actions ");
        System.out.println("0 -- to shutdown\n" +
                            "1 == to print contacts\n"+
                            "2 -- to ad a new contact\n"+
                            "3 -- to update an existing contact\n"+
                            "4 -- to remove an exinsting contact\n"+
                            "5 -- to print a list of avalible actions.");
        System.out.println("choose your action: ");

    }
}
