/*
 * This file is generated by jOOQ.
 */
package biz.ganttproject.storage.db.tables.records;


import biz.ganttproject.storage.db.tables.Task;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record16;
import org.jooq.Row16;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TaskRecord extends UpdatableRecordImpl<TaskRecord> implements Record16<String, Integer, String, String, String, Boolean, Boolean, LocalDate, Integer, Integer, LocalDate, String, String, BigDecimal, Boolean, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>task.uid</code>.
     */
    public void setUid(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>task.uid</code>.
     */
    public String getUid() {
        return (String) get(0);
    }

    /**
     * Setter for <code>task.num</code>.
     */
    public void setNum(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>task.num</code>.
     */
    public Integer getNum() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>task.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>task.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>task.color</code>.
     */
    public void setColor(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>task.color</code>.
     */
    public String getColor() {
        return (String) get(3);
    }

    /**
     * Setter for <code>task.shape</code>.
     */
    public void setShape(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>task.shape</code>.
     */
    public String getShape() {
        return (String) get(4);
    }

    /**
     * Setter for <code>task.is_milestone</code>.
     */
    public void setIsMilestone(Boolean value) {
        set(5, value);
    }

    /**
     * Getter for <code>task.is_milestone</code>.
     */
    public Boolean getIsMilestone() {
        return (Boolean) get(5);
    }

    /**
     * Setter for <code>task.is_project_task</code>.
     */
    public void setIsProjectTask(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>task.is_project_task</code>.
     */
    public Boolean getIsProjectTask() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>task.start_date</code>.
     */
    public void setStartDate(LocalDate value) {
        set(7, value);
    }

    /**
     * Getter for <code>task.start_date</code>.
     */
    public LocalDate getStartDate() {
        return (LocalDate) get(7);
    }

    /**
     * Setter for <code>task.duration</code>.
     */
    public void setDuration(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>task.duration</code>.
     */
    public Integer getDuration() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>task.completion</code>.
     */
    public void setCompletion(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>task.completion</code>.
     */
    public Integer getCompletion() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>task.earliest_start_date</code>.
     */
    public void setEarliestStartDate(LocalDate value) {
        set(10, value);
    }

    /**
     * Getter for <code>task.earliest_start_date</code>.
     */
    public LocalDate getEarliestStartDate() {
        return (LocalDate) get(10);
    }

    /**
     * Setter for <code>task.priority</code>.
     */
    public void setPriority(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>task.priority</code>.
     */
    public String getPriority() {
        return (String) get(11);
    }

    /**
     * Setter for <code>task.web_link</code>.
     */
    public void setWebLink(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>task.web_link</code>.
     */
    public String getWebLink() {
        return (String) get(12);
    }

    /**
     * Setter for <code>task.cost_manual_value</code>.
     */
    public void setCostManualValue(BigDecimal value) {
        set(13, value);
    }

    /**
     * Getter for <code>task.cost_manual_value</code>.
     */
    public BigDecimal getCostManualValue() {
        return (BigDecimal) get(13);
    }

    /**
     * Setter for <code>task.is_cost_calculated</code>.
     */
    public void setIsCostCalculated(Boolean value) {
        set(14, value);
    }

    /**
     * Getter for <code>task.is_cost_calculated</code>.
     */
    public Boolean getIsCostCalculated() {
        return (Boolean) get(14);
    }

    /**
     * Setter for <code>task.notes</code>.
     */
    public void setNotes(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>task.notes</code>.
     */
    public String getNotes() {
        return (String) get(15);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record16 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row16<String, Integer, String, String, String, Boolean, Boolean, LocalDate, Integer, Integer, LocalDate, String, String, BigDecimal, Boolean, String> fieldsRow() {
        return (Row16) super.fieldsRow();
    }

    @Override
    public Row16<String, Integer, String, String, String, Boolean, Boolean, LocalDate, Integer, Integer, LocalDate, String, String, BigDecimal, Boolean, String> valuesRow() {
        return (Row16) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Task.TASK.UID;
    }

    @Override
    public Field<Integer> field2() {
        return Task.TASK.NUM;
    }

    @Override
    public Field<String> field3() {
        return Task.TASK.NAME;
    }

    @Override
    public Field<String> field4() {
        return Task.TASK.COLOR;
    }

    @Override
    public Field<String> field5() {
        return Task.TASK.SHAPE;
    }

    @Override
    public Field<Boolean> field6() {
        return Task.TASK.IS_MILESTONE;
    }

    @Override
    public Field<Boolean> field7() {
        return Task.TASK.IS_PROJECT_TASK;
    }

    @Override
    public Field<LocalDate> field8() {
        return Task.TASK.START_DATE;
    }

    @Override
    public Field<Integer> field9() {
        return Task.TASK.DURATION;
    }

    @Override
    public Field<Integer> field10() {
        return Task.TASK.COMPLETION;
    }

    @Override
    public Field<LocalDate> field11() {
        return Task.TASK.EARLIEST_START_DATE;
    }

    @Override
    public Field<String> field12() {
        return Task.TASK.PRIORITY;
    }

    @Override
    public Field<String> field13() {
        return Task.TASK.WEB_LINK;
    }

    @Override
    public Field<BigDecimal> field14() {
        return Task.TASK.COST_MANUAL_VALUE;
    }

    @Override
    public Field<Boolean> field15() {
        return Task.TASK.IS_COST_CALCULATED;
    }

    @Override
    public Field<String> field16() {
        return Task.TASK.NOTES;
    }

    @Override
    public String component1() {
        return getUid();
    }

    @Override
    public Integer component2() {
        return getNum();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public String component4() {
        return getColor();
    }

    @Override
    public String component5() {
        return getShape();
    }

    @Override
    public Boolean component6() {
        return getIsMilestone();
    }

    @Override
    public Boolean component7() {
        return getIsProjectTask();
    }

    @Override
    public LocalDate component8() {
        return getStartDate();
    }

    @Override
    public Integer component9() {
        return getDuration();
    }

    @Override
    public Integer component10() {
        return getCompletion();
    }

    @Override
    public LocalDate component11() {
        return getEarliestStartDate();
    }

    @Override
    public String component12() {
        return getPriority();
    }

    @Override
    public String component13() {
        return getWebLink();
    }

    @Override
    public BigDecimal component14() {
        return getCostManualValue();
    }

    @Override
    public Boolean component15() {
        return getIsCostCalculated();
    }

    @Override
    public String component16() {
        return getNotes();
    }

    @Override
    public String value1() {
        return getUid();
    }

    @Override
    public Integer value2() {
        return getNum();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public String value4() {
        return getColor();
    }

    @Override
    public String value5() {
        return getShape();
    }

    @Override
    public Boolean value6() {
        return getIsMilestone();
    }

    @Override
    public Boolean value7() {
        return getIsProjectTask();
    }

    @Override
    public LocalDate value8() {
        return getStartDate();
    }

    @Override
    public Integer value9() {
        return getDuration();
    }

    @Override
    public Integer value10() {
        return getCompletion();
    }

    @Override
    public LocalDate value11() {
        return getEarliestStartDate();
    }

    @Override
    public String value12() {
        return getPriority();
    }

    @Override
    public String value13() {
        return getWebLink();
    }

    @Override
    public BigDecimal value14() {
        return getCostManualValue();
    }

    @Override
    public Boolean value15() {
        return getIsCostCalculated();
    }

    @Override
    public String value16() {
        return getNotes();
    }

    @Override
    public TaskRecord value1(String value) {
        setUid(value);
        return this;
    }

    @Override
    public TaskRecord value2(Integer value) {
        setNum(value);
        return this;
    }

    @Override
    public TaskRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public TaskRecord value4(String value) {
        setColor(value);
        return this;
    }

    @Override
    public TaskRecord value5(String value) {
        setShape(value);
        return this;
    }

    @Override
    public TaskRecord value6(Boolean value) {
        setIsMilestone(value);
        return this;
    }

    @Override
    public TaskRecord value7(Boolean value) {
        setIsProjectTask(value);
        return this;
    }

    @Override
    public TaskRecord value8(LocalDate value) {
        setStartDate(value);
        return this;
    }

    @Override
    public TaskRecord value9(Integer value) {
        setDuration(value);
        return this;
    }

    @Override
    public TaskRecord value10(Integer value) {
        setCompletion(value);
        return this;
    }

    @Override
    public TaskRecord value11(LocalDate value) {
        setEarliestStartDate(value);
        return this;
    }

    @Override
    public TaskRecord value12(String value) {
        setPriority(value);
        return this;
    }

    @Override
    public TaskRecord value13(String value) {
        setWebLink(value);
        return this;
    }

    @Override
    public TaskRecord value14(BigDecimal value) {
        setCostManualValue(value);
        return this;
    }

    @Override
    public TaskRecord value15(Boolean value) {
        setIsCostCalculated(value);
        return this;
    }

    @Override
    public TaskRecord value16(String value) {
        setNotes(value);
        return this;
    }

    @Override
    public TaskRecord values(String value1, Integer value2, String value3, String value4, String value5, Boolean value6, Boolean value7, LocalDate value8, Integer value9, Integer value10, LocalDate value11, String value12, String value13, BigDecimal value14, Boolean value15, String value16) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TaskRecord
     */
    public TaskRecord() {
        super(Task.TASK);
    }

    /**
     * Create a detached, initialised TaskRecord
     */
    public TaskRecord(String uid, Integer num, String name, String color, String shape, Boolean isMilestone, Boolean isProjectTask, LocalDate startDate, Integer duration, Integer completion, LocalDate earliestStartDate, String priority, String webLink, BigDecimal costManualValue, Boolean isCostCalculated, String notes) {
        super(Task.TASK);

        setUid(uid);
        setNum(num);
        setName(name);
        setColor(color);
        setShape(shape);
        setIsMilestone(isMilestone);
        setIsProjectTask(isProjectTask);
        setStartDate(startDate);
        setDuration(duration);
        setCompletion(completion);
        setEarliestStartDate(earliestStartDate);
        setPriority(priority);
        setWebLink(webLink);
        setCostManualValue(costManualValue);
        setIsCostCalculated(isCostCalculated);
        setNotes(notes);
    }
}
