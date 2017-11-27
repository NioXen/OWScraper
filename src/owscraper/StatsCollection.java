/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owscraper;

import java.util.HashMap; 

/**
 * StatsCollection holds a a collection of stats for a particular player
 * @author Ben
 */
public class StatsCollection {
    
    private HashMap<String, HeroStats> herosStats;
    private HashMap<String, CareerStats> careerStats;

    /**
     * Get the value of careerStats
     *
     * @return the value of careerStats
     */
    public HashMap<String, CareerStats> getCareerStats() {
        return careerStats;
    }

    /**
     * Set the value of careerStats
     *
     * @param careerStats new value of careerStats
     */
    public void setCareerStats(HashMap<String, CareerStats> careerStats) {
        this.careerStats = careerStats;
    }


    public HashMap<String, HeroStats> getHerosStats() {
        return herosStats;
    }

    public void setHerosStats(HashMap<String, HeroStats> herosStats) {
        this.herosStats = herosStats;
    }
    
}
