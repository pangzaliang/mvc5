import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import z.y.config.SpringMvcConfig;
import z.y.mapper.ArtistMapper;
import z.y.model.Artist;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = SpringMvcConfig.class)
public class test001 {

    @Resource
    private ArtistMapper artistMapper;

    @Test
    public void test() {

        Artist artist = artistMapper.selectByPrimaryKey(2).get();

        System.out.println("artist.toString() = " + artist);

    }
}
