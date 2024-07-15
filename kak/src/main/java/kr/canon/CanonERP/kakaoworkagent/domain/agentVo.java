package kr.canon.CanonERP.kakaoworkagent.domain;

import java.util.List;

public class agentVo {

	private int _code;
	private String _message;
	private List capabilities;	

	public agentVo(int i, String st, List agent) {
		this._code = i;
		this._message = st;
		this.capabilities = agent;
	}

	public agentVo() {
		this._code = _code;
		this._message = _message;
		this.capabilities = capabilities;
	}

	public agentVo(int i, String st) {
		this._code = i;
		this._message = st;
	}

	public int get_code() {
		return _code = _code;
	}

	public void set_code(int _code) {
		this._code = _code;
	}

	public String get_message() {
		return _message = _message;
	}

	public void setReason(String _message) {
		this._message = _message;
	}

	public List getcapabilities() {
				
		return capabilities =  capabilities;
	}

	public void setcapabilities(List capabilities) {
		this.capabilities = capabilities;
	}

	
}
