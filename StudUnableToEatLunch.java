class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            st.push(sandwiches[i]);
        }
        for (int student : students) {
            q.add(student);
        }
        int unableToEat = 0;
        while (!q.isEmpty()) {
            if (!st.isEmpty() && q.peek() == st.peek()) {
                q.poll();
                st.pop();
                unableToEat = 0;
            } else {
                unableToEat++;
                q.add(q.poll());
                if (unableToEat == q.size()) {
                    break;
                }
            }
        }
        return q.size();
    }
}
