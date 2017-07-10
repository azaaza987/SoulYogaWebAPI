package com.web.webservice.member.action;


import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.soulyogaadmin.entity.Employee;
import com.web.soulyogaadmin.entity.Member;
import com.web.soulyogaadmin.member.service.IMemberService;
import com.web.soulyogaadmin.member.vo.MemberVO;

@RestController
@RequestMapping(value = "/member")
public class MemberController {
	

	@Autowired
	private IMemberService iMemberService;
	
	// http://localhost:8080/SoulYogaWebAPI/restful/member/7
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public MemberVO findMemberInfoById(@PathVariable int id) {
		MemberVO memberVO = new MemberVO();
		Member member = null;
		
		try {
			List<Employee> emplist = iMemberService.consultantList();
			member = iMemberService.showOneMember(id);
			
			PropertyUtils.copyProperties(memberVO, member);
			
			int saleConsultantId = member.getSalesConsultantId();
			for(Employee tempEmp: emplist){
				if(saleConsultantId == tempEmp.getId())
				{
					memberVO.setSaleConsltantname(tempEmp.getFristName() + " " + tempEmp.getLastName());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  memberVO;
	}

	//http://localhost:8080/SoulYogaWebAPI/restful/member/
	/**
	{	
		"member":{"name":"hello8", "identityId":"9879867575", "mobileNo":"13866138000", "salesConsultantId":"1", "address":"wuhan", "gender":"1", "birthday":"1988-09-09","avatarUrl":"", "createdTime":"2017-01-01", "modifiedTime":"2009-01-01", "state":"0" } ,
		"memberaccount":{"nickName":"uuuu8787", "password":"password_1", "createdTime":"2017-01-01","state":"0"}
	}
	*/
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public boolean createMember(@RequestBody MemberVO vo) {
		boolean insertSucess = true;
		byte[] bt = {};
		try {
			if(vo.getMemberaccount().getFingerprint() == null){
				vo.getMemberaccount().setFingerprint(bt);
			}
			iMemberService.addMemberInfo(vo.getMember(), vo.getMemberaccount());
		} catch (Exception e) {
			insertSucess = false;
		}
		return insertSucess;
	}

	// http://localhost:8080/SoulYogaWebAPI/restful/member/8
	/**
	{	
		"member":{"id":8,"name":"hello8888", "identityId":"88888888", "mobileNo":"13866138000", "salesConsultantId":"1", "address":"wuhan", "gender":"1", "birthday":"1988-09-09","avatarUrl":"", "createdTime":"2017-01-01", "modifiedTime":"2009-01-01", "state":"0" } 
	}
	*/
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public boolean updateMember(@RequestBody MemberVO vo, @PathVariable int id) {
		
		boolean updateSuccess = true;
		Member existingmember = null;
		try {
			existingmember = iMemberService.showOneMember(id);
			
			byte[] bt = {};
			try {
				vo.getMember().setModifiedTime(new Date());
				vo.getMember().setId(id);
				
				if(existingmember != null){
					PropertyUtils.copyProperties(existingmember, vo.getMember());
				}
				else{
					return false;
				}
				iMemberService.updateMember(existingmember);
			} catch (Exception e) {
				updateSuccess = false;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return updateSuccess;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteMember(@PathVariable Long id) {
		boolean deleteflag = false;
		// TODO
		return deleteflag;
	}
}

