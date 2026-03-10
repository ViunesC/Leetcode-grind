from typing import List

class Solution:
    """
    Leetcode 721: Accounts Merge
    """
    
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        self.ea_map = {}
        for i in range(len(accounts)):
            for j in range(1, len(accounts[i])):
                if accounts[i][j] not in self.ea_map:
                    self.ea_map[accounts[i][j]] = [i]
                else:
                    self.ea_map[accounts[i][j]].append(i)
        self.visited = [False for _ in range(len(accounts))]

        results = []
        for i in range(len(accounts)):
            if self.visited[i]:
                continue
            emails = set()
            self.dfs(i, accounts, emails)
            results.append([accounts[i][0]] + sorted(emails))
        
        return results

    def dfs(self, i, accounts, emails):
        if self.visited[i]:
            return
        
        self.visited[i] = True
        for j in range(1, len(accounts[i])):
            emails.add(accounts[i][j])
            for neighbor in self.ea_map[accounts[i][j]]:
                self.dfs(neighbor, accounts, emails)