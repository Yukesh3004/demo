package Array;

public class Product_of_array_except_self {

    public static int[] productExceptSelf(int[] nums){ //leetcode problem no:238
        //brute force
//        int zero_count = 0;
//        int[] productArr = new int[nums.length];
//
//        for(int i=0; i<nums.length; i++){
//            if(zero_count > 1){
//                return productArr;
//            }else if(nums[i]==0){
//                zero_count++;
//            }
//            int product = 1;
//            for(int j=0; j<nums.length; j++){
//                if(i==j){
//                    continue;
//                }else{
//                    product *= nums[j];
//                }
//            }
//            productArr[i] = product;
//        }
//
//        return productArr;

        //Efficient code
        int[] leftArr = new int[nums.length];
        int[] rightArr = new int[nums.length];

        leftArr[0] = 1;
        for(int i=1; i<nums.length; i++){
            leftArr[i] = leftArr[i-1] * nums[i-1];
        }

        rightArr[nums.length-1] = 1;
        for(int i=nums.length-2; i>-1; i--){
            rightArr[i] = rightArr[i+1] * nums[i+1];
        }

        int ans[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = leftArr[i] * rightArr[i];
        }

        return ans;
    }

}
