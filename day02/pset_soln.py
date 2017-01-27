def swap(arr, i, j):
    temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp

# Find either the min or max element's index, starting from start
def index_find(arr, func, start=0):
    m = start
    for i in range(start+1, len(arr)):
        if func=='min' and arr[i] < arr[m]:
            m = i
        if func=='max' and arr[i] > arr[m]:
            m = i
    return m

# O(N^2) time
def min_pairs(arr):
    f_map = {0: 'min', 1: 'max'}
    # alternate placing minimum and maximum elements
    for i in range(len(arr)):
        swap(arr, i, index_find(arr, f_map[i%2], i))
    return arr


# If you're curious, here's the NlogN time solution
def min_pairs_faster(arr):
    arr = sorted(arr) # O(NlogN)
    for i in range(1, len(arr)/2, 2): # O(N)
        swap(arr, i, len(arr)-i)
    return arr

def equal(head1, head2):

    while (head1 is not None) and (head2 is not None):
        if head1.data != head2.data:
            return False
        head1 = head1.next
        head2 = head2.next

    return (head1 is None and head2 is None)

def reverseList(head):
    prev = None
    while head:
        curr = head
        head = head.next
        curr.next = prev
        prev = curr
    return prev

def hasCycle(head):
    slow = head
    fast = head
    while fast!=None and fast.next!=None:
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

def find_nth_from_end(head, n):
    fast = head
    slow = head
    for i in range(n):
        fast = fast.next
    while fast is not None:
        fast = fast.next
        slow = slow.next
    return slow

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

    # separate the front and back half of the LL into separate Lists
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
    last_elem = find_nth_from_end(1)
    while last_elem is not None:
        print last_elem
        last_elem = last_elem.prev

def palindrome_dll(head):
    l = length(head)
    if l <= 1:
        return True
    last_elem = find_nth_from_end(1)
    while head is not None:
        if head != last_elem:
            return False
        head = head.next
        last_elem = last_elem.prev
    return True
