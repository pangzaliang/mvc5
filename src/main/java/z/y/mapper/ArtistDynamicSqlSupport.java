package z.y.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ArtistDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Artist artist = new Artist();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> artistid = artist.artistid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = artist.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Artist extends AliasableSqlTable<Artist> {
        public final SqlColumn<Integer> artistid = column("ArtistId", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("Name", JDBCType.VARCHAR);

        public Artist() {
            super("Artist", Artist::new);
        }
    }
}