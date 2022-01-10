import java.util.HashMap;
import java.util.Map;

public class minSubarray {

    public int findSubarray(int[]nums, int p){
        int ans;
        int n = nums.length;
        long sum=0, now=0;
        Map<Long, Integer> map = new HashMap<>();

        for (int i=0; i< n ; i++){
            sum += nums[i];
        }
        if (sum % p ==0){
            return 0;
        }
        ans = n;
        long mod = sum % p;
        map.put(0L, -1);

        for (int i=0; i < n; i++ ){
            now += nums[i];
            if(map.containsKey((now % p - sum % p + p))){
                ans = Math.min(ans, i - map.get(now % p - sum % p +p)%p);
            }
            map.put(now % p, i);
        }
        return ans == n ? -1:ans;
    }

    public int findCombin(int[] nums, int p){
        int length = nums.length;

        return 0;
    }

    public static void main(String[] args) {
//        int[] nums = {3,5,9};
//        int target = 13;


//        for(int j= nums.length-1; j>=0;j--){
//            int x = target-nums[j];
//            for(int i= nums.length-1; i>=0 ; i--){
//                if(x % nums[i]==0){
//                    System.out.println(nums[j]);
//                    System.out.println(nums[i]);
//                    return;
//                }
//            }
//        }

        bundles bundles = new bundles("IMG");
        Map imgTable = bundles.getBundleTable();
        Map AudioTable = bundles.getBundleTable();
        Map VideoTable = bundles.getBundleTable();

    }
}
