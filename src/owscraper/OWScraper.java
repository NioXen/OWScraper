/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owscraper;

import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.IOException;
import java.io.File;
import java.util.HashMap;


/**
 *
 * @author Ben
 */
public class OWScraper {

    private static Document loadFile() { 
        File input = new File("C:\\Users\\Ben\\Desktop\\owstats.html");
        Document doc = null;
        try {
        doc = Jsoup.parse(input, "UTF-8", "https://playoverwatch.com/");
        }catch(IOException e){
            e.printStackTrace();
        }
        if (doc != null) {
            return doc;
        } else {
            return null;
        }
    }
    
    private static HashMap<String, HeroStats> parseHeroStats(Element heroElement) {
        HashMap<String, HeroStats> herosStats = new HashMap<>();
        Elements progressCategories = heroElement.select("div.progress-category");
        progressCategories.forEach((category) -> {
            String categoryID = category.attr("data-category-id");
            categoryID = categoryID.replace("overwatch.guid.0x0860000000000", "");
            Elements stats = category.select("div.progress-2");
            for(Element stat : stats){
                String heroName = stat.select("div.title").text();
                String statValue = stat.select("div.description").text();
                
                if(!herosStats.containsKey(heroName)){
                    herosStats.put(heroName, new HeroStats());
                }
                
                switch (categoryID) {
                    case "021":
                        
                }
            }
        });
        
        
        return herosStats;
    }

    public static void main(String[] args) {
        Document doc = loadFile();
        Element gameMode = doc.getElementById("competitive");
        Element heroStats = gameMode.selectFirst("section.hero-comparison-section");
        parseHeroStats();
    }
    
}
