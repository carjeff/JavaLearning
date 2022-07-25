package fruit.dao;

import fruit.bean.Fruit;

import java.util.List;

/**
 * @author Jason
 * @date 2022/7/25 09:50
 * @Description
 */
public interface FruitDAO {
    //获取所有的库存列表信息
    List<Fruit> getFruitList();

    //根据fid获取对应库存信息
    Fruit getFruitByFid(Integer fid);

    //修改对应fid的库存信息
    void updateFruit(Fruit fruit);

    //删除对应fid的库存信息
    void delFruit(int fid);

    //添加库存信息
    void addFruit(Fruit fruit);
}
