// Time Complexity: O(n)
// Space Complexity: O(n)

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();

        serializeHelper(root, sb);

        return sb.toString();

    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        // base
        if (root == null) {
            sb.append("#");
            sb.append(",");
            return;
        }

        // logic
        sb.append(root.val);
        sb.append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    private int i;

    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;

        String[] strArr = data.split(",");

        return deserializeHelper(strArr);
    }

    private TreeNode deserializeHelper(String[] strArr) {
        // base
        if (strArr[i].equals("#")) {
            i++;
            return null;
        }

        // logic
        TreeNode root = new TreeNode(Integer.parseInt(strArr[i]));
        i++;
        root.left = deserializeHelper(strArr);
        root.right = deserializeHelper(strArr);

        return root;
    }
}