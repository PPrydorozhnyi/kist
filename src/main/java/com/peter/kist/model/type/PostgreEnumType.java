package com.peter.kist.model.type;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.EnumType;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class PostgreEnumType extends EnumType {
    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws SQLException {
        if (value == null) st.setNull(index, Types.OTHER);
        else st.setObject(index, value.toString(), Types.OTHER);
    }
}
