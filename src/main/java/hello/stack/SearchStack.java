package hello.stack;

/**
 * Created by scnyig on 11/14/2017.
 */
public class SearchStack {
    public static void SearchStack(Stack<int> input, Stack<int> stack, Stack<int> output)
    {
        if (input.Count == 0 && stack.Count == 0)
        {
            System.out.println();;
            //������
            Array array = output.ToArray();
            foreach (int obj in array)
            Console.Write(obj);
            Console.WriteLine("");

        }
        else
        {
            if (input.Count > 0)
            {
                //��ջ
                stack.Push(input.Pop());
                SearchStack(input, stack, output);
                input.Push(stack.Pop());
            }

            if (stack.Count > 0)
            {
                //��ջ
                output.Push(stack.Pop());
                SearchStack(input, stack, output);
                stack.Push(output.Pop());
            }
        }
    }
}
