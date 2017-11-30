package samples.algorithms.cracking;

public class Lists {

  public static void main(String... args) {

    System.out.println(partition(listOf(3, 5, 8, 5, 10, 2, 1), 5));

    // Numbers are in reverse order
    Node num1 = listOf(3, 9, 2);
    Node num2 = listOf(3, 4, 9, 2, 3);
    System.out.println(sum(num1, num2, 10));

    // Numbers are in normal order
    Node num3 = listOf(      2, 9, 3);
    Node num4 = listOf(3, 2, 9, 4, 3);
    System.out.println(sumFwd(num3, num4, 10));
  }

  /** Sums the numbers of the linked lists, in the given base */
  static Node sumFwd(Node n1, Node n2, int base) {
    return reverse(sum(reverse(n1), reverse(n2), base));
  }

  /** Sums the numbers of the linked lists (they are reversed), in the given base (returns the result reversed too) */
  static Node sum(Node num1, Node num2, int base) {

    if (num1 == null || num2 == null) return null;

    int c = 0;
    Node result = new Node(c); // we keep the carry in the next node
    Node current = result;
    Node prev = null;

    while (num1 != null || num2 != null) {

      int s = sum1(num1, num2, c);
      current.data = s % base;
      c = s / base;

      num1 = num1 != null ? num1.next : null;
      num2 = num2 != null ? num2.next : null;

      current.next = new Node(c);
      prev = current;
      current = current.next;
    }

    if (current.data == 0) {
      prev.next = null;
    }

    return result;
  }

  /** sums the data in the nodes, plus the carry c */
  static int sum1(Node n1, Node n2, int c) {

    int x1 = n1 != null ? n1.data : 0;
    int x2 = n2 != null ? n2.data : 0;
    return x1 + x2 + c;
  }

  static Node partition(Node list, int value) {

    // dummy nodes for easily appending
    Node left = new Node(0);
    Node right = new Node(0);

    Node curLeft = left;
    Node curRight = right;

    Node current = list;

    while (current != null) {
      if (current.data < value) {
        curLeft.next = current;
        curLeft = curLeft.next;
      } else {
        curRight.next = current;
        curRight = curRight.next;
      }

      current = current.next;
    }

    // clear right ending
    curRight.next = null;

    // connect left and right
    curLeft.next = right.next;

    return left.next;
  }

  static Node reverse(Node list) {

    Node result = null;

    Node current = list;
    while (current != null) {
      Node temp = current.next;
      current.next = result;
      result = current;
      current = temp;
    }

    return result;
  }

  static void remove(Node list, Node target) {
    Node current = list;
    while (current.next != target) current = current.next;
    current.next = current.next.next;
  }

  static Node listOf(int... values) {
    Node list = new Node(values[0]);
    Node current = list;
    for (int i=1; i<values.length; i++) {
      current.next = new Node(values[i]);
      current = current.next;
    }
    return list;
  }
}


class Node {

  Node(int data, Node next) {
    this.data = data;
    this.next = next;
  }

  Node(int data) {
    this(data, null);
  }

  int data;
  Node next;

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();

    Node node = this;
    while (node != null) {
      sb.append(node.data).append(" ");
      node = node.next;
    }

    return sb.toString();
  }
}
