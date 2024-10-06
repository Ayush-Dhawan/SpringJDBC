package org.springjdbc.springjdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springjdbc.springjdbc.models.Alien;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AlienRepository {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien) {
        String sqlQuery = "INSERT INTO alien (id, name, tech) VALUES (?, ?, ?)";
        template.update(sqlQuery, alien.getId(), alien.getName(), alien.getTech());
        System.out.println("saved");
    }

    public List<Alien> getAllAliens() {
        String sqlQuery = "SELECT * FROM alien";
        RowMapper<Alien> mapper = new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien a = new Alien();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setTech(rs.getString("tech"));
                return a;
            }
        };

        return template.query(sqlQuery, mapper);
    }
}
