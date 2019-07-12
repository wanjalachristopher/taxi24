package com.taxi.config.database;

import java.sql.Types;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;

public class SQLiteDialect extends Dialect {
	public SQLiteDialect() {
        registerColumnType(Types.BIT, "integer");
        registerColumnType(Types.TINYINT, "tinyint");
        registerColumnType(Types.SMALLINT, "smallint");
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.VARCHAR, "varchar");
        registerColumnType(Types.BOOLEAN, "boolean");
        registerColumnType(Types.DOUBLE, "double");
       
    }
	
	@Override
	public IdentityColumnSupport getIdentityColumnSupport() {
	    return new SQLiteIdentityColumnSupport(this);
	}
	@Override
	public String getAddColumnString() {
		return "Add column";
	}
}
