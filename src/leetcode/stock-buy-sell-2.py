## https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

prices = list(map(int, input().split()))

buy_day = 0
profit = 0

while buy_day < len(prices) - 1:
    sell_day = buy_day + 1
   
    while sell_day < len(prices):
        if prices[sell_day] < prices[sell_day - 1]:
            break
        sell_day += 1

    profit += prices[sell_day - 1] - prices[buy_day]
    buy_day = sell_day

print(profit)