package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.ApplianceParser;
import by.tc.task01.dao.ApplianceSearcher;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.factory.ApplianceFactory;

import java.util.ArrayList;
import java.util.HashMap;

public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
	public Appliance find(Criteria criteria)
	{
		Appliance result = null;

		ApplianceTxtReader applianceReader = new ApplianceTxtReader("src\\main\\resources\\appliances_db.txt");
		ArrayList<String> applianceData = applianceReader.takeByTitle(criteria.getGroupSearchName());

		if(applianceData.isEmpty() || applianceData == null) return null;

		ApplianceParser applianceParser = new ApplianceParser(applianceData);
		ArrayList<HashMap<String, String>> parsedApplianceData = applianceParser.parse();

		ApplianceSearcher applianceSearcher = new ApplianceSearcher(parsedApplianceData);
		ArrayList<String> parametersToCreate = applianceSearcher.find(criteria.getCriteria());

		if(!parametersToCreate.isEmpty())
		{
			ApplianceFactory applianceFactory = new ApplianceFactory();
			result = applianceFactory.create(criteria.getGroupSearchName(), parametersToCreate);
		}

		return result;
	}
}