package com.dahdotech.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.dahdotech.contactmanager.data.DatabaseHandler;
import com.dahdotech.contactmanager.model.Contact;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);

//        db.addContact(new Contact("James", "213986"));
//        db.addContact(new Contact("Greg", "098765"));
//        db.addContact(new Contact("Helena", "40678765"));
//        db.addContact(new Contact("Carimo", "768345"));
//
//        db.addContact(new Contact("Silo", "3445"));
//        db.addContact(new Contact("Santos", "6665"));
//        db.addContact(new Contact("Litos", "5344"));
//        db.addContact(new Contact("Karate", "96534"));
//        db.addContact(new Contact("Guerra", "158285"));
//        db.addContact(new Contact("Gema", "78130"));

        for (int i = 0; i < 100; i++) {
            db.addContact(new Contact(randomName((int)Math.floor(Math.random() * 8 + 3)),
                    randomPhoneNumber(12)));
        }

        List<Contact> contactList = db.getAllContacts();
        for (Contact contact : contactList) {
            //Log.d("now", "contact " + contact);
            //db.deleteContact(contact);
        }
        Log.d("number", "contact " + db.getCount());
    }



    public String randomName(int len){
        String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerChars = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(len);
        sb.append(upperChars.charAt(rand.nextInt(upperChars.length())));
        for (int i = 0; i < len - 1; i++)
            sb.append(lowerChars.charAt(rand.nextInt(lowerChars.length())));

        return sb.toString();
    }

    public String randomPhoneNumber(int len){
        String numbers = "0123456789";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(len);
        sb.append("+" + (int)Math.floor((Math.random() * 9 + 1)));
        for (int i = 0; i < len - 1; i++)
            sb.append(numbers.charAt(rand.nextInt(numbers.length())));

        return sb.toString();
    }
}


