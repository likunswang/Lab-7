
/**
 * Write a description of class Canada here.
 *
 * @author Luke
 * @version 13.Oct.2017
 */

import java.util.ArrayList;

public class Canada
{
    // instance variables - replace the example below with your own
    private ProvinceTerritory[] provinces;

    public static final int BC = 0;
    public static final int AB = 1;
    public static final int MB = 2;
    public static final int NB = 3;
    public static final int NL = 4;
    public static final int NT = 5;
    public static final int NS = 6;
    public static final int NU = 7;
    public static final int ON = 8;
    public static final int PE = 9;
    public static final int QC = 10;
    public static final int SK = 11;
    public static final int YT = 12;
    public static final int ALL_PROVINCES_IN_CANADA = 13;

    public static final int NO_SUCH_PROVINCE = -1;

    /**
     * Constructor for objects of class Canada
     */
    public Canada()
    {

        provinces = new ProvinceTerritory[ALL_PROVINCES_IN_CANADA];

        provinces[BC] = new ProvinceTerritory("British Columbia", 4400057);
        provinces[AB] = new ProvinceTerritory("Alberta", 3645257);
        provinces[MB] = new ProvinceTerritory("Manitoba", 1208268);
        provinces[NB] = new ProvinceTerritory("New Brunswick", 751171);
        provinces[NL] = new ProvinceTerritory("Newfoundland and Labrador", 514536);
        provinces[NT] = new ProvinceTerritory("Northwest Territories", 41462);
        provinces[NS] = new ProvinceTerritory("Nova Scotia", 921727);
        provinces[NU] = new ProvinceTerritory("Nunavut", 31906);
        provinces[ON] = new ProvinceTerritory("Ontario", 12851821);
        provinces[PE] = new ProvinceTerritory("Prince Edward Island", 140204);
        provinces[QC] = new ProvinceTerritory("Quebec", 7903001);
        provinces[SK] = new ProvinceTerritory("Saskatchewan", 1033381);
        provinces[YT] = new ProvinceTerritory("Yukon", 33897);    
    }

    /**
     * @return total population in Canada
     */
    public int getTotalPopulation()
    {
        int totalPopulation = 0;
        int index = 0;
        while(index < provinces.length)
        {
            totalPopulation += provinces[index].getPopulation();
            index++;
        }
        return totalPopulation;
    }

    /**
     * @return the name of the province/territory that has the lowest population
     */
    public String getLowestPopulation()
    {            
        int index = 0;
        int lowestPopulation = provinces[index].getPopulation();
        int lowestPopulationIndex = 0;
        String lowestProvince;
        while(index < provinces.length)
        {
            if(lowestPopulation > provinces[index].getPopulation())
            {
                lowestPopulation = provinces[index].getPopulation();
                lowestPopulationIndex = index;
                index++;
            }
            else
            {
                index++;
            }
        }
        return provinces[lowestPopulationIndex].getName();
    }

    /**
     * @param  province name in Canada e.g. British Columbia
     * @param Alberta
     * @param Manitoba
     * @param New Brunswick
     * @param Newfoundland and Labrador
     * @param Northwest Territories
     * @param Nova Scotia
     * @param Ontario
     * @param Prince Edward Island
     * @param Quebec
     * @param Saskatchewan
     * @param Yukon
     * @return the population of the province
     */
    public int getPopulationBadVersion(String province)
    {
        switch(province)
        {
            case "Britsh Columbia":
            return provinces[BC].getPopulation();

            case "Alberta":
            return provinces[AB].getPopulation();

            case "Manitoba":
            return provinces[MB].getPopulation();

            case "New Brunswick":
            return provinces[NB].getPopulation();

            case "Newfoundland and Labrador":
            return provinces[NL].getPopulation();

            case "Northwest Territories":
            return provinces[NT].getPopulation();

            case "Nova Scotia":
            return provinces[NS].getPopulation();

            case "Munavut":
            return provinces[NU].getPopulation();

            case "Ontario":
            return provinces[ON].getPopulation();

            case "Prince Edward Island":
            return provinces[PE].getPopulation();

            case "Quebec":
            return provinces[QC].getPopulation();

            case "Saskatchewan":
            return provinces[SK].getPopulation();

            case "Yukon":
            return provinces[YT].getPopulation();

            default:
            return NO_SUCH_PROVINCE;
        }
    }

    /**
     * @param  province name in Canada e.g. British Columbia
     * @param Alberta
     * @param Manitoba
     * @param New Brunswick
     * @param Newfoundland and Labrador
     * @param Northwest Territories
     * @param Nova Scotia
     * @param Ontario
     * @param Prince Edward Island
     * @param Quebec
     * @param Saskatchewan
     * @param Yukon
     * 
     * @return the population of the province, if the return value is -1, it means there's no such province.
     */
    public int getPopulation(String province)
    {
        int index = 0;
        int indexProvince = 0;

        while(index < provinces.length)
        {
            if(province.equals(provinces[index].getName()))
            {
                indexProvince = index;
                return provinces[indexProvince].getPopulation();
            }
            else
            {
                index++;
            }

        }
        return NO_SUCH_PROVINCE;

    }
/**
 * @param name of the province in Canada
 * @return true the name entered matches with the province name in canada, else, false
 */
    public boolean isProvinceInCanada(String name)
    {
        int index = 0;
        int firstLetter = 1;
        name = name.substring(0,firstLetter).toUpperCase() + name.substring(firstLetter).toLowerCase();

        while(index < provinces.length)
        {
            if(name.equals(provinces[index].getName()))
            {
                return true;
            }
            else
            {
                index++;
            }
        }
        return false;
    }
    /**
     * @param a string
     * @return returns an array of the names of all provinces/territories whose name contains the string entered
     */
    public String[] getProvincesWhoseNameContains(String substring)
    {
        String[] matchingProvinces;
        int i = 0;
        int j = 0; 
        int k = 0;
        int firstLetter = 1;
        
        int numberOfMatchingProvinces = 0;
        
        substring = substring.toLowerCase();
        
        while(i < provinces.length)
        {
            if(provinces[i].getName().toLowerCase().contains(substring))
            {
                numberOfMatchingProvinces++;
                i++;
            }
            else
            {
                i++;
            }
        }
        matchingProvinces = new String[numberOfMatchingProvinces];
        
        while(j < provinces.length)
        {
            if(provinces[j].getName().toLowerCase().contains(substring))
            {
                matchingProvinces[k] = provinces[j].getName();
                j++;
                k++;
            }
            else
            {
                j++;
            }
        }
        
        return matchingProvinces;
        
    }
    /**
     * @param a string
     * @return returns an array of the names of all provinces/territories whose name contains the string entered
     */
    public ProvinceTerritory[] getMoreProvincesWhoseNameContains(String substring)
    {
        ProvinceTerritory[] matchingProvinces;
        substring = substring.toLowerCase();
        int i = 0;
        int j = 0;
        int k = 0;
        int numberOfMatchingProvinces = 0;
        
        while(i < provinces.length)
        {
            if(provinces[i].getName().toLowerCase().contains(substring))
            {
                numberOfMatchingProvinces++;
                i++;
            }
            else
            {
                i++;
            }
        }
        matchingProvinces = new ProvinceTerritory[numberOfMatchingProvinces];
        
        while(j < provinces.length)
        {
            if(provinces[j].getName().toLowerCase().contains(substring))
            {
                matchingProvinces[k] = new ProvinceTerritory(provinces[j].getName(), provinces[j].getPopulation());
                j++;
                k++;
            }
            else
            {
                j++;
            }
        }
        return matchingProvinces;

    }
    /**
     * @param a charater
     * @return returns an array of the names of all provinces/territories whose name starts with the letter(charater) entered
     */
    public String[] getProvincesWhoseNameStartsWith(char letter)
    {
        String[] matchingProvinces;
        String substring = String.valueOf(letter);
        
        int i = 0;
        int j = 0; 
        int k = 0;
        int firstLetter = 1;
        
        int numberOfMatchingProvinces = 0;
        
        while(i < provinces.length)
        {
            if(provinces[i].getName().toLowerCase().startsWith(substring))
            {
                numberOfMatchingProvinces++;
                i++;
            }
            else
            {
                i++;
            }
        }
        matchingProvinces = new String[numberOfMatchingProvinces];
        
        while(j < provinces.length)
        {
            if(provinces[j].getName().toLowerCase().startsWith(substring))
            {
                matchingProvinces[k] = provinces[j].getName();
                j++;
                k++;
            }
            else
            {
                j++;
            }
        }
        
        return matchingProvinces;
        
    }
}
    
    

        
        
        
        
                
            
            
        
    
    

        
            
    
    /**
     * example
     *
    public String[] getProvincesWithPopulationBetween(int min, int max){

    int i = 0;

    int j = 0; // the new array index

    int numOfProvWithPop = 0;

    String[] matchingProvinces;

    while(i < provinces.length){
    if((provinces[i].getPopulation() >= min) &&
    (provinces[i].getPopulation() <= max)){
    numOfProvWithPop++;
    }
    i++;
    }

    if(numOfProvWithPop > 0){

    matchingProvinces = new ProvinceTerritory[numOfProvWithPop];

    }else{

    // no matches

    return null;

    }

    i = 0;  // start looking from the beginning again
    while(i < provinces.length){
    if((provinces[i].getPopulation()>= min) &&
    provinces[i].getPopulation()<= max){
    matchingProvinces[j] = provinces[i];
    j++;
    }
    i++;
    }
    return matchingProvinces;
    }
     */


