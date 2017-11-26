/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owscraper;

/**
 * HeroStats holds basic stats for each hero
 * @author Ben
 */
public class HeroStats {
    
    private String timePlayed;
    private int timePlayedInSeconds;
    private int gamesWon;
    private int winPercentage;
    private int weaponAccuracy;
    private float eliminationsPerLife;
    private int multiKillBest;
    private float objectiveKills;

    /**
     * Get the value of objectiveKills
     *
     * @return the value of objectiveKills
     */
    public float getObjectiveKills() {
        return objectiveKills;
    }

    /**
     * Set the value of objectiveKills
     *
     * @param objectiveKills new value of objectiveKills
     */
    public void setObjectiveKills(float objectiveKills) {
        this.objectiveKills = objectiveKills;
    }


    /**
     * Get the value of multiKillBest
     *
     * @return the value of multiKillBest
     */
    public int getMultiKillBest() {
        return multiKillBest;
    }

    /**
     * Set the value of multiKillBest
     *
     * @param multiKillBest new value of multiKillBest
     */
    public void setMultiKillBest(int multiKillBest) {
        this.multiKillBest = multiKillBest;
    }

    /**
     * Get the value of eliminationsPerLife
     *
     * @return the value of eliminationsPerLife
     */
    public float getEliminationsPerLife() {
        return eliminationsPerLife;
    }

    /**
     * Set the value of eliminationsPerLife
     *
     * @param eliminationsPerLife new value of eliminationsPerLife
     */
    public void setEliminationsPerLife(float eliminationsPerLife) {
        this.eliminationsPerLife = eliminationsPerLife;
    }

    
    /**
     * Get the value of weaponAccuracy
     *
     * @return the value of weaponAccuracy
     */
    public int getWeaponAccuracy() {
        return weaponAccuracy;
    }

    /**
     * Set the value of weaponAccuracy
     *
     * @param weaponAccuracy new value of weaponAccuracy
     */
    public void setWeaponAccuracy(int weaponAccuracy) {
        this.weaponAccuracy = weaponAccuracy;
    }

    /**
     * Get the value of winPercentage
     *
     * @return the value of winPercentage
     */
    public int getWinPercentage() {
        return winPercentage;
    }

    /**
     * Set the value of winPercentage
     *
     * @param winPercentage new value of winPercentage
     */
    public void setWinPercentage(int winPercentage) {
        this.winPercentage = winPercentage;
    }

    /**
     * Get the value of gamesWon
     *
     * @return the value of gamesWon
     */
    public int getGamesWon() {
        return gamesWon;
    }

    /**
     * Set the value of gamesWon
     *
     * @param gamesWon new value of gamesWon
     */
    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    /**
     * Get the value of timePlayedInSeconds
     *
     * @return the value of timePlayedInSeconds
     */
    public int getTimePlayedInSeconds() {
        return timePlayedInSeconds;
    }

    /**
     * Set the value of timePlayedInSeconds
     *
     * @param timePlayedInSeconds new value of timePlayedInSeconds
     */
    public void setTimePlayedInSeconds(int timePlayedInSeconds) {
        this.timePlayedInSeconds = timePlayedInSeconds;
    }

    /**
     * Get the value of timePlayed
     *
     * @return the value of timePlayed
     */
    public String getTimePlayed() {
        return timePlayed;
    }

    /**
     * Set the value of timePlayed
     *
     * @param timePlayed new value of timePlayed
     */
    public void setTimePlayed(String timePlayed) {
        this.timePlayed = timePlayed;
    }

}
