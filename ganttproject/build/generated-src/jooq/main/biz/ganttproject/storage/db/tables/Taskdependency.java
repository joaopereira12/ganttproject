/*
 * This file is generated by jOOQ.
 */
package biz.ganttproject.storage.db.tables;


import biz.ganttproject.storage.db.DefaultSchema;
import biz.ganttproject.storage.db.Keys;
import biz.ganttproject.storage.db.tables.records.TaskdependencyRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Check;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Taskdependency extends TableImpl<TaskdependencyRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>taskdependency</code>
     */
    public static final Taskdependency TASKDEPENDENCY = new Taskdependency();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TaskdependencyRecord> getRecordType() {
        return TaskdependencyRecord.class;
    }

    /**
     * The column <code>taskdependency.dependee_uid</code>.
     */
    public final TableField<TaskdependencyRecord, String> DEPENDEE_UID = createField(DSL.name("dependee_uid"), SQLDataType.VARCHAR(1048576).nullable(false), this, "");

    /**
     * The column <code>taskdependency.dependant_uid</code>.
     */
    public final TableField<TaskdependencyRecord, String> DEPENDANT_UID = createField(DSL.name("dependant_uid"), SQLDataType.VARCHAR(1048576).nullable(false), this, "");

    /**
     * The column <code>taskdependency.type</code>.
     */
    public final TableField<TaskdependencyRecord, String> TYPE = createField(DSL.name("type"), SQLDataType.VARCHAR(1048576).nullable(false), this, "");

    /**
     * The column <code>taskdependency.lag</code>.
     */
    public final TableField<TaskdependencyRecord, Integer> LAG = createField(DSL.name("lag"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>taskdependency.hardness</code>.
     */
    public final TableField<TaskdependencyRecord, String> HARDNESS = createField(DSL.name("hardness"), SQLDataType.VARCHAR(1048576).nullable(false), this, "");

    private Taskdependency(Name alias, Table<TaskdependencyRecord> aliased) {
        this(alias, aliased, null);
    }

    private Taskdependency(Name alias, Table<TaskdependencyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>taskdependency</code> table reference
     */
    public Taskdependency(String alias) {
        this(DSL.name(alias), TASKDEPENDENCY);
    }

    /**
     * Create an aliased <code>taskdependency</code> table reference
     */
    public Taskdependency(Name alias) {
        this(alias, TASKDEPENDENCY);
    }

    /**
     * Create a <code>taskdependency</code> table reference
     */
    public Taskdependency() {
        this(DSL.name("taskdependency"), null);
    }

    public <O extends Record> Taskdependency(Table<O> child, ForeignKey<O, TaskdependencyRecord> key) {
        super(child, key, TASKDEPENDENCY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<TaskdependencyRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_6;
    }

    @Override
    public List<ForeignKey<TaskdependencyRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CONSTRAINT_66, Keys.CONSTRAINT_66F);
    }

    private transient Task _constraint_66;
    private transient Task _constraint_66f;

    /**
     * Get the implicit join path to the <code>PUBLIC.task</code> table, via the
     * <code>CONSTRAINT_66</code> key.
     */
    public Task constraint_66() {
        if (_constraint_66 == null)
            _constraint_66 = new Task(this, Keys.CONSTRAINT_66);

        return _constraint_66;
    }

    /**
     * Get the implicit join path to the <code>PUBLIC.task</code> table, via the
     * <code>CONSTRAINT_66F</code> key.
     */
    public Task constraint_66f() {
        if (_constraint_66f == null)
            _constraint_66f = new Task(this, Keys.CONSTRAINT_66F);

        return _constraint_66f;
    }

    @Override
    public List<Check<TaskdependencyRecord>> getChecks() {
        return Arrays.asList(
            Internal.createCheck(this, DSL.name("CONSTRAINT_66F7"), "\"dependee_uid\" <> \"dependant_uid\"", true)
        );
    }

    @Override
    public Taskdependency as(String alias) {
        return new Taskdependency(DSL.name(alias), this);
    }

    @Override
    public Taskdependency as(Name alias) {
        return new Taskdependency(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Taskdependency rename(String name) {
        return new Taskdependency(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Taskdependency rename(Name name) {
        return new Taskdependency(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, String, String, Integer, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}