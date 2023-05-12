package z.y.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static z.y.mapper.DbUserDynamicSqlSupport.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import z.y.model.DbUser;

@Mapper
public interface DbUserMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DbUser>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(uid, name, age, sex);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DbUserResult", value = {
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.SMALLINT)
    })
    List<DbUser> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DbUserResult")
    Optional<DbUser> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dbUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dbUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer uid_) {
        return delete(c -> 
            c.where(uid, isEqualTo(uid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(DbUser row) {
        return MyBatis3Utils.insert(this::insert, row, dbUser, c ->
            c.map(uid).toProperty("uid")
            .map(name).toProperty("name")
            .map(age).toProperty("age")
            .map(sex).toProperty("sex")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<DbUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dbUser, c ->
            c.map(uid).toProperty("uid")
            .map(name).toProperty("name")
            .map(age).toProperty("age")
            .map(sex).toProperty("sex")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(DbUser row) {
        return MyBatis3Utils.insert(this::insert, row, dbUser, c ->
            c.map(uid).toPropertyWhenPresent("uid", row::getUid)
            .map(name).toPropertyWhenPresent("name", row::getName)
            .map(age).toPropertyWhenPresent("age", row::getAge)
            .map(sex).toPropertyWhenPresent("sex", row::getSex)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<DbUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dbUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<DbUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dbUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<DbUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dbUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<DbUser> selectByPrimaryKey(Integer uid_) {
        return selectOne(c ->
            c.where(uid, isEqualTo(uid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dbUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(DbUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uid).equalTo(row::getUid)
                .set(name).equalTo(row::getName)
                .set(age).equalTo(row::getAge)
                .set(sex).equalTo(row::getSex);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DbUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uid).equalToWhenPresent(row::getUid)
                .set(name).equalToWhenPresent(row::getName)
                .set(age).equalToWhenPresent(row::getAge)
                .set(sex).equalToWhenPresent(row::getSex);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(DbUser row) {
        return update(c ->
            c.set(name).equalTo(row::getName)
            .set(age).equalTo(row::getAge)
            .set(sex).equalTo(row::getSex)
            .where(uid, isEqualTo(row::getUid))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(DbUser row) {
        return update(c ->
            c.set(name).equalToWhenPresent(row::getName)
            .set(age).equalToWhenPresent(row::getAge)
            .set(sex).equalToWhenPresent(row::getSex)
            .where(uid, isEqualTo(row::getUid))
        );
    }
}