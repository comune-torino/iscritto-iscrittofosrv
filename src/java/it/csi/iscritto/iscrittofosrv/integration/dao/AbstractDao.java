package it.csi.iscritto.iscrittofosrv.integration.dao;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.iscritto.iscrittofosrv.exception.DaoException;
import it.csi.iscritto.iscrittofosrv.util.sql.Query;
import it.csi.iscritto.iscrittofosrv.util.sql.SqlHolder;
import it.csi.iscritto.iscrittofosrv.util.sql.SqlHolderFactory;

public abstract class AbstractDao {

	@Autowired
	protected NamedParameterJdbcTemplate namedJdbcTemplate;

	protected static final SqlHolder buildSqlHolder(String... sqlRows) {
		return SqlHolderFactory.createSqlHolder(sqlRows);
	}

	protected static final <T> BeanPropertyRowMapper<T> buildRowMapper(Class<T> mappedClass) {
		return new BeanPropertyRowMapper<>(mappedClass);
	}

	//////////////////////////////////////////////////////////////////////

	protected final <T> List<T> query(String query, final Class<T> mappedClass)
			throws DaoException {

		Validate.notBlank(query);
		Validate.notNull(mappedClass);

		return this.query(buildSqlHolder(query), mappedClass);
	}

	protected final <T> List<T> query(SqlHolder sqlHolder, final Class<T> mappedClass)
			throws DaoException {

		Validate.notNull(sqlHolder);
		Validate.notNull(mappedClass);

		return new Query<List<T>>(sqlHolder) {
			@Override
			protected List<T> doQuery() {
				return namedJdbcTemplate.query(SQL, PARAMS, buildRowMapper(mappedClass));
			}
		}.execute();
	}

	//////////////////////////////////////////////////////////////////////

	protected final Integer update(SqlHolder sqlHolder)
			throws DaoException {

		Validate.notNull(sqlHolder);

		return new Query<Integer>(sqlHolder) {
			@Override
			protected Integer doQuery() {
				return namedJdbcTemplate.update(SQL, PARAMS);
			}
		}.execute();
	}

	//////////////////////////////////////////////////////////////////////

	protected final Long nextval(String sequenceName)
			throws DaoException {

		Validate.notBlank(sequenceName);

		SqlHolder sh = buildSqlHolder("select nextval(:sequenceName) as num")
				.bind("sequenceName", sequenceName);

		return new Query<Long>(sh) {
			@Override
			protected Long doQuery() {
				return namedJdbcTemplate.queryForLong(SQL, PARAMS);
			}
		}.execute();
	}

}
