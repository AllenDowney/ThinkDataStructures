class Stack(object):
    def __init__(self, l=None):
        if l is None:
            l = []
        l.reverse()
        self.l = l
    def push(self, elem):
        self.l.append(elem)
    def pop(self):
        return self.l.pop()
    def peek(self):
        return self.l[-1]
    def isEmpty(self):
        return len(self.l) == 0
    def __len__(self):
        raise AttributeError()
    def __str__(self):
        self.l.reverse()
        s = str(self.l)
        self.l.reverse()
        return s

def merge_ll(head1, head2):
    if head1 is None:
        return head2
    if head2 is None:
        return head1
    new_ll = head1
    if head2.data < head1.data:
        new_ll = head2
        head2 = head2.next
    else:
        head1 = head1.next
    new_head = new_ll
    while not (head1 is None and head2 is None):
        if head1 is None:
            new_head.next = head2
            head2 = head2.next
        elif head2 is None:
            new_head.next = head1
            head1 = head1.next
        elif head1.data < head2.data:
            new_head.next = head1
            head1 = head1.next
        else :
            new_head.next = head2
            head2 = head2.next
        new_head = new_head.next
    return new_ll


def sorted_ll(head):

    second_head = head
    while second_head.next.data > second_head.data:
        second_head = second_head.next
    temp = second_head.next
    second_head.next = None
    second_head = temp

    return merge_ll(head, second_head)

def num_palindrome(i):
    j = i
    stack = Stack()
    while j != 0:
        stack.push(j%10)
        j/=10
    while not stack.isEmpty():
        if stack.pop() != i%10:
            return False
        i/=10
    return True

def valid_expr(s):
    stack = Stack()
    for c in s:
        if not stack.isEmpty() and c == ')' and stack.peek() == '(':
            stack.pop()
        else:
            stack.push(c)
    return stack.isEmpty()

def is_pop_sequence(s1, s2):
    s3 = Stack()
    while not s1.isEmpty():
        s3.push(s1.pop())
        while not s3.isEmpty() and s3.peek() == s2.peek():
            s3.pop()
            s2.pop()
    return s3.isEmpty()

def sorted_stack(stack):
    l = []
    while not stack.isEmpty():
        l.append(stack.pop())
    l = sorted(l, reverse=True)
    sorted_stack = Stack()
    for e in l:
        sorted_stack.push(e)
    return sorted_stack

def sorted_stack_one_stack(stack):
    sorted_stack = Stack()
    while not stack.isEmpty():
        var = stack.pop()
        while not sorted_stack.isEmpty() and sorted_stack.peek() < var:
            stack.push(sorted_stack.pop())
        sorted_stack.push(var)
    return sorted_stack

def longest_valid_substring(s):
    stack = Stack()
    for i, c in enumerate(s):
        if not stack.isEmpty() and c == ')' and s[stack.peek()] == '(':
            stack.pop()
        else:
            stack.push(i)
    end_valid = len(s)
    start_valid = len(s)
    longest = 0

    for i in range(len(s) - 1, -1, -1):
        if not stack.isEmpty() and stack.peek() == i:
            end_valid = i
            stack.pop()
        else:
            start_valid = i
            if end_valid - start_valid > longest:
                longest = end_valid - start_valid

    return longest

def solveHanoiHelper(fr, to, other, n):
    if n == 1:
        to.push(fr.pop())
    else:
        solveHanoiHelper(fr, other, to, n-1)
        solveHanoiHelper(fr, to, other, 1)
        solveHanoiHelper(other, to, fr, n-1)

def solveHanoi(left, middle, right, n):
    solveHanoiHelper(left, right, middle, n)

if __name__ == '__main__':
    print num_palindrome(123211) == False
    print valid_expr('()()()(())') == True
    print valid_expr('()()()(()))') == False
    print sorted_stack(Stack([1, 2, 3, 3, 4, 1, 9, 5, 7, 2]))
    print longest_valid_substring('()()()(()))') == 10
    print longest_valid_substring('())))') == 2
    print longest_valid_substring('(()))(') == 4
    print longest_valid_substring('))((') == 0
    print longest_valid_substring('') == 0
    l, m, r = Stack([1, 2, 3, 4, 5, 6]), Stack(), Stack()
    solveHanoi(l, m, r, 6)