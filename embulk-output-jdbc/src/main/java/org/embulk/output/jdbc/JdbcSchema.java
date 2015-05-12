package org.embulk.output.jdbc;

import java.util.List;
import com.google.common.base.Optional;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class JdbcSchema
{
    private List<JdbcColumn> columns;

    @JsonCreator
    public JdbcSchema(List<JdbcColumn> columns)
    {
        this.columns = columns;
    }

    @JsonValue
    public List<JdbcColumn> getColumns()
    {
        return columns;
    }

    public Optional<JdbcColumn> findColumn(String name)
    {
        for (JdbcColumn column : columns) {
            if (column.getName().equals(name)) {
                return Optional.of(column);
            }
        }
        return Optional.absent();
    }

    public int getCount()
    {
        return columns.size();
    }

    public JdbcColumn getColumn(int i)
    {
        return columns.get(i);
    }

    public String getColumnName(int i)
    {
        return columns.get(i).getName();
    }
}
