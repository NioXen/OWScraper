/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owscraper;

/**
 * PlayerStats holds information for a specific player
 * @author Ben
 */
public class PlayerStats {

    private String icon;
    private String name;
    private int level;
    private String levelIcon;
    private int prestige;
    private String prestigeIcon;
    private int rating;
    private String ratingIcon;
    private int gamesWon;
    private StatsCollection quickPlayStats;
    private StatsCollection competitiveStats;

    /**
     * Get the value of competitiveStats
     *
     * @return the value of competitiveStats
     */
    public StatsCollection getCompetitiveStats() {
        return competitiveStats;
    }

    /**
     * Set the value of competitiveStats
     *
     * @param competitiveStats new value of competitiveStats
     */
    public void setCompetitiveStats(StatsCollection competitiveStats) {
        this.competitiveStats = competitiveStats;
    }


    /**
     * Get the value of quickPlayStats
     *
     * @return the value of quickPlayStats
     */
    public StatsCollection getQuickPlayStats() {
        return quickPlayStats;
    }

    /**
     * Set the value of quickPlayStats
     *
     * @param quickPlayStats new value of quickPlayStats
     */
    public void setQuickPlayStats(StatsCollection quickPlayStats) {
        this.quickPlayStats = quickPlayStats;
    }


    /**
     * Get the value of icon
     *
     * @return the value of icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Set the value of icon
     *
     * @param icon new value of icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of level
     *
     * @return the value of level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set the value of level
     *
     * @param level new value of level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Get the value of levelIcon
     *
     * @return the value of levelIcon
     */
    public String getLevelIcon() {
        return levelIcon;
    }

    /**
     * Set the value of levelIcon
     *
     * @param levelIcon new value of levelIcon
     */
    public void setLevelIcon(String levelIcon) {
        this.levelIcon = levelIcon;
    }

    /**
     * Get the value of prestige
     *
     * @return the value of prestige
     */
    public int getPrestige() {
        return prestige;
    }

    /**
     * Set the value of prestige
     *
     * @param prestige new value of prestige
     */
    public void setPrestige(int prestige) {
        this.prestige = prestige;
    }
    
    /**
     * Get the value of prestigeIcon
     *
     * @return the value of prestigeIcon
     */
    public String getPrestigeIcon() {
        return prestigeIcon;
    }

    /**
     * Set the value of prestigeIcon
     *
     * @param prestigeIcon new value of prestigeIcon
     */
    public void setPrestigeIcon(String prestigeIcon) {
        this.prestigeIcon = prestigeIcon;
    }
    
    /**
     * Get the value of rating
     *
     * @return the value of rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Set the value of rating
     *
     * @param rating new value of rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    /**
     * Get the value of ratingIcon
     *
     * @return the value of ratingIcon
     */
    public String getRatingIcon() {
        return ratingIcon;
    }

    /**
     * Set the value of ratingIcon
     *
     * @param ratingIcon new value of ratingIcon
     */
    public void setRatingIcon(String ratingIcon) {
        this.ratingIcon = ratingIcon;
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


}
