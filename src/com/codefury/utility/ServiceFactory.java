package com.codefury.utility;

import com.codefury.service.Service;
import com.codefury.service.ServiceInterface;

public class ServiceFactory {

	public static ServiceInterface createServiceObject() {
		return new Service();
	}

}