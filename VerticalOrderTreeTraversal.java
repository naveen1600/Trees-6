// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();

        q.add(new Pair<>(root, 0));
        int min = 0;
        int max = 0;

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode curr = p.getKey();
            int val = p.getValue();

            if (val < min)
                min = val;
            if (val > max)
                max = val;

            if (!map.containsKey(val))
                map.put(val, new ArrayList<>());
            map.get(val).add(curr.val);

            if (curr.left != null)
                q.add(new Pair<>(curr.left, val - 1));

            if (curr.right != null)
                q.add(new Pair<>(curr.right, val + 1));
        }

        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }

        return result;
    }
}