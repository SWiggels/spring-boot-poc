package com.tasc.golden.poc.repository.impl;

import com.tasc.golden.poc.entity.Client;
import com.tasc.golden.poc.repository.IClientRepoCustom;

public class IClientRepoImpl implements IClientRepoCustom {
	
	String customMethodToShowPotentialMigrationStrategy(Client client) {
		return "POC";
	}

}
