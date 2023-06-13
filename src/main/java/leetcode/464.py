class Solution:

    def canWin(self, options, reminders,memo):
        #if the current player can win
        if options[-1] >= reminders:
            return True

        #create something that can be put in a dict
        temp = tuple(options)
        #check for memoization
        if temp in memo:
            return memo[temp]

        #go through other player's options
        for i in range(len(options)):
            #if this person can win, then the other person can not
            #HOWEVER, ultimately this represents player 2 since the top is player 1 decision
            #so if player 2 wins, player 1 loses
            if not self.canWin(options[:i] + options[i + 1:], reminders - options[i],memo ):
                memo[temp] = True
                return True
        memo[temp] = False
        return False
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:

        if (desiredTotal <= maxChoosableInteger):
            return True

        #arithmetic series
        sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2
        if (sum < desiredTotal):
            return False

        options = []

        for i in range(1, maxChoosableInteger + 1):
            options.append(i)
        #memoization
        memo = {}
        return self.canWin(options, desiredTotal,memo )


