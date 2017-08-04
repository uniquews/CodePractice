import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 8/3/17.
 */
public class ShoppingOffers {
    int money = Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        dfs(price, special, needs, 0);
        return money;
    }

    private void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int cost) {
        for (int i = 0; i < special.size(); i++) {
            boolean isValidOffer = true;

            List<Integer> offer = special.get(i);
            int offerCost = offer.get(offer.size() - 1);
            List<Integer> nextNeeds = new ArrayList<>(needs);

            for (int j = 0; j < offer.size() - 1; j++) {
                int remain = needs.get(j) - offer.get(j);
                if (remain < 0) {
                    isValidOffer = false;
                    break;
                } else {
                    nextNeeds.set(j, remain);
                }
            }

            if (isValidOffer) {
                dfs(price, special, nextNeeds, cost + offerCost);
            }
        }

        for (int i = 0; i < needs.size(); i++) {
            cost += needs.get(i) * price.get(i);
        }

        money = Math.min(money, cost);
    }

    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>(Arrays.asList(2,5));
        List<List<Integer>> special = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(3,0,5)), new ArrayList<>(Arrays.asList(1,2,10))));
        List<Integer> needs = new ArrayList<>(Arrays.asList(3,2));

        ShoppingOffers test = new ShoppingOffers();
        System.out.print(test.shoppingOffers(price, special, needs));
    }
}
