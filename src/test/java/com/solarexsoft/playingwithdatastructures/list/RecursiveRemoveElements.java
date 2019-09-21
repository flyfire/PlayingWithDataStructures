package com.solarexsoft.playingwithdatastructures.list;

/**
 * Created by houruhou on 2019/9/21.
 * Desc:
 */
public class RecursiveRemoveElements {
    static ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepth(depth);
        System.out.print(depthString);
        System.out.println("call remove " + val + " in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("return null");
            return null;
        }
        ListNode res = removeElements(head.next, val, depth+1);
        System.out.print(depthString);
        System.out.println("after remove " + val + " res = " + res);
        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("return " + ret);
        return ret;
    }

    static String generateDepth(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 6, 3, 2};
        ListNode head = new ListNode(nums);
        removeElements(head, 6, 0);
    }
    /*
call remove 6 in 1 -> 2 -> 5 -> 6 -> 3 -> 2 -> null
--call remove 6 in 2 -> 5 -> 6 -> 3 -> 2 -> null
----call remove 6 in 5 -> 6 -> 3 -> 2 -> null
------call remove 6 in 6 -> 3 -> 2 -> null
--------call remove 6 in 3 -> 2 -> null
----------call remove 6 in 2 -> null
------------call remove 6 in null
------------return null
----------after remove 6 res = null
----------return 2 -> null
--------after remove 6 res = 2 -> null
--------return 3 -> 2 -> null
------after remove 6 res = 3 -> 2 -> null
------return 3 -> 2 -> null
----after remove 6 res = 3 -> 2 -> null
----return 5 -> 3 -> 2 -> null
--after remove 6 res = 5 -> 3 -> 2 -> null
--return 2 -> 5 -> 3 -> 2 -> null
after remove 6 res = 2 -> 5 -> 3 -> 2 -> null
return 1 -> 2 -> 5 -> 3 -> 2 -> null
     */
}
