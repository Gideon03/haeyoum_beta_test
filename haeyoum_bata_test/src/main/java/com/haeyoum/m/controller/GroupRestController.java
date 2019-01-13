package com.haeyoum.m.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.haeyoum.group.model.RoomList;
import com.haeyoum.group.service.GroupMemberService;
import com.haeyoum.group.service.GroupService;
import com.haeyoum.member.model.User;

@RestController
@RequestMapping("/m")
@SessionAttributes("user")
public class GroupRestController {
	
	@Autowired
	private GroupService groupSvc;
	@Autowired
	private GroupMemberService groupMemberSvc;
	
	@RequestMapping("/groupList")
	public String groupList(@ModelAttribute("user") User user, Model model,HttpSession session,RoomList groupList) {
		user.setGroup_id(0);
		int stPage = 0;
		groupList.setId(user.getGroup_id());
		
		List<RoomList> list = groupSvc.groupList(stPage, user.getMember_id());
	
		model.addAttribute("groupList", list);
		
		String strJson = null;
		return strJson;
		
	}
	
	
	@RequestMapping("/iphone/groupList")
	public List<RoomList> groupList() {

		List<RoomList> list = new ArrayList<RoomList>();
		
		for (int i = 1 ; i <= 100 ; i++) {
			RoomList group = new RoomList();
			group.setId(i);
			group.setRoom_name("group_" + i);
			list.add(group);
		}
		
		return list;
	}
	
	
	
	
	
}















