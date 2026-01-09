package hello.stack;

import java.util.Stack;

/**
 * Created by scnyig on 11/14/2017.
 * 递归 + 回溯 + 三个栈，枚举所有可能状态
 * 栈序列生成 / DFS 枚举问题/合法出栈序列
 */
public class SearchStack {
    public static void searchStack(Stack<Integer> input, Stack<Integer> stack, Stack<Integer> output) {
        if (input.isEmpty() && stack.isEmpty()) {
            System.out.println(output);
            return;
        }

        if (!input.isEmpty()) {
            stack.push(input.pop());
            searchStack(input, stack, output);
            input.push(stack.pop()); // 回溯
        }

        if (!stack.isEmpty()) {
            output.push(stack.pop());
            searchStack(input, stack, output);
            stack.push(output.pop()); // 回溯
        }

    }
}
