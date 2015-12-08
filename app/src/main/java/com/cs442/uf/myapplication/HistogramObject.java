package com.cs442.uf.myapplication;

import java.util.Date;

/**
 * Created by sergio gil on 12/5/15.
 */
public class HistogramObject {


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;
    private Date date;
    private double weight;
    private double height;
    private int age;
    private String gender;
    private double waist;
    private double wrist;
    private double hip;
    private double forearm;
    private double rbmi;
    private double rbmr;
    private double rbfp;

    public HistogramObject() {
    }


    public HistogramObject(String userName, Date date, double weight, double height, int age, String gender, double waist, double wrist, double hip, double forearm, double rbmi, double rbmr, double rbfp) {
        this.userName = userName;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
        this.waist = waist;
        this.wrist = wrist;
        this.hip=hip;
        this.forearm = forearm;
        this.rbmi=rbmi;
        this.rbmr=rbmr;
        this.rbfp=rbfp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getWrist() {
        return wrist;
    }

    public void setWrist(double wrist) {
        this.wrist = wrist;
    }

    public double getHip() {
        return hip;
    }

    public void setHip(double hip) {
        this.hip = hip;
    }


    public double getForearm() {
        return forearm;
    }

    public void setForearm(double forearm) {
        this.forearm = forearm;
    }

    public double getRbmi() {
        return rbmi;
    }

    public void setRbmi(double rbmi) {
        this.rbmi = rbmi;
    }

    public double getRbmr() {
        return rbmr;
    }

    public void setRbmr(double rbmr) {
        this.rbmr = rbmr;
    }

    public double getRbfp() {
        return rbfp;
    }

    public void setRbfp(double rbfp) {
        this.rbfp = rbfp;
    }

}
