package com.appspot.egunmoney.service.query;

import com.appspot.egunmoney.domain.EgunUser;

public class EgunUserQueryBuilder {
	
	public static String getUserByEmailQueryStr() {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT FROM ")
				.append(EgunUser.class.getSimpleName())
				.append(" e ")
				.append(" WHERE e.userEmail == \"email\"");
		return builder.toString();
	}
}
