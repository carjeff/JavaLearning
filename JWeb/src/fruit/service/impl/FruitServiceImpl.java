package fruit.biz.impl;

import fruit.biz.FruitService;
import fruit.dao.FruitDAO;
import fruit.dao.impl.FruitDAOImpl;
import fruit.pojo.Fruit;

import java.util.List;

/**
 * @author Jason
 * @date 2022/7/27 09:38
 * @Description
 */
public class FruitServiceImpl implements FruitService {

    private FruitDAO fruitDAO = new FruitDAOImpl();
    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        return fruitDAO.getFruitList(keyword, pageNo);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
    }

    @Override
    public Fruit getFruitByFid(Integer fid) {
        return fruitDAO.getFruitByFid(fid);
    }

    @Override
    public void delFruit(Integer fid) {
        fruitDAO.delFruit(fid);
    }

    @Override
    public Integer getPageCount(String keyword) {
        int count = fruitDAO.getFruitCount(keyword);
        int pageCount = (count+5-1)/5;
        return pageCount;
    }

    @Override
    public void updateFruit(Fruit fruit) {
        fruitDAO.updateFruit(fruit);
    }
}
