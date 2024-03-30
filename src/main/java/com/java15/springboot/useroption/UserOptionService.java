package com.java15.springboot.useroption;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@RequiredArgsConstructor
@Service
public class UserOptionService {
    private final UserOptionRepository repository;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        Random r = new Random();

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 5; j++) {
                UserOption option = new UserOption();
                option.setUsername("user" + i);
                option.setOption("option" + j);
                option.setValue(r.nextFloat() + "");
                repository.save(option);
            }

        }
    }

    public List<UserOption> findAll() {
        return repository.findAll();
    }

    public List<UserOption> getAllForUser(String username, String[] optionQuery) {
        return repository.findAll((root, cq, cb) -> {
            List<Predicate> optionsPredicates = new ArrayList<>();

            if (optionQuery != null) {
                for (String queryItem : optionQuery) {
                    Predicate optionPredicate = cb.like(root.get("option"), "%" + queryItem + "%");
                    optionsPredicates.add(optionPredicate);
                }
            }

            if (optionsPredicates.isEmpty()) {
                return cb.equal(root.get("username"), username);
            } else {
                return cb.and(
                        cb.equal(root.get("username"), username),
                        cb.or(optionsPredicates.toArray(new Predicate[0]))
                );
            }

        });
//        return repository.findAllByUsername(username);
    }

    public void delete(String username, String option) {
//        UserOption.Key key = new UserOption.Key();
//        key.setUsername(username);
//        key.setOption(option);
//        repository.deleteById(key);

        jdbcTemplate.update(
                "DELETE FROM user_option WHERE \"username\" = :username AND \"option\" = :option",
                Map.of("username", username, "option", option)
        );
    }

    public List<UserOption> getAllForUserUsingJdbcTemplate(String username, String[] optionQuery) {
        String baseQuery = "SELECT \"username\", \"option\", \"value\" FROM user_option WHERE \"username\" = :username";

        if (optionQuery != null && optionQuery.length > 0) { // AND (option LIKE :q1 OR option LIKE :q2))
            Set<String> likeItems = new HashSet<>();
            for (String option : optionQuery) {
                String optionLikeItem = "\"option\" LIKE '%" + option + "%'";
                likeItems.add(optionLikeItem);
            }

            String joinedLikeItems = String.join(" OR ", likeItems);

            baseQuery = baseQuery + " AND (" + joinedLikeItems + ")";
        }

        return jdbcTemplate.query(
                baseQuery,
                Map.of("username", username),
                new UserOptionRowMapper()
        );
    }

    private static class UserOptionRowMapper implements RowMapper<UserOption> {
        @Override
        public UserOption mapRow(ResultSet rs, int rowNum) throws SQLException {
            String option = rs.getString("option");
            String value = rs.getString("value");
            String username = rs.getString("username");

            UserOption result = new UserOption();
            result.setOption(option);
            result.setValue(value);
            result.setUsername(username);

            return result;
        }
    }
}
