package fr.univtln.groupc.entities;

import android.util.Log;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpesnel786 on 09/05/16.
 */


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class CPlayerEntity implements Serializable {
    private int mId;
    private String mNickName;
    private String mEmail;
    private CTeamEntity mTeam;
    private int mXp;
    private int mBagSize;
    private double mLong;
    private double mLat;
    private int mEnergy;
    private int mEnergyMax;

    private List<CSkillEntity> mSkills;

    private List<AObjectEntity> mObjects =new ArrayList<AObjectEntity>();

    public final static String GET_ALL = "Player.getAll";
    public final static String GET_BY_NAME = "Player.getByName";

    public CPlayerEntity(){}

    public CPlayerEntity(CPlayerBuilder pBuilder){
        mId = pBuilder.mId;
        mNickName = pBuilder.mNickName;
        mEmail = pBuilder.mEmail;
        mTeam = pBuilder.mTeam;
        mXp = pBuilder.mXp;
        mBagSize = pBuilder.mBagSize;
        mObjects = pBuilder.mObjects;
        mSkills = pBuilder.mSkills;
        mLat = pBuilder.mLat;
        mLong = pBuilder.mLong;
        mEnergy = pBuilder.mEnergy;
        mEnergyMax = pBuilder.mEnergyMax;
        mBagSize = pBuilder.mBagSize;
    }

    public void print(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "CPlayerEntity{" +
                "mId=" + mId +
                ", mNickName='" + mNickName + '\'' +
                ", mEmail='" + mEmail + '\'' +
                //", mTeam=" + mTeam +
                ", mXp=" + mXp +
                ", mBagSize=" + mBagSize +
                ", mLong=" + mLong +
                ", mLat=" + mLat +
                ", mEnergy=" + mEnergy +
                ", mEnergyMax=" + mEnergyMax +
                ", mSkills=" + mSkills +
                ", mObjects=" + mObjects +
                '}';
    }

    public void setSkills(List<CSkillEntity> pSkills){
        mSkills = pSkills;
    }

    public void addSkill(CSkillEntity pSkill){
        mSkills.add(pSkill);
    }

    public int getId() {
        return mId;
    }

    public void setId(int pId) {
        mId = pId;
    }

    public String getNickName() {
        return mNickName;
    }

    public void setNickName(String pNickName) {
        mNickName = pNickName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String pEmail) {
        mEmail = pEmail;
    }

    public CTeamEntity getTeam() {
        return mTeam;
    }

    public void setTeam(CTeamEntity pTeam) {
        mTeam = pTeam;
    }

    public int getXp() {
        return mXp;
    }

    public void setXp(int pXp) {
        mXp = pXp;
    }

    public int getBagSize() {
        return mBagSize;
    }

    public void setBagSize(int pBagSize) {
        mBagSize = pBagSize;
    }

    public double getLong() {
        return mLong;
    }

    public void setLong(double pLong) {
        mLong = pLong;
    }

    public double getLat() {
        return mLat;
    }

    public void setLat(double pLat) {
        mLat = pLat;
    }

    public int getEnergy() {
        return mEnergy;
    }

    public void setEnergy(int pEnergy) {
        mEnergy = pEnergy;
    }

    public int getEnergyMax() {
        return mEnergyMax;
    }

    public void setEnergyMax(int pEnergyMax) {
        mEnergyMax = pEnergyMax;
    }


    public List<AObjectEntity> getObjects() {
        return mObjects;
    }


    public void setObjects(List<AObjectEntity> pObjects) {
        mObjects = pObjects;
    }

    public void addObjects(AObjectEntity o) {
        mObjects.add(o);
    }

    @JsonIgnore
    public List<CKeyEntity> getKeys(){
        List<CKeyEntity> lKeys = new ArrayList<>();
        for (AObjectEntity lObject : mObjects){
            if (lObject instanceof CKeyEntity){
                lKeys.add((CKeyEntity)lObject);
            }
        }
        return lKeys;
    }

    public static class CPlayerBuilder{
        private int mId;
        private String mNickName;
        private String mEmail;
        private CTeamEntity mTeam;
        private int mEnergy;
        private int mEnergyMax;
        private double mLat;
        private double mLong;
        private int mBagSize;
        private int mXp;
        private List<CSkillEntity> mSkills = new ArrayList<>();
        private List<AObjectEntity> mObjects = new ArrayList<>();

        public CPlayerBuilder(int pId){
            mId = pId;
        }

        public CPlayerBuilder nickname(String pNickName){
            mNickName = pNickName;
            return this;
        }

        public CPlayerBuilder email(String pEmail){
            mEmail = pEmail;
            return this;
        }

        public CPlayerBuilder team(CTeamEntity pTeam){
            mTeam = pTeam;
            return this;
        }

        public CPlayerBuilder longitude(double pLong){
            mLong = pLong;
            return this;
        }

        public CPlayerBuilder latitude(double pLat){
            mLat = pLat;
            return this;
        }

        public CPlayerBuilder energy(int pEnergy){
            mEnergy = pEnergy;
            return this;
        }

        public CPlayerBuilder energyMax(int pEnergyMax){
            mEnergyMax = pEnergyMax;
            return this;
        }

        public CPlayerBuilder xp(int pXp){
            mXp = pXp;
            return this;
        }

        public CPlayerBuilder bagSize(int pBagSize){
            mBagSize = pBagSize;
            return this;
        }

        public CPlayerBuilder objects(List<AObjectEntity> pObjects){
            mObjects = pObjects;
            return this;
        }

        public CPlayerBuilder skills(List<CSkillEntity> pSkills){
            mSkills = pSkills;
            return this;
        }

        public CPlayerEntity build(){
            return new CPlayerEntity(this);
        }
    }


}
