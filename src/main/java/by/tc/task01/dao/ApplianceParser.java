package by.tc.task01.dao;

import java.util.ArrayList;
import java.util.HashMap;

public class ApplianceParser
{
    private ArrayList<String> applianceData;
    private ArrayList<HashMap<String, String>> parsedApplianceData;

    public ApplianceParser(ArrayList<String> applianceData)
    {
        this.applianceData = applianceData;
        this.parsedApplianceData = new ArrayList<HashMap<String, String>>();
    }

    public ArrayList<HashMap<String, String>> parse()
    {
        if(applianceData == null || applianceData.isEmpty()) return null;

        for(String oneApplianceInfo : applianceData)
        {
            String allApplianceParameters = (oneApplianceInfo.split(" : "))[1];
            String[] parsedApplianceParameters = allApplianceParameters.split(", ");

            HashMap<String, String> temp = new HashMap<String, String>();
            for(int i = 0; i < parsedApplianceParameters.length; i++)
            {
                String parameterName = parsedApplianceParameters[i].split("=")[0];
                String parameterValue = parsedApplianceParameters[i].split("=")[1];

                temp.put(parameterName, parameterValue);
            }

            parsedApplianceData.add(temp);
        }

        return parsedApplianceData;
    }
}
