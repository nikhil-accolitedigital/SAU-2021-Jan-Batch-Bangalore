package com.demo.Dictionary.dao.impl;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.demo.Dictionary.dao.IWordDao;
import com.demo.Dictionary.entities.Word;
import com.demo.Dictionary.queries.WordQueries;
import com.demo.Dictionary.table.constants.WordTableConstants;

@Repository
public class WordDaoImpl implements IWordDao {
	
	private static Logger logger = LoggerFactory.getLogger(WordDaoImpl.class);

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Word save(Word word) {
		final KeyHolder holder = new GeneratedKeyHolder();
		String sql = "INSERT INTO WORDS ( WORD , MEANING , PART_OF_SPEECH , EXAMPLE , CREATION_TM , LAST_MODIFIED_TM ) "
				+ " VALUES ( :WORD , :MEANING , :PART_OF_SPEECH , :EXAMPLE , :CREATION_TM , :LAST_MODIFIED_TM )";
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue("WORD", word.getWord());
		srcMap.addValue("MEANING", word.getMeaning());
		srcMap.addValue("PART_OF_SPEECH", word.getPartOfSpeech());
		srcMap.addValue("EXAMPLE", word.getExample());
		srcMap.addValue("CREATION_TM", word.getCreationTm());
		srcMap.addValue("LAST_MODIFIED_TM", word.getLastModifiedTm());

		namedParameterJdbcTemplate.update(sql, srcMap, holder, new String[] { "ID" });
		word.setId(holder.getKey().intValue());
		return word;
	}

	@Override
	public List<Word> getAll() {
		String sql = "select * from words order by CREATION_TM desc";
		return namedParameterJdbcTemplate.query(sql, (resultSet, i) -> {
			Word word = new Word();
			word.setId(resultSet.getInt("ID"));                         
			word.setWord(resultSet.getString("WORD"));
			word.setMeaning(resultSet.getString("MEANING"));
			word.setPartOfSpeech(resultSet.getString("PART_OF_SPEECH"));
			word.setExample(resultSet.getString("EXAMPLE"));
			word.setCreationTm(resultSet.getDate("CREATION_TM"));
			word.setLastModifiedTm(resultSet.getDate("LAST_MODIFIED_TM"));
			return word;
		});
	}
	
	@Override
	public int deleteById(int id) {
		logger.info(WordQueries.DELETE_QUERY);
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue(WordTableConstants.ID, id);
		return namedParameterJdbcTemplate.update(WordQueries.DELETE_QUERY, srcMap);
	}
	
	
	
	@Override
	public int update(Word word) {
		// TODO Auto-generated method stub
		String UPDATE_QUERY = WordQueries.UPDATE_QUERY_LEADING;
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		if (word.getWord() != null) {
			UPDATE_QUERY += " " + WordTableConstants.WORD + " = :" + WordTableConstants.WORD + " , ";
			srcMap.addValue(WordTableConstants.WORD, word.getWord());
		}
		if (word.getMeaning() != null) {
			UPDATE_QUERY += " " + WordTableConstants.MEANING + " = :" + WordTableConstants.MEANING + " , ";
			srcMap.addValue(WordTableConstants.MEANING, word.getMeaning());
		}
		if (word.getPartOfSpeech() != null) {
			UPDATE_QUERY += " " + WordTableConstants.POS + " = :" + WordTableConstants.POS + " , ";
			srcMap.addValue(WordTableConstants.POS, word.getPartOfSpeech());
		}
		if (word.getExample() != null) {
			UPDATE_QUERY += " " + WordTableConstants.EXAMPLE + " = :" + WordTableConstants.EXAMPLE + " , ";
			srcMap.addValue(WordTableConstants.EXAMPLE, word.getExample());
		}

		UPDATE_QUERY += " " + WordTableConstants.LAST_MODIFIED_TM + " = :" + WordTableConstants.LAST_MODIFIED_TM
				+ " , ";
		srcMap.addValue(WordTableConstants.LAST_MODIFIED_TM, new Date(0));

		UPDATE_QUERY = UPDATE_QUERY.substring(0, UPDATE_QUERY.length() - 2);
		UPDATE_QUERY += " " + WordQueries.UPDATE_QUERY_TRAILING;

		logger.info(UPDATE_QUERY);
		srcMap.addValue(WordTableConstants.ID, word.getId());

		return namedParameterJdbcTemplate.update(UPDATE_QUERY, srcMap);

	}
}
