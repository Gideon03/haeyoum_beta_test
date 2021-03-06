package com.haeyoum.room.repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haeyoum.room.model.Room;
import com.haeyoum.room.model.RoomList;

@Repository
public class RoomDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String strName = "room.model.RoomMapper";

	public int insertRoom(Room group){
		return sqlSession.insert(strName + ".insertRoom" , group);
	}
	
	public List<RoomList> roomList(HashMap<String, Object> map) throws SQLException {
		return sqlSession.selectList(strName + ".roomList", map);
	} 
	
	public int confirmKey(String roomkey) throws SQLException {
		return sqlSession.selectOne(strName + ".confirmKey" , roomkey);
	}
	
	public Room selectRoom(int room_id){
		return sqlSession.selectOne(strName + ".selectRoom", room_id);
	}
	
	public Room inviteRoom(String roomkey) throws SQLException {
		return sqlSession.selectOne(strName + ".inviteRoom", roomkey);
	}

}
