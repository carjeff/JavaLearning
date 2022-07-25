import fruit.bean.Fruit;
import fruit.dao.FruitDAO;
import fruit.dao.impl.FruitDAOImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author Jason
 * @date 2022/7/25 10:51
 * @Description
 */
public class junit {
    @Test
    public void test1(){
        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList();
        System.out.println(fruitList);
    }
}
