package kr.canon.CanonERP.kakaoworkagent.domain;

import java.util.List;

public class Profile {

	

	private Object editability;

	public Profile(kr.canon.CanonERP.kakaoworkagent.domain.editability ed) {
		this.editability = ed;
	}

	public Object getEditability() {
		return editability;
	}

	public void setEditability(Object editability) {
		this.editability = editability;
	}
	
}
