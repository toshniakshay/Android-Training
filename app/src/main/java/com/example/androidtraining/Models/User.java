package com.example.androidtraining.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Simple model class that will hold all the information with respect to user
 */
@Entity(tableName = "user_table")
public class User implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "external_id")
    private int external_id;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "gender")
    private int gender;

    @ColumnInfo(name = "country")
    private String country;

    @ColumnInfo(name = "state")
    private String state;

    @NonNull
    @ColumnInfo(name = "email_address")
    private String emailAddress;

    @NonNull
    @ColumnInfo(name = "phone_number")
    private String phoneNumber;

    protected User(Parcel in) {
        id = in.readInt();
        external_id = in.readInt();
        firstName = in.readString();
        lastName = in.readString();
        gender = in.readInt();
        country = in.readString();
        state = in.readString();
        emailAddress = in.readString();
        phoneNumber = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExternal_id() {
        return external_id;
    }

    public void setExternal_id(int external_id) {
        this.external_id = external_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(external_id);
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeInt(gender);
        parcel.writeString(country);
        parcel.writeString(state);
        parcel.writeString(emailAddress);
        parcel.writeString(phoneNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", external_id=" + external_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
