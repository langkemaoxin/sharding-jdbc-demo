package dao;

import com.lagou.RunBoot;
import com.lagou.entity.Position;
import com.lagou.entity.PositionDetail;
import com.lagou.repository.PositionDetailRepository;
import com.lagou.repository.PositionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunBoot.class)
public class TestShardingDatabase {

    @Resource
    private PositionRepository positionRepository;

    @Resource
    private PositionDetailRepository positionDetailRepository;

    @Test
    public void testAdd(){
        for (int i=1;i<=20;i++){
            Position position = new Position();
            position.setId(i);
            position.setName("lagou"+i);
            position.setSalary("1000000");
            position.setCity("beijing");
            positionRepository.save(position);
        }
    }

    @Test
    public void testAdd2(){
        for (int i=1;i<=20;i++){
            Position position = new Position();
            position.setName("lagou"+i);
            position.setSalary("1000000");
            position.setCity("beijing");
            positionRepository.save(position);

            PositionDetail positionDetail = new PositionDetail();
            positionDetail.setPid(position.getId());
            positionDetail.setDescription("this is a message "+i);
            positionDetailRepository.save(positionDetail);
        }
    }

    @Test
    public void testLoad(){
        Object object = positionRepository.findPositionsById(470186138993164289L);
        Object[] position = (Object[])object;
        System.out.println(position[0]+" "+position[1]+" "+position[2]+" "+position[3]+" "+position[4]);
    }



}
