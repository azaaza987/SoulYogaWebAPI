package com.web.soulyogaadmin.member.vo;

import com.web.soulyogaadmin.entity.Member;
import com.web.soulyogaadmin.entity.Memberaccount;

public class MemberVO extends Member {
	
	private String saleConsltantname = null;
	
	private Member member = null;
	
	private Memberaccount memberaccount = null;

	public String getSaleConsltantname() {
		return saleConsltantname;
	}

	public void setSaleConsltantname(String saleConsltantname) {
		this.saleConsltantname = saleConsltantname;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Memberaccount getMemberaccount() {
		return memberaccount;
	}

	public void setMemberaccount(Memberaccount memberaccount) {
		this.memberaccount = memberaccount;
	}
	
	
	
}
