package com.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.domain.Member;

@Repository
@Component
public class Exam05Repository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public final static RowMapper<Member> MEMBER_ROW_MAPPER
	=(rs,i)->{
		Member member=new Member();
		member.setName(rs.getString("name"));
		return member;
	};
	
	public List<Member> findByName(String name){
		String sql="SELECT name FROM members WHERE name LIKE '%:name%'";
		SqlParameterSource param=new MapSqlParameterSource().addValue("name", name);
		List<Member> memberList=(List<Member>) template.queryForObject(sql, param, MEMBER_ROW_MAPPER);
		return memberList;
	}
}
