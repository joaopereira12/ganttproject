/*
 * This file is generated by jOOQ.
 */
package biz.ganttproject.storage.db.tables;


import biz.ganttproject.storage.db.DefaultSchema;
import biz.ganttproject.storage.db.Keys;
import biz.ganttproject.storage.db.tables.records.LogrecordRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Logrecord extends TableImpl<LogrecordRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>logrecord</code>
     */
    public static final Logrecord LOGRECORD = new Logrecord();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LogrecordRecord> getRecordType() {
        return LogrecordRecord.class;
    }

    /**
     * The column <code>logrecord.id</code>.
     */
    public final TableField<LogrecordRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>logrecord.local_txn_id</code>.
     */
    public final TableField<LogrecordRecord, Integer> LOCAL_TXN_ID = createField(DSL.name("local_txn_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>logrecord.operation_dto_json</code>.
     */
    public final TableField<LogrecordRecord, String> OPERATION_DTO_JSON = createField(DSL.name("operation_dto_json"), SQLDataType.VARCHAR(1048576).nullable(false), this, "");

    private Logrecord(Name alias, Table<LogrecordRecord> aliased) {
        this(alias, aliased, null);
    }

    private Logrecord(Name alias, Table<LogrecordRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>logrecord</code> table reference
     */
    public Logrecord(String alias) {
        this(DSL.name(alias), LOGRECORD);
    }

    /**
     * Create an aliased <code>logrecord</code> table reference
     */
    public Logrecord(Name alias) {
        this(alias, LOGRECORD);
    }

    /**
     * Create a <code>logrecord</code> table reference
     */
    public Logrecord() {
        this(DSL.name("logrecord"), null);
    }

    public <O extends Record> Logrecord(Table<O> child, ForeignKey<O, LogrecordRecord> key) {
        super(child, key, LOGRECORD);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<LogrecordRecord, Integer> getIdentity() {
        return (Identity<LogrecordRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<LogrecordRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_A;
    }

    @Override
    public Logrecord as(String alias) {
        return new Logrecord(DSL.name(alias), this);
    }

    @Override
    public Logrecord as(Name alias) {
        return new Logrecord(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Logrecord rename(String name) {
        return new Logrecord(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Logrecord rename(Name name) {
        return new Logrecord(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
