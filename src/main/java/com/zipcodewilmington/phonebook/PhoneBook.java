package com.zipcodewilmington.phonebook;

import java.util.List;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> numbers = new ArrayList<>();
        numbers.add(phoneNumber);
        phonebook.put(name, numbers);

    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> numbers = new ArrayList<>();
        for (String number : phoneNumbers){
            numbers.add(number);
        }
        phonebook.put(name, numbers);
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        Boolean present = false;
        if (phonebook.containsKey(name)){
            present = true;
        }
        return present;
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (String key : phonebook.keySet()){
            if (phonebook.get(key).contains(phoneNumber)){
                return key;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> output = new ArrayList<>();
        output.addAll(phonebook.keySet());
        return output;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
