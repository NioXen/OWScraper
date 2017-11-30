/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owscraper;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ben
 */
public class OWScraper {
    
    private static final HashMap<String, String> RANK_MAP = HashMapReader.ReadFile("resources/rankMapping.txt", ":");

    private static Document loadFile() { 
        File input = new File("C:\\Users\\Ben\\Desktop\\owstats.html");
        Document doc = null;
        try {
        doc = Jsoup.parse(input, "UTF-8", "https://playoverwatch.com/");
        }catch(IOException e){
            System.err.println("IOException: " + e.getMessage());
        }
        if (doc != null) {
            return doc;
        } else {
            return null;
        }
    }
    
    //make fed from player path url
    private static PlayerStats playerStats(Document doc) {
        PlayerStats ps;
        ps = parsePlayerInfo(doc.select("div.masthead").first());
        ps.setCompetitiveStats(parseDetailedStats(doc.selectFirst("div#competitive")));
        ps.setQuickPlayStats(parseDetailedStats(doc.selectFirst("div#quickplay")));
        
        return ps;
    }
    
    private static StatsCollection parseDetailedStats(Element playMode){
        StatsCollection stats = new StatsCollection();
        stats.setHerosStats(parseHeroStats(playMode.selectFirst("section.hero-comparison-section")));
    }
    
    private static PlayerStats parsePlayerInfo(Element hdr){
        PlayerStats ps = new PlayerStats();
        
        ps.setIcon(hdr.selectFirst("img.player-portrait").attr("src"));
        ps.setName(hdr.selectFirst("h1.header-masthead").text());
        ps.setLevel(Integer.parseInt(hdr.selectFirst("div.player-level div.u-vertical-center").text()));
        
        String lvlIcon = hdr.selectFirst("div.player-level").attr("style");
        ps.setLevelIcon(lvlIcon.substring(lvlIcon.indexOf("("), lvlIcon.indexOf(")")));
        
        ps.setPrestige(getPrestigeByIcon(ps.getLevelIcon()));
        
        String prestigeIcon = hdr.selectFirst("div.player-rank").attr("style");
        ps.setPrestigeIcon(prestigeIcon.substring(prestigeIcon.indexOf("("), prestigeIcon.indexOf(")")));
        
        ps.setRating(Integer.parseInt(hdr.selectFirst("div.competitive-rank div.u-align-center").text()));
        ps.setRatingIcon(hdr.selectFirst("div.competitive-rank img").attr("src"));
        ps.setGamesWon(Integer.parseInt(hdr.selectFirst("div.masthead p.masthead-detail.h4 span").text().replace(" games won", "")));
        
        return ps;
    }
        
    /**
     *
     * @param args
     */
    private static HashMap<String, HeroStats> parseHeroStats(Element heroElement) {
        HashMap<String, HeroStats> herosStats = new HashMap<>();
        Elements progressCategories = heroElement.select("div.progress-category");
        progressCategories.forEach((Element category) -> {
            String categoryID;
            categoryID = category.attr("data-category-id");
            categoryID = categoryID.replace("overwatch.guid.0x0860000000000", "");
            Elements stats = category.select("div.progress-2");
            for(Element stat : stats){
                String heroName = stat.select("div.title").text();
                String statValue = stat.select("div.description").text().trim();
                
                if (!herosStats.containsKey(heroName)){
                    herosStats.put(heroName, new HeroStats());
                }
                
                switch (categoryID) {
                    //Time played in seconds
                    case "021":
                        String[] timeArray = statValue.split(" ");
                        if (timeArray.length==2){
                            try{
                                int digit = Integer.parseInt(timeArray[0]);
                                if (timeArray[1].startsWith("second")){
                                    herosStats.get(heroName).setTimePlayedInSeconds(digit);
                                } else if (timeArray[1].startsWith("minute")){
                                    herosStats.get(heroName).setTimePlayedInSeconds(digit * 60);
                                } else if (timeArray[1].startsWith("hour")){
                                    herosStats.get(heroName).setTimePlayedInSeconds(digit * 60 * 60);
                                }
                            } catch(NumberFormatException e){
                                System.err.println("NumberFormatException: " + e.getMessage());
                                herosStats.get(heroName).setTimePlayedInSeconds(0);
                            }
                        }
                        herosStats.get(heroName).setTimePlayed(statValue);
                        break;
                    //Games Won
                    case "039":
                        try {
                            herosStats.get(heroName).setGamesWon(Integer.parseInt(statValue));
                        } catch (NumberFormatException e){
                            System.err.println("NumberFormatException: " + e.getMessage());
                            herosStats.get(heroName).setGamesWon(0);
                        }
                        break;
                    //Win percentage
                    case "3D1":
                        try {
                            herosStats.get(heroName).setWinPercentage(Integer.parseInt(statValue.replace("%", "")));
                        } catch (NumberFormatException e){
                            System.err.println("NumberFormatException: " + e.getMessage());
                            herosStats.get(heroName).setWinPercentage(0);
                        }
                        break;
                    //Weapon accuracy
                    case "02F":
                        try {
                            herosStats.get(heroName).setWeaponAccuracy(Integer.parseInt(statValue.replace("%", "")));
                        } catch (NumberFormatException e){
                            System.err.println("NumberFormatException: " + e.getMessage());
                            herosStats.get(heroName).setWeaponAccuracy(0);
                        }
                        break;
                    //Eliminations per life
                    case "3D2":
                        try {
                            herosStats.get(heroName).setEliminationsPerLife(new BigDecimal(statValue));
                        } catch (NumberFormatException e){
                            System.err.println("NumberFormatException: " + e.getMessage());
                            herosStats.get(heroName).setEliminationsPerLife(new BigDecimal("0"));
                        }
                        break;
                    //Multi kill best
                    case "346":
                        try {
                            herosStats.get(heroName).setMultiKillBest(Integer.parseInt(statValue));
                        } catch (NumberFormatException e){
                            System.err.println("NumberFormatException: " + e.getMessage());
                            herosStats.get(heroName).setMultiKillBest(0);
                        }
                        break;
                    //Objective kills
                    case "39C":
                        try {
                            herosStats.get(heroName).setObjectiveKills(new BigDecimal(statValue));
                        } catch (NumberFormatException e){
                            System.err.println("NumberFormatException: " + e.getMessage());
                            herosStats.get(heroName).setObjectiveKills(new BigDecimal("0"));
                        }
                        break;
                        
                }
            }
        });
        
        
        return herosStats;
    }
    
    private static HashMap<String, CareerStats> parseCareerStats(Element careerElement){
        HashMap<String, CareerStats> careerStats = new HashMap<>();
        HashMap<String, String> heroMapping = new HashMap<>();
        
        //Creates the hero mappings from the dropdown selector
        careerElement.select("select option").forEach((Element heroOption) -> {
        String heroValue = heroOption.attr("value");
            heroMapping.put(heroValue, heroOption.text());
        });
        
        careerElement.select("")
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
//        Document doc = loadFile();
//        Element gameMode = doc.getElementById("competitive");
//        Element heroStats = gameMode.selectFirst("section.hero-comparison-section");
//        HashMap<String, HeroStats>hshm = parseHeroStats(heroStats);
//        for(Map.Entry<String, HeroStats> entry: hshm.entrySet()){
//            String key = entry.getKey();
//            HeroStats val = entry.getValue();
//            System.out.println(key + "," + val.toString());
//        }
    }
    
    private static int getPrestigeByIcon(String levelIcon){
        Pattern p = Pattern.compile("(.{3})(?=_Border.png)");
        Matcher m = p.matcher(levelIcon);
        if(m.find() && RANK_MAP != null){
            String s = m.group();
            return Integer.parseInt(RANK_MAP.get(s));
        } else {
            System.out.println("Could not get prestige by icon. Default 0 set");
            return 0;
        }
    }

}
