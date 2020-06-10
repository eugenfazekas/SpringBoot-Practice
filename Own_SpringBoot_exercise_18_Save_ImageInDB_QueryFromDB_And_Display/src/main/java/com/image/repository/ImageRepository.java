package com.image.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.image.model.Image;

@Repository
public class ImageRepository {

	@Autowired
	JdbcTemplate jdbc;
	
	final RowMapper<Image> mapper = new RowMapper<Image>() {

		@Override
		public Image mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			Image n = new Image();
			
			n.setId(Long.valueOf(rs.getString("id")));
			n.setName(rs.getString("name"));
			n.setData(rs.getBytes("data"));
	
			return n;
		}
	};
	
	public void save (Image image) {
		
		String sql = " INSERT INTO images (name,data) VALUES (?,?)";
		jdbc.update(sql,image.getName(),image.getData());
	}

	public Image findByName(String name) {
		
		String sql = "SELECT * FROM images where name = ?";
		return jdbc.queryForObject(sql,mapper,name);
		
	}
}
