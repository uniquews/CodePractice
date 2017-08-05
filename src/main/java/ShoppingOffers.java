import java.util.*;

/**
 * Created by shuaiwang on 8/3/17.
 */
public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(price, special, needs, memo);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<String, Integer> memo) {
        String key = "";
        for (int i = 0; i < needs.size(); i++) {
            key += needs.get(i) + "#";
        }

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int currentCost = Integer.MAX_VALUE;

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
                currentCost = Math.min(currentCost, dfs(price, special, nextNeeds,  memo) + offerCost);
            }
        }

        int individual = 0;
        for (int i = 0; i < needs.size(); i++) {
            individual += needs.get(i) * price.get(i);
        }

        currentCost = Math.min(currentCost, individual);
        memo.put(key, currentCost);
        return currentCost;
    }

    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>(Arrays.asList(2,5));
        List<List<Integer>> special = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(3,0,5)), new ArrayList<>(Arrays.asList(1,2,10))));
        List<Integer> needs = new ArrayList<>(Arrays.asList(3,2));

        ShoppingOffers test = new ShoppingOffers();
        System.out.print(test.shoppingOffers(price, special, needs));
    }
}
