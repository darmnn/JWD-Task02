package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceReader;

import java.io.*;
import java.util.ArrayList;

public class ApplianceTxtReader implements ApplianceReader {
    private File fileToRead;

    public ApplianceTxtReader(String path)
    {
        fileToRead = new File(path);
    }

    public ArrayList<String> takeByTitle(String title)
    {
        ArrayList<String> applianceData = new ArrayList<String>();

        try
        {
            FileReader fileReader = new FileReader(fileToRead);
            BufferedReader reader = new BufferedReader(fileReader);

            String applianceFullInfo = reader.readLine();
            while(applianceFullInfo != null)
            {
                if(applianceFullInfo.contains(title))
                    applianceData.add(applianceFullInfo);

                applianceFullInfo = reader.readLine();
            }
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            return null;
        }

        return applianceData;
    }
}
