/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owscraper;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/**
 *
 * @author Ben
 */
public class CareerStats {
    
    private String heroname;
    private HashMap<String, String> assists = new HashMap<>();
    private HashMap<String, String> misc = new HashMap<>();
    private HashMap<String, String> game = new HashMap<>();
    private HashMap<String, String> combat = new HashMap<>();
    private HashMap<String, String> average = new HashMap<>();
    private HashMap<String, String> deaths = new HashMap<>();
    private HashMap<String, String> best = new HashMap<>();
    private HashMap<String, String> awards = new HashMap<>();
    private HashMap<String, String> specific = new HashMap<>();
    
    public String getHeroname() {
        return heroname;
    }
    public void setHeroname(String heroname) {
        this.heroname = heroname;
    }
    public HashMap<String, String> getAssists() {
        return assists;
    }
    public void setAssists(HashMap<String, String> assists) {
        this.assists = assists;
    }
    public HashMap<String, String> getMisc() {
        return misc;
    }   
    public void setMisc(HashMap<String, String> misc) {
        this.misc = misc;
    }
    public HashMap<String, String> getGame() {
        return game;
    }   
    public void setGame(HashMap<String, String> game) {
        this.game = game;
    }
    public HashMap<String, String> getCombat() {
        return combat;
    }   
    public void setCombat(HashMap<String, String> combat) {
        this.combat = combat;
    }
    public HashMap<String, String> getAverage() {
        return average;
    }   
    public void setAverage(HashMap<String, String> average) {
        this.average = average;
    }
    public HashMap<String, String> getDeaths() {
        return deaths;
    }   
    public void setDeaths(HashMap<String, String> deaths) {
        this.deaths = deaths;
    }
    public HashMap<String, String> getBest() {
        return best;
    }   
    public void setBest(HashMap<String, String> best) {
        this.best = best;
    }
    public HashMap<String, String> getAwards() {
        return awards;
    }   
    public void setAwards(HashMap<String, String> awards) {
        this.awards = awards;
    }
    public HashMap<String, String> getSpecific() {
        return specific;
    }   
    public void setSpecific(HashMap<String, String> specific) {
        this.specific = specific;
    }

    @Override
    public String toString() {
        return "heroStats{" + "heroname=" + heroname + ", assists=" + assists + ", misc=" + misc + ", game=" + game + ", combat=" + combat + ", average=" + average + ", deaths=" + deaths + ", best=" + best + ", awards=" + awards + ", specific=" + specific + '}';
    }
    
}
