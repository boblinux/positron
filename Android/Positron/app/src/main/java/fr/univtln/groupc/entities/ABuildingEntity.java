package fr.univtln.groupc.entities;

/**
 * Created by marti on 09/05/2016.
 */


public abstract class ABuildingEntity extends AObjectEntity {
    private double mLong;
    private double mLat;
    private int mLifeTime;
    private int mRadius;
    private int mLevel;
    private int mEnergyMax;
    private int mEnergy;

    public ABuildingEntity(){
        super();
    }


    public ABuildingEntity(int pId, String pName, double pLong, double pLat, int pLifeTime, int pRadius, int pLevel, int pEnergy, int pEnergyMax){
        super(pId, pName);
        mLong = pLong;
        mLat = pLat;
        mLifeTime = pLifeTime;
        mRadius = pRadius;
        mLevel = pLevel;
        mEnergy = pEnergy;
        mEnergyMax = pEnergyMax;
    }

    @Override
    public String toString() {
        return  super.toString() + "ABuildingEntity{" +
                "mLong=" + mLong +
                ", mLat=" + mLat +
                ", mLifeTime=" + mLifeTime +
                ", mRadius=" + mRadius +
                ", mLevel=" + mLevel +
                ", mEnergyMax=" + mEnergyMax +
                ", mEnergy=" + mEnergy +
                '}';
    }

    public double getLong() {
        return mLong;
    }

    public void setLong(float pLong) {
        mLong = pLong;
    }

    public double getLat() {
        return mLat;
    }

    public void setLat(float pLat) {
        mLat = pLat;
    }

    public int getRadius() {
        return mRadius;
    }

    public void setRadius(int pRadius) {
        mRadius = pRadius;
    }

    public int getLifeTime() {
        return mLifeTime;
    }

    public void setLifeTime(int pLifeTime) {
        mLifeTime = pLifeTime;
    }

    public int getLevel() {
        return mLevel;
    }

    public void setLevel(int pLevel) {
        mLevel = mLevel;
    }

    public int getEnergyMax() {
        return mEnergyMax;
    }

    public void setEnergyMax(int pEnergyMax) {
        mEnergyMax = pEnergyMax;
    }

    public int getEnergy() {
        return mEnergy;
    }

    public void setEnergy(int pEnergy) {
        mEnergy = pEnergy;
    }
}