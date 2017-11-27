/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owscraper;

/**
 *
 * @author Ben
 */
public class testClass {
    String str = "background-image:url(https://d1u1mce87gyfbn.cloudfront.net/game/playerlevelrewards/0x025000000000092B_Rank.png)";
    int startIndex = str.indexOf("(");
    int endIndex = str.indexOf(")");
    String output;

    public testClass() {
        this.output = str.substring(startIndex + 1, endIndex);
    }
}
