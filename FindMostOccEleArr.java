public class MajorityElementFinder {

public static int dsaAss1(int[] nums) {

    int candidate = 0;

    int count = 0;

    // Finding potential majority element

    for (int num : nums) {

        if (count == 0) {

            candidate = num;

            count = 1;

        } else if (num == candidate) {

            count++;

        } else {

            count--;

        }

    }

    // Checking if potential majority element is the actual majority element

    count = 0;

    for (int num : nums) {

        if (num == candidate) {

            count++;

        }

    }

    if (count > nums.length / 2) {

        return candidate;

    } else {

        return -1;

    }

}

public static void main(String[] args) {

    int[] nums = {2, 4, 5, 5, 5, 5, 5};

    int result = findMajorityElement(nums);

    System.out.println(result); // Output: 5

}
}
