package study.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jason
 * @date 2022/7/12 10:04
 * @Description
 */
public class GameDemo {
    //1.定义一个静态的集合存放54张牌

    public static List<Card> allCards = new ArrayList<>();

    //2，做牌
    static {
        String[] sizes = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] colors = {"♠️","♥️","♦️","♣️"};
        int index = 0;
        //组合花色和点数
        for (String s : sizes) {
            index++;
            for (String color : colors) {
                Card card = new Card(s,color,index);
                allCards.add(card);
            }
        }

        //存入大小王
        Card c = new Card("","小🃏",++index);
        Card c1 = new Card("","大🃏",++index);
        Collections.addAll(allCards,c,c1);


    }
    public static void main(String[] args) {
        Collections.shuffle(allCards);
        System.out.println(allCards);

        //发牌
        List<Card> liangjiahe = new ArrayList<>();
        List<Card> jiumozhi = new ArrayList<>();
        List<Card> chezijie = new ArrayList<>();

        for (int i = 0; i < allCards.size() - 3; i++) {
            Card c = allCards.get(i);
            if (i % 3 == 0){
                liangjiahe.add(c);
            }else if(i % 3 == 1){
                jiumozhi.add(c);
            }else if(i % 3 == 2){
                chezijie.add(c);
            }
        }

        //拿最后三张底牌
        List<Card> lastThreeCards = allCards.subList(allCards.size() - 3 , allCards.size());

        //给玩家牌排序(从大到小)
        sortCards(liangjiahe);
        sortCards(jiumozhi);
        sortCards(chezijie);


        //输出玩家的牌
        System.out.println("梁：" + liangjiahe);
        System.out.println("鸠：" + jiumozhi);
        System.out.println("车：" + chezijie);
        System.out.println("三张底牌：" + lastThreeCards);
    }

    private static void sortCards(List<Card> cards) {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o2.getIndex() - o1.getIndex();
            }
        });
    }
}
