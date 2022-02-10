// Problem : https://practice.geeksforgeeks.org/problems/sort-a-stack/1#
// 5 [3 2 4 1] -> [1 2 3 4 5]
// 1 [3 2 4] -> [2 3 4] push(1) -> [1 2 3 4]
// 4 [3 2] -> [2 3] push (4) -> [2 3 4]
// 3 [2] -> [2 3]
// 2 [2]
//
// O(N^2) Time + O(N) Recursive Call Stack Aux Space
/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> stack)
	{
		//add code here.
		push(Integer.MIN_VALUE, stack);
		return stack;
	}
	
	void push(int element, Stack<Integer> stack) {
	    // base case
	    if (stack.isEmpty() || element >= stack.peek()) {
	        if (element != Integer.MIN_VALUE) {
	            stack.add(element);
	        }
	    } else {
	        int top = stack.peek();
	        stack.pop();
	        push(element, stack);
	        push(top, stack);
	    }
	}
}
