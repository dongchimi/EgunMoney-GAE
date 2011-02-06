package com.appspot.egun.money.process.logic;

import java.util.List;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.domain.Target;
import com.appspot.egun.money.process.TargetProcess;
import com.google.appengine.api.datastore.Key;

@Component
public class TargetProcessLogic implements TargetProcess {

	@Override
	public Key registerTarget(Target target) {
		return null;
	}

	@Override
	public List<Target> findTargetByUserEmail(String userEmail) {
		return null;
	}

	@Override
	public Target getTargetByKey(Key key) {
		return null;
	}

}
