def equal(head1, head2):

    while (head1 is not None) and (head2 is not None):
        if head1.val != head2.val:
            return False
        head1 = head1.next
        head2 = head2.next

    if head1 is None and head2 is None:
        return True

    return False

def reverseList(head):
    prev = None
    while head:
        curr = head
        head = head.next
        curr.next = prev
        prev = curr
    return prev

def hasCycle(head):
    if head is None or head.next is None:
        return False

    slow = head
    fast = head.next
    while fast.next!=None and fast.next.next!=None:
        slow = slow.next
        fast = fast.next.next
        if slow is fast:
            return True
    return False

def find_nth(head, n):
    while n > 0 and head is not None:
        head = head.next
        n -= 1
    return head

def length(head):
    l = 0
    while head is not None:
        head = head.next
        l+=1
    return l

def palindrome(head):

    l = length(head)

    if l <= 1:
        return True

    left_of_middle = find_nth(head, l/2 - 1)
    # if linkedlist has odd number of elements, drop the middle element
    if (l % 2) == 1:
        left_of_middle.next = left_of_middle.next.next

    # reverse the back half of the linked list
    left_of_middle.next = reverseList(left_of_middle.next)

    # seperate the front and back half of the LL into seperate Lists
    middle = left_of_middle.next
    left_of_middle.next = None

    # check equality
    return equal(head, middle)

def intersection(head1, head2):
    l1 = length(head1)
    l2 = length(head2)
    long_list, short_list = head1, head2
    if l2 > l1:
        long_list, short_list = head2, head1
    long_list = find_nth(long_list, abs(l1-l2))
    while long_list is not None:
        if long_list == short_list:
            return long_list
        long_list = long_list.next
        short_list = short_list.next
    return None

def print_rev(head):
    last_elem = find_nth(length(head) - 1)
    while last_elem is not None:
        print last_elem
        last_elem = last_elem.prev

def palindrome_dll(head):
    l = length(head)
    if l <= 1:
        return True
    last_elem = find_nth(l - 1)
    while head is not None:
        if head != last_elem:
            return False
        head = head.next
        last_elem = last_elem.prev
    return True
