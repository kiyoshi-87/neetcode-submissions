func rob(nums []int) int {
    n := len(nums)

    if n == 1 {
        return nums[0]
    }

    dp := make([]int, n)

    if n<=3 {
        return solve(nums)
    }

    dp[n-1] = nums[n-1]

    if nums[n-2] < nums[n-1] {
        dp[n-2] = nums[n-1]
    } else {
        dp[n-2] = nums[n-2]
    }


    for i := n - 3; i >= 0; i-- {
        cand1 := nums[i] + dp[i+2]
        cand2 := dp[i+1]
        if cand1 > cand2 {
            dp[i] = cand1
        } else {
            dp[i] = cand2
        }
    }

    return dp[0]
}

func solve(nums []int) int {
    sol1 := nums[0]

    if (len(nums) == 3){
        sol1 += nums[2]
    }
    sol2 := nums[1]

    if sol1>sol2 {
        return sol1
    }

    return sol2
}
