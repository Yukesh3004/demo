package Array;

public class Container_with_maximum_water {  //leetcode problem no:11

    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right){
            int area = Math.min(height[left],height[right]) * (right-left);
            maxArea = Math.max(area, maxArea);

            if(height[left] < height[right]){
                left+=1;
            }else{
                right-=1;
            }
        }

        return maxArea;
    }

}
