import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import z.y.SpringMvcInit;
import z.y.config.DataSourceConfig;
import z.y.config.SpringAOPConfig;
import z.y.config.SpringMvcConfig;
import static z.y.mapper.ArtistDynamicSqlSupport.*;
import z.y.mapper.ArtistMapper;
import z.y.model.Artist;

import javax.annotation.Resource;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * 使用组合注解SpringJUnitWebConfig(),后面加上配置文件.Spring5新特性
 */
@SpringJUnitWebConfig(DataSourceConfig.class)
public class TestMybatis {

    @Resource
    private ArtistMapper artistMapper;

    @Test
    public void test() {

        Artist artist11 = artistMapper.selectByPrimaryKey(2).get();

        System.out.println("artist.toString() = " + artist11);

        SelectStatementProvider render = select(artist.allColumns())
                .from(artist)
                .build()
                .render(RenderingStrategies.MYBATIS3);

        List<Artist> artists = artistMapper.selectMany(render);

        artists.forEach(System.out::println);
    }

    @Test
    public void test1() {
        SelectStatementProvider build = select(artist.allColumns())
                .from(artist)
                .where(artistid, isBetween(4).and(8))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        List<Artist> artists = artistMapper.selectMany(build);
        artists.forEach(System.out::println);

    }
}
