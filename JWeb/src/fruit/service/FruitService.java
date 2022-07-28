package fruit.service;

import fruit.pojo.Fruit;

import java.util.List;

/**
 * @author Jason
 * @date 2022/7/27 09:34
 * @Description
 */
public interface FruitService {
    //获取指定页面的库存列表信息
    List<Fruit> getFruitList(String keyword, Integer pageNo);
    //添加库存记录信息
    void addFruit(Fruit fruit);
    //根据id查看指定库存记录
    Fruit getFruitByFid(Integer fid);
    //删除指定库存记录
    void delFruit(Integer fid);
    //获取记录总页数
    Integer getPageCount(String keyword);
    //修改
    void updateFruit(Fruit fruit);
}
