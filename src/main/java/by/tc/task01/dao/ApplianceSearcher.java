package by.tc.task01.dao;

import java.util.ArrayList;
import java.util.HashMap;

public class ApplianceSearcher
{
    ArrayList<HashMap<String, String>> allApplianceData;

   public ApplianceSearcher(ArrayList<HashMap<String, String>> allApplianceData)
    {
        this.allApplianceData = allApplianceData;
    }

    public ArrayList<String> find(HashMap<String, Object> criteria)
    {
        ArrayList<String> result = new ArrayList<String>();

        for(HashMap<String, String> oneApplianceData : allApplianceData)
        {
            boolean found = true;

            for(HashMap.Entry<String, Object> criteriaEntry: criteria.entrySet())
            {
                if(!(oneApplianceData.containsKey(criteriaEntry.getKey()) && oneApplianceData.get(criteriaEntry.getKey()).equals(criteriaEntry.getValue())))
                    found = false;
            }

            if(found)
            {
                for(HashMap.Entry<String, String> oneApplianceEntry : oneApplianceData.entrySet())
                {
                    result.add(oneApplianceEntry.getValue());
                }
            }
        }

        return result;
    }
}
