package z.y.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static z.y.mapper.ArtistDynamicSqlSupport.*;

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
import z.y.model.Artist;

@Mapper
public interface ArtistMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Artist>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(artistid, name);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ArtistResult", value = {
        @Result(column="ArtistId", property="artistid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Artist> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ArtistResult")
    Optional<Artist> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, artist, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, artist, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer artistid_) {
        return delete(c -> 
            c.where(artistid, isEqualTo(artistid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Artist row) {
        return MyBatis3Utils.insert(this::insert, row, artist, c ->
            c.map(artistid).toProperty("artistid")
            .map(name).toProperty("name")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Artist> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, artist, c ->
            c.map(artistid).toProperty("artistid")
            .map(name).toProperty("name")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Artist row) {
        return MyBatis3Utils.insert(this::insert, row, artist, c ->
            c.map(artistid).toPropertyWhenPresent("artistid", row::getArtistid)
            .map(name).toPropertyWhenPresent("name", row::getName)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Artist> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, artist, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Artist> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, artist, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Artist> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, artist, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Artist> selectByPrimaryKey(Integer artistid_) {
        return selectOne(c ->
            c.where(artistid, isEqualTo(artistid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, artist, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Artist row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(artistid).equalTo(row::getArtistid)
                .set(name).equalTo(row::getName);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Artist row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(artistid).equalToWhenPresent(row::getArtistid)
                .set(name).equalToWhenPresent(row::getName);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Artist row) {
        return update(c ->
            c.set(name).equalTo(row::getName)
            .where(artistid, isEqualTo(row::getArtistid))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Artist row) {
        return update(c ->
            c.set(name).equalToWhenPresent(row::getName)
            .where(artistid, isEqualTo(row::getArtistid))
        );
    }
}