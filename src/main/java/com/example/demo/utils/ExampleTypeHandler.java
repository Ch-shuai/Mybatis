package com.example.demo.utils;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;

import static java.sql.JDBCType.VARCHAR;

/**
 * 2020/3/12
 *
 * @author wuzhanhao
 * <p>
 * description:
 *      可以重写已有的类型处理器或创建你自己的类型处理器来处理不支持的或非标准的类型。
 *
 * @MappedTypes
 *      注解指定与其关联的 Java 类型列表,在这指定使用VARCHAR
 */

@MappedJdbcTypes(JdbcType.VARCHAR)
public class ExampleTypeHandler implements TypeHandler {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,String.valueOf(preparedStatement));
    }

    @Override
    public Object getResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getString(s);
    }

    @Override
    public Object getResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString(i);
    }

    @Override
    public Object getResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getString(String.valueOf(callableStatement));
    }
}
