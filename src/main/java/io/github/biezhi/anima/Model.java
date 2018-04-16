package io.github.biezhi.anima;

import io.github.biezhi.anima.core.AnimaQuery;
import io.github.biezhi.anima.core.ResultKey;
import io.github.biezhi.anima.core.functions.TypeFunction;

import java.io.Serializable;

/**
 * Base Model
 *
 * @author biezhi
 * @date 2018/3/16
 */
public class Model {

    /**
     * The query object for the current model.
     */
    private AnimaQuery<? extends Model> animaQuery = new AnimaQuery<>(this.getClass());

    /**
     * Save model
     *
     * @return ResultKey
     */
    public ResultKey save() {
        return animaQuery.save(this);
    }

    /**
     * Update model
     *
     * @return number of rows affected after execution
     */
    public int update() {
        return animaQuery.updateByModel(this);
    }

    /**
     * Update by primary key
     *
     * @param id pk
     * @return number of rows affected after execution
     */
    public int updateById(Serializable id) {
        return new AnimaQuery<>(this.getClass()).updateById(this, id);
    }

    /**
     * Delete model
     *
     * @return number of rows affected after execution
     */
    public int delete() {
        return animaQuery.deleteByModel(this);
    }

    /**
     * Update set statement
     *
     * @param column table column name [sql]
     * @param value  column value
     * @return AnimaQuery
     */
    public AnimaQuery<? extends Model> set(String column, Object value) {
        return animaQuery.set(column, value);
    }

    /**
     * Update set statement with lambda
     *
     * @param function table column name with lambda
     * @param value    column value
     * @param <T>
     * @param <R>
     * @return AnimaQuery
     */
    public <T extends Model, R> AnimaQuery<? extends Model> set(TypeFunction<T, R> function, Object value) {
        return animaQuery.set(function, value);
    }

    /**
     * Where statement
     *
     * @param statement conditional clause
     * @param value     column value
     * @return AnimaQuery
     */
    public AnimaQuery<? extends Model> where(String statement, Object value) {
        return animaQuery.where(statement, value);
    }

    /**
     * Where statement with lambda
     *
     * @param function column name with lambda
     * @param value    column value
     * @param <T>
     * @param <R>
     * @return AnimaQuery
     */
    public <T extends Model, R> AnimaQuery<? extends Model> where(TypeFunction<T, R> function, Object value) {
        return animaQuery.where(function, value);
    }

}
