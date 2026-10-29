from collections import deque


class Solution:
    """
    Leetcode 150: Evaluate Reverse Polish Notation
    """

    def evalRPN(self, tokens: list[str]) -> int:
        stack = deque()

        for t in tokens:
            if t in ["+","-","*","/"]:
                y = int(stack.pop())
                x = int(stack.pop())

                print(x,t,y)

                if t == "+":
                    stack.append(x + y)
                elif t == "-":
                    stack.append(x - y)
                elif t == "*":
                    stack.append(x * y)
                else:
                    stack.append(int(x / y)) # this truncate towards zero, do not use //
            else:
                stack.append(int(t))

        return stack.pop()


if __name__ == "__main__":
    sol = Solution()
    print(sol.evalRPN(["10","6","9","3","+","-11","*","/","*","17","+","5","+"]))