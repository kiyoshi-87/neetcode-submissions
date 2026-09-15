func twoSum(nums []int, target int) []int {
    seen := make(map[int]int)

    for index, value := range nums {
        diff := target - value

        index2, exists := seen[value]

        if exists {
            return []int{index2, index}
        }

        seen[diff] = index 
    }

    return []int{-1, -1};
}
