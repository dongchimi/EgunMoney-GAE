package com.appspot.egun.money.service.logic;

import java.util.List;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.domain.Target;
import com.appspot.egun.money.service.TargetService;
import com.google.appengine.api.datastore.Key;

@Component
public class TargetServiceLogic implements TargetService {

	@Override
	public Key registerTarget(Target target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Target> findTargetByUserEmail(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Target getTargetByKey(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

}
