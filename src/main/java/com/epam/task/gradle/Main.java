package com.epam.task.gradle;

public class Main {
    public static void main(String[] args){
        new FirstClassInAPIUtils().sendGetRequest("https://www.google.com/");
        new FirstClassInUIUtils().openPage("https://www.google.com/");
    }
}
