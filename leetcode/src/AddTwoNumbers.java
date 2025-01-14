import java.util.Arrays;

public class AddTwoNumbers {

    public static void main(String[] args) {
        int[] arr1 = {9, 9, 9, 9, 9, 9, 9};
        int[] arr2 = {9, 9, 9, 9};
        ListNode l1 = ListNode.arrayToListNode(arr1);
        ListNode l2 = ListNode.arrayToListNode(arr2);
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        int sum = 0;
        while (l1 != null || l2 != null || sum != 0) {
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            sum = sum > 9 ? 1 : 0;
        }
        return result.next;
    }
}
